"""Local backlog ingestion — the fail-safe fallback when LeetCode is unavailable."""

from __future__ import annotations

import json
import logging
import random
import re
from pathlib import Path

from src.ingestion.base import ProblemFetcher, IngestionError
from src.models.problem import ProblemContext

log = logging.getLogger(__name__)


class BacklogFetcher(ProblemFetcher):
    """Fetches a random problem from the local backlog.json file.

    Activated when LeetCodeFetcher fails (network, rate-limit, API change).
    """

    def __init__(self, file_path: str | Path = "backlog.json", language: str = "cpp"):
        self.file_path = Path(file_path)
        self.language = language

    def fetch(self, exclude_slugs: set[str] | None = None) -> ProblemContext:
        """Pick a random unsolved problem from the backlog.

        Args:
            exclude_slugs: Set of kebab-case title slugs to exclude (already solved).

        Returns:
            A ProblemContext for a previously unsolved problem.

        Raises:
            IngestionError: If no unsolved problems remain in the backlog.
        """
        exclude = exclude_slugs or set()
        log.info("Fetching problem from backlog (excluding %d solved): %s",
                 len(exclude), self.file_path)

        if not self.file_path.exists():
            raise IngestionError(
                f"Backlog file not found: {self.file_path}. "
                "Create a backlog.json with at least one problem entry."
            )

        try:
            with open(self.file_path, "r") as f:
                entries = json.load(f)
        except (json.JSONDecodeError, OSError) as e:
            raise IngestionError(f"Failed to read backlog: {e}") from e

        if not entries:
            raise IngestionError("Backlog is empty — no problems available.")

        if exclude:
            def _to_slug(title: str) -> str:
                return re.sub(r"[^a-zA-Z0-9]+", "-", title.strip()).strip("-").lower()

            candidates = [e for e in entries if _to_slug(e["title"]) not in exclude]
            if not candidates:
                raise IngestionError(
                    "All backlog problems have already been solved."
                )
            entry = random.choice(candidates)
        else:
            entry = random.choice(entries)

        log.info("Selected backlog problem: %s", entry["title"])
        return ProblemContext.from_backlog_entry(entry, language=self.language)
