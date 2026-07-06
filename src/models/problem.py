"""Problem data model — the core contract across all pipeline stages."""

from __future__ import annotations

import random
import re
from dataclasses import dataclass, field
from datetime import date
from enum import Enum
from typing import Optional


class Difficulty(str, Enum):
    EASY = "Easy"
    MEDIUM = "Medium"
    HARD = "Hard"


@dataclass
class ProblemContext:
    """Unified problem representation produced by ingestion, consumed by execution.

    This is THE contract between Module 1 (Ingestion) and Module 2 (Execution).
    Both primary (LeetCode) and fallback (Backlog) paths must produce this.
    """

    title: str
    """Problem title, e.g. 'Two Sum'."""

    difficulty: Difficulty
    """Problem difficulty level."""

    description: str
    """Full problem description in markdown."""

    constraints: str
    """Problem constraints, typically a list of bounds."""

    examples: list[dict] = field(default_factory=list)
    """List of example test cases, each with 'input' and 'output' keys."""

    boilerplate: str = ""
    """Language-specific code stub / starting template."""

    source_url: str = ""
    """URL where this problem was sourced (e.g., LeetCode link)."""

    source: str = "backlog"
    """Origin identifier: 'leetcode', 'backlog', or custom."""

    solved_date: str = field(default_factory=lambda: date.today().isoformat())
    """Date this problem was solved (ISO format)."""

    language: str = "cpp"
    """Target solution language."""

    hints: list[str] = field(default_factory=list)
    """Algorithmic hints from LeetCode (useful for guiding the LLM)."""

    def folder_name(self) -> str:
        """Generate the standardized folder name for this problem.

        Format: YYYY-MM-DD-Problem-Name (kebab-case)
        """
        kebab = re.sub(r"[^a-zA-Z0-9]+", "-", self.title.strip()).strip("-").lower()
        return f"{self.solved_date}-{kebab}"

    def commit_message(self) -> str:
        """Generate a human-like commit message.

        Picks from a broad set of templates so messages look naturally varied
        across different commits. Avoids bot markers like "Docs:" or "Auto-solve".
        """
        msg = self.title
        diff = self.difficulty.value
        templates = [
            # Plain statements
            f"Solve {msg}",
            f"Solution for {msg}",
            f"Add solution: {msg}",
            f"Solved {msg}",
            # Casual
            f"{msg} — done",
            f"{msg} sorted",
            f"Finally got {msg}",
            f"Another one: {msg}",
            f"{msg} solved",
            # With difficulty
            f"{msg} ({diff})",
            f"LeetCode {diff}: {msg}",
            f"Solve {msg} [{diff}]",
            f"[{diff}] {msg}",
            # "LeetCode" prefix
            f"LeetCode: {msg}",
            f"LeetCode — {msg}",
            f"LC: {msg}",
            # "Daily" / journal-like
            f"Daily solve: {msg}",
            f"Today: {msg}",
            f"Morning grind: {msg}",
            f"Evening commit: {msg}",
            f"DSA: {msg}",
            # Source-referential
            f"{msg} — LeetCode",
            f"leetcode: {msg}",
            f"Problem: {msg}",
            # Minimal
            f"add: {msg}",
            f"feat: {msg}",
            f"update: {msg}",
            # "solution" variants
            f"Solution: {msg}",
            f"Add {msg} solution",
            f"{msg} solution added",
        ]
        return random.choice(templates)

    @classmethod
    def from_backlog_entry(cls, entry: dict, language: str = "cpp") -> ProblemContext:
        """Build a ProblemContext from a backlog.json entry."""
        return cls(
            title=entry["title"],
            difficulty=Difficulty(entry["difficulty"]),
            description=entry["description"],
            constraints=entry.get("constraints", ""),
            examples=entry.get("examples", []),
            boilerplate=entry.get("boilerplate", ""),
            source_url=entry.get("source_url", ""),
            source="backlog",
            solved_date=date.today().isoformat(),
            language=language,
        )
