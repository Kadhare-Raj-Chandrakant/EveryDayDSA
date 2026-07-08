"""Alternative LeetCode problem fetcher using noworneverev/leetcode-api (Vercel-hosted).

Provides a secondary live API source for LeetCode problems with a different
hosting backend, as a fallback when the primary alfa-leetcode-api is rate-limited
or unreachable.

API docs: https://github.com/noworneverev/leetcode-api
Base URL: https://leetcode-api-pied.vercel.app

Endpoints used:
    GET /random          → Random problem {title, title_slug, difficulty, url}
    GET /problem/{slug}  → Full problem details (content, hints, snippets, etc.)
"""

from __future__ import annotations

import logging
import random
import re
import time
from typing import Any

import requests

from src.ingestion.base import IngestionError, ProblemFetcher
from src.models.problem import Difficulty, ProblemContext

log = logging.getLogger("githubgreencard")


class AltLeetCodeFetcher(ProblemFetcher):
    """Fetch LeetCode problems from the Vercel-hosted noworneverev/leetcode-api.

    This is a secondary live API source that wraps the same LeetCode GraphQL
    under the hood but runs on Vercel rather than Render, so it has different
    rate-limit characteristics.

    Falls back gracefully if the API is unreachable or returns incomplete data.
    """

    def __init__(
        self,
        api_url: str = "https://leetcode-api-pied.vercel.app",
        timeout: int = 30,
        language: str = "cpp",
    ):
        self.api_url = api_url.rstrip("/")
        self.timeout = timeout
        self.language = language
        self.session = requests.Session()
        self.session.headers.update({
            "Accept": "application/json",
            "User-Agent": (
                "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 "
                "(KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36"
            ),
        })
        self.max_retries_429 = 3

    # ── public interface ────────────────────────────────────────────────

    def fetch(self, exclude_slugs: set[str] | None = None) -> ProblemContext:
        """Fetch a random unsolved problem from the Vercel-hosted API.

        Calls ``/random`` to pick a problem, then ``/problem/{slug}`` for
        full detail. Retries if the random pick lands on an excluded slug.
        """
        exclude = exclude_slugs or set()
        log.info("Finding random problem via Vercel API (excluding %d solved)...", len(exclude))

        for attempt in range(self.max_retries_429 + 5):  # generous retries
            try:
                # Step 1: get a random problem slug
                slug = self._random_slug()
                if slug in exclude:
                    log.debug("Random pick '%s' already solved — retrying...", slug)
                    continue

                # Step 2: fetch full detail
                return self.fetch_by_slug(slug)
            except IngestionError:
                raise
            except requests.RequestException as e:
                log.debug("Vercel API request failed (attempt %d): %s", attempt + 1, e)
                if attempt >= self.max_retries_429 + 4:
                    raise IngestionError(f"Vercel API unreachable after retries: {e}") from e

        raise IngestionError(
            "Could not find an unsolved problem via Vercel API — "
            "all random picks were already solved."
        )

    def fetch_by_slug(self, title_slug: str) -> ProblemContext:
        """Fetch a specific problem by its slug with full metadata."""
        log.info("Fetching problem detail via Vercel API: %s", title_slug)
        try:
            resp = self._get_with_retry(f"{self.api_url}/problem/{title_slug}")
            data = resp.json()
        except requests.RequestException as e:
            raise IngestionError(f"Vercel API error fetching '{title_slug}': {e}") from e
        return self._parse_problem(data, title_slug)

    # ── internal helpers ────────────────────────────────────────────────

    def _random_slug(self) -> str:
        """Call /random and return the title_slug."""
        resp = self._get_with_retry(f"{self.api_url}/random")
        data = resp.json()
        slug = data.get("title_slug", "")
        if not slug:
            raise IngestionError("Vercel /random returned no title_slug")
        return slug

    def _get_with_retry(self, url: str, params: dict | None = None) -> requests.Response:
        """GET with exponential backoff on 429 / 5xx."""
        for attempt in range(self.max_retries_429):
            try:
                resp = self.session.get(url, params=params, timeout=self.timeout)
            except requests.ConnectionError as e:
                log.debug("Connection error on %s — retry %d/%d", url, attempt + 1, self.max_retries_429)
                time.sleep(2 ** attempt)
                continue

            if resp.status_code in (429, 502, 503, 504):
                wait = 2 ** attempt
                log.warning(
                    "API %s (%d) on %s — retry %d/%d in %ds",
                    "rate-limited" if resp.status_code == 429 else "down",
                    resp.status_code,
                    url, attempt + 1, self.max_retries_429, wait,
                )
                time.sleep(wait)
                continue
            resp.raise_for_status()
            return resp

        raise IngestionError(
            f"Vercel API failed on {url} after {self.max_retries_429} retries."
        )

    # ── parsing ─────────────────────────────────────────────────────────

    def _parse_problem(self, data: dict[str, Any], title_slug: str) -> ProblemContext:
        """Parse the Vercel API response into a ProblemContext.

        The Vercel API returns LeetCode fields at the top level
        (no ``data.question`` wrapper like alfa-leetcode-api).
        """
        title = data.get("title", "Unknown")
        difficulty_str = data.get("difficulty", "Medium")
        difficulty = Difficulty(difficulty_str)

        # Description from HTML content
        raw_html = data.get("content", "")
        description = self._strip_html(raw_html)
        constraints = self._extract_constraints(raw_html)

        # Parse example test cases from the raw field
        raw = data.get("exampleTestcases", "")
        examples = self._parse_examples(raw)

        # Boilerplate code for target language
        boilerplate = ""
        code_snippets = data.get("codeSnippets", [])
        for snippet in code_snippets:
            if snippet.get("langSlug") == self.language:
                boilerplate = snippet.get("code", "")
                break
        if not boilerplate and code_snippets:
            boilerplate = code_snippets[0].get("code", "")

        hints = data.get("hints", [])
        source_url = f"https://leetcode.com/problems/{title_slug}/"

        return ProblemContext(
            title=title,
            difficulty=difficulty,
            description=description,
            constraints=constraints,
            examples=examples,
            boilerplate=boilerplate,
            source_url=source_url,
            source="alt-leetcode",
            language=self.language,
            hints=hints,
        )

    @staticmethod
    def _parse_examples(raw: str) -> list[dict]:
        """Parse newline-delimited exampleTestcases into input/output pairs."""
        if not raw:
            return []
        parts = raw.strip().split("\n")
        examples = []
        for i in range(0, len(parts), 2):
            if i + 1 < len(parts):
                examples.append({"input": parts[i], "output": parts[i + 1]})
        return examples

    @staticmethod
    def _strip_html(html: str) -> str:
        """Remove HTML tags from the problem description."""
        text = re.sub(r"<[^>]+>", "", html)
        text = text.replace("&nbsp;", " ").replace("&lt;", "<").replace("&gt;", ">")
        text = text.replace("&amp;", "&").replace("&quot;", '"').replace("&#39;", "'")
        return text.strip()

    @staticmethod
    def _extract_constraints(html: str) -> str:
        """Extract the constraints section from HTML problem description."""
        match = re.search(
            r"<p><strong>(?:Constraints|Constraints:)</strong></p>\s*(.*?)(?:</ul>|<p>|$)",
            html,
            re.DOTALL,
        )
        if match:
            return AltLeetCodeFetcher._strip_html(match.group(1))
        return ""
