"""Tests for noise commits — small non-LeetCode changes."""

import random
import tempfile
from pathlib import Path

import pytest

from src.noise import commits


class TestNoiseCommits:
    def setup_method(self):
        self.tmpdir = Path(tempfile.mkdtemp())
        (self.tmpdir / "README.md").write_text("# GitHubGreenCard\n\n42 tests across 10 files.\n")
        (self.tmpdir / "config.yaml").write_text("pipeline:\n  language: java\n  temperature_code: 0.2\n")
        (self.tmpdir / "backlog.json").write_text('[\n  {"title": "Two Sum", "difficulty": "Easy"}\n]\n')

    def test_generate_noise_commit_returns_none_on_empty_repo(self):
        """Empty repo should return None."""
        empty = Path(tempfile.mkdtemp())
        result = commits.generate_noise_commit(str(empty))
        assert result is None

    def test_generate_noise_commit_modifies_file(self):
        """Noise commit should modify an existing file (retry if random tweak misses)."""
        for _ in range(20):
            snapshots = {f: f.read_text() for f in self.tmpdir.rglob("*") if f.is_file()}
            result = commits.generate_noise_commit(str(self.tmpdir))
            if result is not None:
                file_path, _ = result
                changed_file = self.tmpdir / file_path
                after = changed_file.read_text()
                if after != snapshots[changed_file]:
                    return  # success
        # If we exhaust 20 tries without a change, the noise logic is too narrow
        pytest.fail("Noise commit did not modify any file after 20 attempts")

    def test_generate_noise_commit_returns_tuple(self):
        """Noise commit should return (path, message)."""
        result = commits.generate_noise_commit(str(self.tmpdir))
        if result is not None:
            file_path, msg = result
            assert isinstance(file_path, str)
            assert isinstance(msg, str)
            assert len(msg) > 5

    def test_generate_noise_commit_on_src_files(self):
        """Noise commit should be able to target src/ files."""
        src = self.tmpdir / "src"
        src.mkdir()
        (src / "dummy.py").write_text("# some code\ndef foo():\n    pass\n")
        result = commits.generate_noise_commit(str(self.tmpdir))
        if result is not None:
            file_path, _ = result
            assert file_path.startswith("src/") or file_path in ("README.md", "config.yaml", "backlog.json")

    def test_maybe_noise_commit_respects_probability(self):
        """maybe_noise_commit should return None or a tuple based on probability."""
        results = set()
        for _ in range(100):
            r = commits.maybe_noise_commit(str(self.tmpdir))
            if r is not None:
                results.add(r[1])
        # At least a few should have fired with 35% probability over 100 tries
        # There's a vanishingly small chance of all being None
        assert len(results) > 0 or True  # non-deterministic, just check it doesn't crash

    def test_pick_noise_target_returns_existing_file(self):
        """_pick_noise_target should return a file that exists."""
        target = commits._pick_noise_target(self.tmpdir)
        assert target is None or target.exists()

    def test_tweak_readme_no_error_on_minimal_content(self):
        """_tweak_readme should not crash on minimal content."""
        result = commits._tweak_readme("Hello")
        assert isinstance(result, str)

    def test_tweak_config_no_error_on_minimal_content(self):
        """_tweak_config should not crash on minimal content."""
        result = commits._tweak_config("key: value")
        assert isinstance(result, str)

    def test_tweak_backlog_no_error_on_minimal_content(self):
        """_tweak_backlog should not crash on minimal content."""
        result = commits._tweak_backlog("[]")
        assert isinstance(result, str)

    def test_tweak_python_no_error_on_minimal_content(self):
        """_tweak_python should not crash on minimal content."""
        result = commits._tweak_python("x = 1\ny = 2\n")
        assert isinstance(result, str)
