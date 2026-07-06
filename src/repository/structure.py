"""Filesystem structure management — creates standardized output directories and files."""

from __future__ import annotations

import logging
from pathlib import Path

from src.models.problem import ProblemContext

log = logging.getLogger(__name__)


class StructureManager:
    """Creates and manages the repository directory structure.

    Output structure:
        ./LeetCode/YYYY-MM-DD-Problem-Name/
        ├── solution.{lang}
        └── README.md
    """

    def __init__(self, output_root: str = "LeetCode"):
        self.output_root = Path(output_root)

    def write_solution(self, problem: ProblemContext, code: str) -> Path:
        """Write the solution code file.

        Args:
            problem: Problem context (used for folder naming).
            code: Solution source code string.

        Returns:
            Path to the written solution file.
        """
        folder = self._ensure_folder(problem)
        extension = self._language_extension(problem.language)
        filepath = folder / f"solution{extension}"

        with open(filepath, "w") as f:
            f.write(code)

        log.info("Wrote solution: %s (%d bytes)", filepath, len(code))
        return filepath

    def write_readme(self, problem: ProblemContext, doc: str) -> Path:
        """Write the README.md documentation file.

        Args:
            problem: Problem context (used for folder naming).
            doc: Markdown documentation string.

        Returns:
            Path to the written README file.
        """
        folder = self._ensure_folder(problem)
        filepath = folder / "README.md"

        # Prepend problem metadata header
        header = self._build_header(problem)
        content = header + "\n\n" + doc

        with open(filepath, "w") as f:
            f.write(content)

        log.info("Wrote README: %s (%d bytes)", filepath, len(content))
        return filepath

    def _ensure_folder(self, problem: ProblemContext) -> Path:
        """Create the output folder if it doesn't exist."""
        folder = self.output_root / problem.folder_name()
        folder.mkdir(parents=True, exist_ok=True)
        return folder

    def _build_header(self, problem: ProblemContext) -> str:
        """Build the markdown header for the README."""
        return (
            f"# {problem.title}\n\n"
            f"- **Difficulty**: {problem.difficulty.value}\n"
            f"- **Source**: [{problem.source.title()}]({problem.source_url})\n"
            f"- **Date**: {problem.solved_date}\n"
            f"- **Language**: {problem.language}\n"
        )

    @staticmethod
    def _language_extension(language: str) -> str:
        """Map language name to file extension."""
        extensions = {
            "cpp": ".cpp",
            "c++": ".cpp",
            "python": ".py",
            "java": ".java",
            "javascript": ".js",
            "typescript": ".ts",
            "go": ".go",
            "rust": ".rs",
            "swift": ".swift",
            "kotlin": ".kt",
            "ruby": ".rb",
            "scala": ".scala",
        }
        return extensions.get(language.lower(), f".{language}")


def get_solved_slugs(output_root: str = "LeetCode") -> set[str]:
    """Scan the output directory for previously solved problem slugs.

    Folder names follow the pattern ``YYYY-MM-DD-kebab-title``.
    Extracts the kebab-case title slug (everything after the ISO date prefix).

    Returns:
        A set of kebab-case slugs, e.g. ``{'two-sum', 'maximum-subarray'}``.
        Empty set if the directory does not exist or contains no solutions.
    """
    root = Path(output_root)
    if not root.is_dir():
        return set()

    slugs: set[str] = set()
    # Folder format: YYYY-MM-DD-kebab-title → strip "YYYY-MM-DD-" (11 chars)
    for entry in root.iterdir():
        if entry.is_dir():
            name = entry.name
            # ISO date is 10 chars + hyphen = 11 chars prefix
            if len(name) > 11 and name[4] == "-" and name[7] == "-":
                slug = name[11:]  # Strip the date prefix
                if slug:
                    slugs.add(slug)
    return slugs
