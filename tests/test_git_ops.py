"""Tests for git operations."""

import os
import subprocess
from unittest.mock import Mock, patch

import pytest

from src.repository.git_ops import GitManager
from src.models.problem import ProblemContext, Difficulty


SAMPLE_PROBLEM = ProblemContext(
    title="Two Sum",
    difficulty=Difficulty.EASY,
    description="Find two numbers.",
    constraints="",
    solved_date="2026-06-24",
    source="leetcode",
    source_url="https://leetcode.com/problems/two-sum/",
)


class TestGitManager:
    def setup_method(self):
        self.git = GitManager(
            repo_path="/fake/repo",
            branch="main",
            author_name="Test Bot",
            author_email="bot@test.dev",
        )

    @patch.object(GitManager, "_run_git")
    def test_commit_and_push_success(self, mock_run):
        """Successful commit and push should return True."""
        # First call = git add, second = git status, third = git commit, fourth = push
        mock_run.side_effect = [
            "",                    # git add
            " M LeetCode/...",     # git status (has changes)
            "",                    # git commit
            "",                    # git push (success)
        ]

        # Patch output_path existence check
        with patch("pathlib.Path.exists", return_value=True):
            result = self.git.commit_and_push(SAMPLE_PROBLEM)

        assert result is True
        assert mock_run.call_count == 4

    @patch.object(GitManager, "_run_git")
    def test_commit_and_push_nothing_to_commit(self, mock_run):
        """When nothing changed, should return False."""
        mock_run.side_effect = [
            "",        # git add
            "",        # git status (empty = no changes)
        ]

        with patch("pathlib.Path.exists", return_value=True):
            result = self.git.commit_and_push(SAMPLE_PROBLEM)

        assert result is False

    @patch.object(GitManager, "_run_git")
    def test_commit_and_push_output_path_missing(self, mock_run):
        """When output dir doesn't exist, should return False."""
        with patch("pathlib.Path.exists", return_value=False):
            result = self.git.commit_and_push(SAMPLE_PROBLEM)

        assert result is False
        mock_run.assert_not_called()

    @patch.object(GitManager, "_run_git")
    def test_push_retries_on_failure(self, mock_run):
        """Push should retry up to 3 times on failure."""
        mock_run.side_effect = [
            "",                    # git add
            " M LeetCode/...",     # git status
            "",                    # git commit
            RuntimeError("push failed"),   # push attempt 1
            RuntimeError("push failed"),   # push attempt 2
            "",                    # push attempt 3 (success)
        ]

        with patch("pathlib.Path.exists", return_value=True):
            with patch("time.sleep"):  # don't actually sleep
                result = self.git.commit_and_push(SAMPLE_PROBLEM)

        assert result is True
        assert mock_run.call_count == 6  # add + status + commit + 3 pushes

    @patch.object(GitManager, "_run_git")
    def test_push_all_retries_fail(self, mock_run):
        """When all push attempts fail, should return False."""
        mock_run.side_effect = [
            "",                    # git add
            " M LeetCode/...",     # git status
            "",                    # git commit
            RuntimeError("push failed"),   # push attempt 1
            RuntimeError("push failed"),   # push attempt 2
            RuntimeError("push failed"),   # push attempt 3
        ]

        with patch("pathlib.Path.exists", return_value=True):
            with patch("time.sleep"):
                result = self.git.commit_and_push(SAMPLE_PROBLEM)

        assert result is False

    @patch.object(GitManager, "_run_git")
    def test_setup_git_config_with_actor(self, mock_run):
        """setup_git_config should use GITHUB_ACTOR when available."""
        with patch.dict(os.environ, {"GITHUB_ACTOR": "testuser"}, clear=True):
            self.git.setup_git_config()

        calls = mock_run.call_args_list
        assert len(calls) == 2
        assert calls[0][0] == ("config", "user.name", "testuser")
        assert calls[1][0] == ("config", "user.email", "testuser@users.noreply.github.com")

    @patch.object(GitManager, "_run_git")
    def test_get_authenticated_remote_with_token(self, mock_run):
        """With GITHUB_TOKEN, should build authenticated remote URL."""
        mock_run.return_value = "https://github.com/user/repo.git"

        with patch.dict(os.environ, {"GITHUB_TOKEN": "gh_token_123"}, clear=True):
            remote = self.git._get_authenticated_remote()

        assert "x-access-token:gh_token_123" in remote

    def test_run_git_success(self):
        """_run_git should return stdout on success."""
        with patch("subprocess.run") as mock_sub:
            mock_result = Mock()
            mock_result.stdout = "some output"
            mock_result.stderr = ""
            mock_sub.return_value = mock_result

            result = self.git._run_git("status")
            assert result == "some output"

    def test_run_git_failure(self):
        """_run_git should raise RuntimeError on failure."""
        with patch("subprocess.run") as mock_sub:
            mock_sub.side_effect = subprocess.CalledProcessError(
                1, ["git", "status"], stderr="error msg"
            )

            with pytest.raises(RuntimeError, match="error msg"):
                self.git._run_git("status")

    @patch.object(GitManager, "_run_git")
    def test_pull_rebase_success(self, mock_run):
        """_pull_rebase should return True on success."""
        mock_run.return_value = ""
        assert self.git._pull_rebase("origin") is True

    @patch.object(GitManager, "_run_git")
    def test_pull_rebase_conflict_aborts(self, mock_run):
        """_pull_rebase should abort on merge conflict."""
        mock_run.side_effect = [
            RuntimeError("merge conflict in file.txt"),
            "",  # rebase --abort succeeds
        ]
        assert self.git._pull_rebase("origin") is False

    @patch.object(GitManager, "_run_git")
    def test_commit_and_push_path_success(self, mock_run):
        """commit_and_push_path should succeed for an existing file."""
        with patch("pathlib.Path.exists", return_value=True):
            mock_run.side_effect = [
                "",                    # git add
                " M noise.txt",        # git status
                "",                    # git commit
                "",                    # git push
            ]
            result = self.git.commit_and_push_path("noise.txt", "tweak: noise.txt")
            assert result is True

    @patch.object(GitManager, "_run_git")
    def test_commit_and_push_path_nothing_to_commit(self, mock_run):
        """commit_and_push_path should return False when nothing changed."""
        with patch("pathlib.Path.exists", return_value=True):
            mock_run.side_effect = [
                "",        # git add
                "",        # git status (empty)
            ]
            result = self.git.commit_and_push_path("noise.txt", "tweak: noise.txt")
            assert result is False

    @patch.object(GitManager, "_run_git")
    def test_commit_and_push_path_missing_target(self, mock_run):
        """commit_and_push_path should return False when target doesn't exist."""
        with patch("pathlib.Path.exists", return_value=False):
            result = self.git.commit_and_push_path("nonexistent.txt", "msg")
            assert result is False
            mock_run.assert_not_called()
