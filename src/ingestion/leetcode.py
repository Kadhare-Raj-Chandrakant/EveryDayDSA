"""LeetCode ingestion via alfa-leetcode-api REST API — the primary problem source.

API docs: https://github.com/alfaarghya/alfa-leetcode-api
Base URL: https://alfa-leetcode-api.onrender.com
Endpoints:
  GET /problems?limit=N&skip=N  — Problem list (paginated)
  GET /select/raw?titleSlug=<slug>  — Specific problem with full data
"""

from __future__ import annotations

import logging
import random
import re
import time
from typing import Any

import requests

from src.ingestion.base import ProblemFetcher, IngestionError
from src.models.problem import ProblemContext, Difficulty

log = logging.getLogger(__name__)


class LeetCodeFetcher(ProblemFetcher):
    """Fetches a random LeetCode problem via the alfa-leetcode-api REST API.

    Strategy:
    1. Fetch a random page from /problems list (skipping paid-only)
    2. Pick a random problem from that page
    3. Fetch full details via /select/raw with the titleSlug

    Provides full problem data including:
    - codeSnippets (exact LeetCode boilerplate with correct method signature)
    - hints (algorithmic guidance)
    """

    def __init__(
        self,
        api_url: str = "https://alfa-leetcode-api.onrender.com",
        timeout: int = 30,
        language: str = "cpp",
        page_size: int = 50,
    ):
        self.api_url = api_url.rstrip("/")
        self.timeout = timeout
        self.language = language
        self.page_size = page_size
        self.session = requests.Session()
        self.session.headers.update({
            "Accept": "application/json",
            "User-Agent": (
                "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 "
                "(KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36"
            ),
        })
        self.max_retries_429 = 3

    def _get_with_retry(self, url: str, params: dict | None = None) -> requests.Response:
        """GET with exponential backoff on 429 rate limit.

        Retries up to ``max_retries_429`` times with 2, 4, 8 second delays.
        All other HTTP errors propagate immediately.
        """
        for attempt in range(self.max_retries_429):
            resp = self.session.get(url, params=params, timeout=self.timeout)
            if resp.status_code == 429:
                wait = 2 ** attempt
                log.warning(
                    "Rate limited (429) on %s — retry %d/%d in %ds",
                    url, attempt + 1, self.max_retries_429, wait,
                )
                time.sleep(wait)
                continue
            resp.raise_for_status()
            return resp
        raise IngestionError(
            f"Rate limited on {url} after {self.max_retries_429} retries."
        )

    def fetch(self, exclude_slugs: set[str] | None = None) -> ProblemContext:
        """Fetch a random unsolved LeetCode problem with full metadata.

        Args:
            exclude_slugs: Set of kebab-case title slugs to exclude (already solved).

        Returns:
            A ProblemContext for a previously unsolved problem.

        Raises:
            IngestionError: If no unsolved problems could be found after retries.
        """
        exclude = exclude_slugs or set()
        log.info("Finding random LeetCode problem (excluding %d solved)...", len(exclude))
        total = self._get_total_problems()
        log.debug("Total problems available: %d", total)

        # Retry with different pages until we find an unsolved problem
        max_retries = 10
        for attempt in range(max_retries):
            max_skip = max(0, total - self.page_size)
            skip = random.randint(0, max_skip)
            problems = self._list_problems(skip=skip)
            log.debug("Fetched %d problems at offset %d (attempt %d/%d)",
                      len(problems), skip, attempt + 1, max_retries)

            if not problems:
                continue

            # Filter out paid-only and already-solved problems
            candidates = [
                p for p in problems
                if not p.get("isPaidOnly")
                and p.get("titleSlug") not in exclude
            ]
            if candidates:
                chosen = random.choice(candidates)
                title_slug = chosen["titleSlug"]
                log.info("Selected: %s (%s)", chosen["title"], chosen["difficulty"])
                return self.fetch_by_slug(title_slug)

            log.debug("All problems on this page are already solved — retrying...")

        raise IngestionError(
            f"No unsolved problems found after {max_retries} attempts. "
            f"Either all available problems have been solved, or the remaining "
            f"ones are paid-only."
        )

    def fetch_multiple(
        self,
        count: int,
        exclude_slugs: set[str] | None = None,
    ) -> list[ProblemContext]:
        """Fetch multiple distinct unsolved problems in one batch.

        More efficient than calling ``fetch()`` N times — fetches a larger
        page of listings once, then picks ``count`` distinct unsolved problems.

        Args:
            count: Number of problems to fetch.
            exclude_slugs: Set of already-solved title slugs to exclude.

        Returns:
            List of ``ProblemContext`` objects, one per problem.

        Raises:
            IngestionError: If fewer than ``count`` unsolved problems are found.
        """
        exclude = exclude_slugs or set()
        log.info("Fetching %d problems (excluding %d solved)...", count, len(exclude))

        # Fetch a large listing to find enough candidates
        total = self._get_total_problems()
        fetch_size = max(self.page_size * 3, count * 5)
        max_skip = max(0, total - fetch_size)

        for attempt in range(5):
            skip = random.randint(0, max_skip)
            problems = self._list_problems(limit=fetch_size, skip=skip)

            candidates = [
                p for p in problems
                if not p.get("isPaidOnly")
                and p.get("titleSlug") not in exclude
            ]
            if len(candidates) >= count:
                chosen = random.sample(candidates, count)
                results: list[ProblemContext] = []
                for c in chosen:
                    slug = c["titleSlug"]
                    log.info("Selected: %s (%s)", c["title"], c["difficulty"])
                    ctx = self.fetch_by_slug(slug)
                    # Mark as solved so subsequent problems don't re-pick
                    exclude.add(slug)
                    results.append(ctx)
                return results

            log.debug(
                "Only %d/%d candidates found (attempt %d/5) — retrying...",
                len(candidates), count, attempt + 1,
            )

        raise IngestionError(
            f"Could not find {count} unsolved problems after 5 attempts. "
            f"Only {len([p for p in problems if not p.get('isPaidOnly')])} "
            f"free problems remain available."
        )

    def _get_total_problems(self) -> int:
        """Get the total number of problems available."""
        try:
            resp = self._get_with_retry(f"{self.api_url}/problems", params={"limit": 1})
            data = resp.json()
            return data.get("totalQuestions", 0)
        except requests.RequestException as e:
            raise IngestionError(f"Failed to get problem count: {e}") from e

    def _list_problems(self, skip: int = 0, limit: int | None = None) -> list[dict]:
        """Fetch a page of problems from the listing endpoint."""
        try:
            resp = self._get_with_retry(
                f"{self.api_url}/problems",
                params={"limit": limit or self.page_size, "skip": skip},
            )
            data = resp.json()
            return data.get("problemsetQuestionList", [])
        except requests.RequestException as e:
            raise IngestionError(f"Failed to list problems: {e}") from e

    def fetch_by_slug(self, title_slug: str) -> ProblemContext:
        """Fetch a specific problem by its slug (e.g., 'two-sum') with full metadata."""
        log.info("Fetching problem by slug: %s", title_slug)
        try:
            resp = self._get_with_retry(
                f"{self.api_url}/select/raw",
                params={"titleSlug": title_slug},
            )
            data = resp.json()
            return self._parse_problem(data.get("question", data))
        except requests.RequestException as e:
            raise IngestionError(
                f"Network error fetching '{title_slug}': {e}"
            ) from e

    def _parse_problem(self, data: dict[str, Any]) -> ProblemContext:
        """Parse the raw API response into a ProblemContext.

        The raw endpoint returns the full LeetCode question object with:
        - codeSnippets: exact boilerplate per language
        - hints: algorithmic hints
        - metaData: function signature metadata
        """
        title = data.get("title", data.get("questionTitle", "Unknown"))
        difficulty_str = data.get("difficulty", "Medium")
        difficulty = Difficulty(difficulty_str)

        # Extract description from HTML content
        raw_html = data.get("content", data.get("question", ""))
        description = self._strip_html(raw_html)
        constraints = self._extract_constraints(raw_html)

        # Parse example test cases
        raw = data.get("exampleTestcases", "")
        examples = []
        if raw:
            parts = raw.strip().split("\n")
            for i in range(0, len(parts), 2):
                if i + 1 < len(parts):
                    examples.append({
                        "input": parts[i],
                        "output": parts[i + 1],
                    })

        # Extract exact LeetCode boilerplate for the target language
        boilerplate = ""
        code_snippets = data.get("codeSnippets", [])
        for snippet in code_snippets:
            if snippet.get("langSlug") == self.language:
                boilerplate = snippet.get("code", "")
                log.debug("Found C++ boilerplate: %s chars", len(boilerplate))
                break
        # Fallback: use first available snippet
        if not boilerplate and code_snippets:
            boilerplate = code_snippets[0].get("code", "")

        # Extract hints
        hints = data.get("hints", [])

        title_slug = data.get("titleSlug", "")
        source_url = f"https://leetcode.com/problems/{title_slug}/"

        return ProblemContext(
            title=title,
            difficulty=difficulty,
            description=description,
            constraints=constraints,
            examples=examples,
            boilerplate=boilerplate,
            source_url=source_url,
            source="leetcode",
            language=self.language,
            hints=hints,
        )

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
            return LeetCodeFetcher._strip_html(match.group(1))
        return ""
