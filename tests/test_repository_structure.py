"""Tests for the repository structure manager."""

import tempfile
from pathlib import Path

from src.models.problem import ProblemContext, Difficulty
from src.repository.structure import StructureManager, get_solved_slugs


class TestStructureManager:
    def setup_method(self):
        self.tmpdir = Path(tempfile.mkdtemp())
        self.mgr = StructureManager(output_root=str(self.tmpdir / "LeetCode"))

    def test_write_solution_creates_file(self):
        """Writing a solution should create the file in the right folder."""
        problem = ProblemContext(
            title="Test Problem",
            difficulty=Difficulty.EASY,
            description="Desc",
            constraints="C",
            solved_date="2026-06-24",
            language="cpp",
        )
        path = self.mgr.write_solution(problem, "int main() {}")
        assert path.exists()
        assert path.suffix == ".cpp"
        assert "2026-06-24" in str(path)
        assert path.read_text() == "int main() {}"

    def test_write_readme_creates_file(self):
        """Writing a README should include the metadata header."""
        problem = ProblemContext(
            title="Two Sum",
            difficulty=Difficulty.MEDIUM,
            description="Desc",
            constraints="C",
            solved_date="2026-06-24",
            source="leetcode",
            source_url="https://leetcode.com/problems/two-sum/",
        )
        path = self.mgr.write_readme(problem, "My dev journal entry")
        assert path.exists()
        content = path.read_text()
        assert "# Two Sum" in content
        assert "**Difficulty**: Medium" in content
        assert "**Source**: [Leetcode]" in content
        assert "My dev journal entry" in content

    def test_language_extension_mapping(self):
        """Language names should map to correct file extensions."""
        assert StructureManager._language_extension("cpp") == ".cpp"
        assert StructureManager._language_extension("python") == ".py"
        assert StructureManager._language_extension("java") == ".java"
        assert StructureManager._language_extension("go") == ".go"
        assert StructureManager._language_extension("unknown") == ".unknown"


class TestGetSolvedSlugs:
    def test_empty_directory(self):
        """Non-existent directory returns empty set."""
        assert get_solved_slugs("/nonexistent/path") == set()

    def test_returns_solved_slugs(self):
        """Folder names should be parsed into kebab-case slugs."""
        tmpdir = Path(tempfile.mkdtemp())
        (tmpdir / "2026-06-24-two-sum").mkdir()
        (tmpdir / "2026-06-25-maximum-subarray").mkdir()

        slugs = get_solved_slugs(str(tmpdir))
        assert slugs == {"two-sum", "maximum-subarray"}

    def test_ignores_non_date_folders(self):
        """Folders that don't match date pattern should be ignored."""
        tmpdir = Path(tempfile.mkdtemp())
        (tmpdir / "2026-06-24-two-sum").mkdir()
        (tmpdir / "README.md").write_text("")
        (tmpdir / "config.yaml").write_text("")

        slugs = get_solved_slugs(str(tmpdir))
        assert slugs == {"two-sum"}

    def test_handles_missing_date_prefix(self):
        """Short folder names without date prefix are ignored."""
        tmpdir = Path(tempfile.mkdtemp())
        (tmpdir / "abc").mkdir()

        slugs = get_solved_slugs(str(tmpdir))
        assert slugs == set()
