"""LeetCode ingestion via alfa-leetcode-api REST API — the primary problem source.

API docs: https://github.com/alfaarghya/alfa-leetcode-api
Base URL: https://alfa-leetcode-api.onrender.com
Endpoints:
  GET /daily       — Daily challenge problem
  GET /select?titleSlug=<slug>  — Specific problem by slug
"""

from __future__ import annotations

import logging
from typing import Any

import requests

from src.ingestion.base import ProblemFetcher, IngestionError
from src.models.problem import ProblemContext, Difficulty

log = logging.getLogger(__name__)


class LeetCodeFetcher(ProblemFetcher):
    """Fetches LeetCode problems via the alfa-leetcode-api REST API.

    No authentication required. The API returns problems with description,
    examples, tags, and hints — but no code snippets/boilerplate.
    """

    def __init__(
        self,
        api_url: str = "https://alfa-leetcode-api.onrender.com",
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

    def fetch(self) -> ProblemContext:
        """Fetch the daily challenge from LeetCode."""
        log.info("Fetching LeetCode daily challenge from %s/daily", self.api_url)
        try:
            resp = self.session.get(
                f"{self.api_url}/daily",
                timeout=self.timeout,
            )
            resp.raise_for_status()
            data = resp.json()
            return self._parse_problem(data)
        except requests.RequestException as e:
            raise IngestionError(f"Network error fetching daily problem: {e}") from e

    def fetch_by_slug(self, title_slug: str) -> ProblemContext:
        """Fetch a specific problem by its slug (e.g., 'two-sum')."""
        log.info("Fetching problem by slug: %s", title_slug)
        try:
            resp = self.session.get(
                f"{self.api_url}/select",
                params={"titleSlug": title_slug},
                timeout=self.timeout,
            )
            resp.raise_for_status()
            data = resp.json()
            return self._parse_problem(data)
        except requests.RequestException as e:
            raise IngestionError(
                f"Network error fetching '{title_slug}': {e}"
            ) from e

    def _parse_problem(self, data: dict[str, Any]) -> ProblemContext:
        """Parse the API response into a ProblemContext.

        The alfa-leetcode-api returns a flat JSON object (no GraphQL nesting).
        """
        title = data.get("questionTitle", data.get("title", "Unknown"))
        difficulty_str = data.get("difficulty", "Medium")
        difficulty = Difficulty(difficulty_str)

        # Extract description from HTML content
        description = data.get("question", "")
        # Strip HTML tags for a cleaner description
        description = self._strip_html(description)

        # Parse constraints from the description (look for "Constraints:" section)
        constraints = self._extract_constraints(data.get("question", ""))

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

        title_slug = data.get("titleSlug", "")
        source_url = f"https://leetcode.com/problems/{title_slug}/"

        # No code snippets from this API — boilerplate is empty
        boilerplate = ""

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
        )

    @staticmethod
    def _strip_html(html: str) -> str:
        """Remove HTML tags from the problem description."""
        import re
        # Remove HTML tags
        text = re.sub(r"<[^>]+>", "", html)
        # Decode common HTML entities
        text = text.replace("&nbsp;", " ").replace("&lt;", "<").replace("&gt;", ">")
        text = text.replace("&amp;", "&").replace("&quot;", '"').replace("&#39;", "'")
        # Collapse multiple newlines
        import textwrap
        return textwrap.dedent(text).strip()

    @staticmethod
    def _extract_constraints(html: str) -> str:
        """Extract the constraints section from HTML problem description."""
        import re
        # Look for content after "Constraints:" heading
        match = re.search(
            r"<p><strong>(?:Constraints|Constraints:)</strong></p>\s*(.*?)(?:</ul>|<p>|$)",
            html,
            re.DOTALL,
        )
        if match:
            constraints_html = match.group(1)
            return LeetCodeFetcher._strip_html(constraints_html)
        return ""
