"""Git operations — staging, committing, and pushing changes."""

from __future__ import annotations

import logging
import os
import subprocess
import time
from pathlib import Path

from src.models.problem import ProblemContext

log = logging.getLogger(__name__)

# Maximum push retry attempts
_MAX_PUSH_RETRIES = 3
# Base delay in seconds between push retries (doubles each attempt)
_PUSH_RETRY_BASE_DELAY = 5


class GitManager:
    """Handles all git operations for the pipeline.

    Operates within the GitHub Actions runner context where:
    - GITHUB_TOKEN is available for authentication
    - git is pre-configured with the Actions bot identity
    """

    def __init__(
        self,
        repo_path: str | Path = ".",
        branch: str = "main",
        author_name: str = "GitHubGreenCard Bot",
        author_email: str = "bot@githubgreencard.dev",
    ):
        self.repo_path = Path(repo_path).resolve()
        self.branch = branch
        self.author_name = author_name
        self.author_email = author_email

    def commit_and_push(self, problem: ProblemContext) -> bool:
        """Stage, commit, and push the new solution directory.

        Includes pull-before-push safety (in GitHub Actions) and
        up to 3 push retries with exponential backoff.

        Args:
            problem: The problem context for the commit message.

        Returns:
            True if push succeeded, False if there was nothing to commit.
        """
        folder = problem.folder_name()
        output_path = self.repo_path / "LeetCode" / folder

        if not output_path.exists():
            log.warning("Output path does not exist: %s", output_path)
            return False

        # Stage the new directory
        self._run_git("add", str(output_path))
        log.debug("Staged: %s", output_path)

        # Check if there's anything to commit
        status = self._run_git("status", "--porcelain")
        if not status.strip():
            log.info("Nothing to commit — all files already tracked")
            return False

        # Commit — author identity comes from git config (set in CI workflow)
        commit_msg = problem.commit_message()
        self._run_git("commit", "-m", commit_msg)
        log.info("Committed: %s", commit_msg)

        # Determine push remote
        remote = self._get_authenticated_remote() or "origin"

        # Pull rebase before push (only in CI to avoid local disruption)
        if os.environ.get("GITHUB_ACTIONS") == "true":
            if self._pull_rebase(remote):
                log.debug("Remote is up to date after rebase pull")
            else:
                log.warning("Rebase pull failed — will try push anyway")

        # Push with retry
        last_error = None
        for attempt in range(1, _MAX_PUSH_RETRIES + 1):
            try:
                self._run_git("push", remote, self.branch)
                log.info("Pushed to %s/%s (attempt %d/%d)", remote, self.branch, attempt, _MAX_PUSH_RETRIES)
                return True
            except RuntimeError as e:
                last_error = e
                if attempt < _MAX_PUSH_RETRIES:
                    delay = _PUSH_RETRY_BASE_DELAY * (2 ** (attempt - 1))
                    log.warning(
                        "Push attempt %d/%d failed — retrying in %ds: %s",
                        attempt, _MAX_PUSH_RETRIES, delay, e,
                    )
                    time.sleep(delay)

        log.error("All %d push attempts failed: %s", _MAX_PUSH_RETRIES, last_error)
        return False

    def commit_and_push_path(self, file_path: str, commit_msg: str) -> bool:
        """Stage, commit, and push a specific file path with a custom message.

        Used for noise commits and other non-LeetCode changes.

        Args:
            file_path: Relative path to the file(s) to stage.
            commit_msg: Custom commit message.

        Returns:
            True if push succeeded, False if nothing to commit.
        """
        target = self.repo_path / file_path
        if not target.exists():
            log.warning("Noise target does not exist: %s", target)
            return False

        self._run_git("add", str(target))
        log.debug("Staged: %s", target)

        status = self._run_git("status", "--porcelain")
        if not status.strip():
            log.info("Nothing to commit — all files already tracked")
            return False

        self._run_git("commit", "-m", commit_msg)
        log.info("Committed: %s", commit_msg)

        remote = self._get_authenticated_remote() or "origin"

        if os.environ.get("GITHUB_ACTIONS") == "true":
            if self._pull_rebase(remote):
                log.debug("Remote is up to date after rebase pull")
            else:
                log.warning("Rebase pull failed — will try push anyway")

        last_error = None
        for attempt in range(1, _MAX_PUSH_RETRIES + 1):
            try:
                self._run_git("push", remote, self.branch)
                log.info("Pushed to %s/%s (attempt %d/%d)", remote, self.branch, attempt, _MAX_PUSH_RETRIES)
                return True
            except RuntimeError as e:
                last_error = e
                if attempt < _MAX_PUSH_RETRIES:
                    delay = _PUSH_RETRY_BASE_DELAY * (2 ** (attempt - 1))
                    log.warning(
                        "Push attempt %d/%d failed — retrying in %ds: %s",
                        attempt, _MAX_PUSH_RETRIES, delay, e,
                    )
                    time.sleep(delay)

        log.error("All %d push attempts failed: %s", _MAX_PUSH_RETRIES, last_error)
        return False

    def setup_git_config(self) -> None:
        """Ensure git user config is set for the current actor.

        Uses GITHUB_ACTOR env var (set automatically in GitHub Actions)
        so the commit appears under the triggering user's name.
        Falls back to the configured author_name/email.
        """
        actor = os.environ.get("GITHUB_ACTOR", self.author_name)
        email = f"{actor}@users.noreply.github.com" if os.environ.get("GITHUB_ACTOR") else self.author_email
        try:
            self._run_git("config", "user.name", actor)
            self._run_git("config", "user.email", email)
            log.debug("Git user config set to %s <%s>", actor, email)
        except RuntimeError:
            log.warning("Could not set git user config")

    def _pull_rebase(self, remote_url: str) -> bool:
        """Pull with rebase to catch up with remote before pushing.

        Uses the same remote URL strategy as push for consistency.
        Returns True on success, False on conflict or other failure.
        """
        try:
            self._run_git("pull", "--rebase", remote_url, self.branch)
            log.debug("Rebase pull successful from %s/%s", remote_url, self.branch)
            return True
        except RuntimeError as e:
            # Check if rebase had conflicts
            if "merge" in str(e).lower() or "conflict" in str(e).lower():
                log.error("Rebase conflict — aborting rebase")
                try:
                    self._run_git("rebase", "--abort")
                except RuntimeError:
                    pass
            return False

    def _get_authenticated_remote(self) -> str | None:
        """Build an authenticated remote URL using GITHUB_TOKEN if available."""
        token = os.environ.get("GITHUB_TOKEN") or os.environ.get("GH_TOKEN")
        if not token:
            return None

        # Get the remote origin URL
        try:
            remote = self._run_git("remote", "get-url", "origin").strip()
            if remote.startswith("https://"):
                # Insert token into URL: https://x-access-token:TOKEN@github.com/...
                parts = remote.split("://", 1)
                if len(parts) == 2:
                    return f"{parts[0]}://x-access-token:{token}@{parts[1]}"
            return remote
        except RuntimeError:
            return None

    def _run_git(self, *args: str) -> str:
        """Run a git command and return stdout."""
        cmd = ["git"] + list(args)
        log.debug("Running: %s", " ".join(cmd))
        try:
            result = subprocess.run(
                cmd,
                capture_output=True,
                text=True,
                check=True,
                cwd=str(self.repo_path),
            )
            return result.stdout.strip()
        except subprocess.CalledProcessError as e:
            log.error("Git command failed: %s\n%s", e.cmd, e.stderr)
            raise RuntimeError(f"Git error: {e.stderr}") from e
