#!/usr/bin/env python3
"""GitHubGreenCard — Automated DSA Portfolio Engine.

Orchestrates the daily pipeline:
1. Ingest problem (LeetCode POTD → backlog fallback)
2. Generate solution code (LLM Stage 1)
3. Generate humanized docs (LLM Stage 2)
4. Write files to disk
5. Commit and push to GitHub
"""

from __future__ import annotations

import logging
import os
import random
import re
import sys
import time
from datetime import date
from pathlib import Path

import yaml

from src.ingestion.alt_leetcode import AltLeetCodeFetcher
from src.ingestion.backlog import BacklogFetcher
from src.ingestion.leetcode import LeetCodeFetcher
from src.ingestion.base import IngestionError
from src.execution.code_generator import CodeGenerator
from src.execution.doc_writer import DocWriter
from src.execution.llm_client import LLMClient
from src.execution.exceptions import ExecutionError
from src.repository.structure import StructureManager, get_solved_slugs
from src.repository.git_ops import GitManager
from src.noise.commits import maybe_noise_commit

log = logging.getLogger("githubgreencard")


def load_config(path: str = "config.yaml") -> dict:
    """Load pipeline configuration from YAML file."""
    config_path = Path(path)
    if not config_path.exists():
        log.warning("Config file not found: %s — using defaults", path)
        return {}

    with open(config_path, "r") as f:
        config = yaml.safe_load(f)
    log.info("Configuration loaded from: %s", path)
    return config or {}


def setup_logging(config: dict) -> None:
    """Configure logging based on config."""
    log_config = config.get("logging", {})
    level = getattr(logging, log_config.get("level", "INFO").upper(), logging.INFO)
    fmt = log_config.get("format", "%(asctime)s - %(name)s - %(levelname)s - %(message)s")

    logging.basicConfig(
        level=level,
        format=fmt,
        stream=sys.stdout,
    )


def _get_excluded_slugs(config: dict) -> set[str]:
    """Get set of already-solved problem slugs from the output directory.

    Scans the LeetCode/ folder for previously solved problems so the
    ingestion layer can skip them.
    """
    output_root = config.get("pipeline", {}).get("output_root", "LeetCode")
    return get_solved_slugs(output_root)


def fetch_problem(config: dict, exclude_slugs: set[str] | None = None) -> "ProblemContext":
    """Ingest a problem — try LeetCode first, fallback to backlog.

    Args:
        config: Pipeline configuration dict.
        exclude_slugs: Set of already-solved title slugs to skip.

    Returns:
        ProblemContext from either source.

    Raises:
        IngestionError: If both sources fail or all problems are solved.
    """
    ingestion_config = config.get("ingestion", {})
    language = config.get("pipeline", {}).get("language", "cpp")

    # Attempt primary: LeetCode (random problem)
    leetcode_config = ingestion_config.get("leetcode", {})
    if leetcode_config.get("enabled", True):
        try:
            fetcher = LeetCodeFetcher(
                api_url=leetcode_config.get("api_url", "https://alfa-leetcode-api.onrender.com"),
                timeout=leetcode_config.get("timeout", 30),
                language=language,
                page_size=leetcode_config.get("page_size", 50),
            )
            problem = fetcher.fetch(exclude_slugs=exclude_slugs)
            log.info("Fetched random LeetCode problem: %s", problem.title)
            return problem
        except IngestionError as e:
            log.warning("LeetCode fetch (primary) failed: %s — trying alternative API...", e)
    else:
        log.info("LeetCode ingestion disabled in config — trying alternative API...")

    # Fallback 1: Alternative LeetCode API (Vercel-hosted)
    alt_config = ingestion_config.get("alt_leetcode", {})
    if alt_config.get("enabled", True):
        try:
            fetcher = AltLeetCodeFetcher(
                api_url=alt_config.get("api_url", "https://leetcode-api-pied.vercel.app"),
                timeout=alt_config.get("timeout", 30),
                language=language,
            )
            problem = fetcher.fetch(exclude_slugs=exclude_slugs)
            log.info("Fetched from alternative LeetCode API: %s", problem.title)
            return problem
        except IngestionError as e:
            log.warning("Alternative LeetCode fetch failed: %s — switching to backlog", e)

    # Fallback 2: Backlog (local file)
    backlog_config = ingestion_config.get("backlog", {})
    backlog_path = backlog_config.get("file_path", "backlog.json")
    fetcher = BacklogFetcher(file_path=backlog_path, language=language)
    problem = fetcher.fetch(exclude_slugs=exclude_slugs)
    log.info("Fetched from backlog: %s", problem.title)
    return problem


def execute_pipeline(problem: "ProblemContext", config: dict) -> None:
    """Run the LLM execution pipeline on a problem.

    Args:
        problem: The problem to solve.
        config: Full pipeline config.
    """
    exec_config = config.get("execution", {}).get("llm", {})

    base_url = exec_config.get("base_url")
    retry_count = exec_config.get("retry_count", 3)
    retry_delay = exec_config.get("retry_delay", 5)

    # Stage 1: Generate solution code (heavy model for code quality)
    code_llm = LLMClient(
        base_url=base_url,
        model=exec_config.get("model_code", "deepseek-ai/deepseek-coder-6.7b-instruct"),
        temperature=exec_config.get("temperature_code", 0.2),
        max_tokens=exec_config.get("max_tokens_code", 2048),
        retry_count=retry_count,
        retry_delay=retry_delay,
    )
    code_gen = CodeGenerator(code_llm)
    solution_code = code_gen.generate_code(problem)
    log.info("Solution code generated (%d bytes)", len(solution_code))

    # Stage 2: Generate documentation (lighter model for creative writing)
    doc_llm = LLMClient(
        base_url=base_url,
        model=exec_config.get("model_doc", "nvidia/nemotron-mini-4b-instruct"),
        temperature=exec_config.get("temperature_doc", 0.7),
        max_tokens=exec_config.get("max_tokens_doc", 1500),
        retry_count=retry_count,
        retry_delay=retry_delay,
    )
    doc_writer = DocWriter(doc_llm)
    doc = doc_writer.generate_doc(problem, solution_code)
    log.info("Documentation generated (%d bytes)", len(doc))

    # Write to filesystem
    pipeline_config = config.get("pipeline", {})
    output_root = pipeline_config.get("output_root", "LeetCode")
    struct_mgr = StructureManager(output_root=output_root)
    solution_path = struct_mgr.write_solution(problem, solution_code)
    readme_path = struct_mgr.write_readme(problem, doc)

    log.info("Files written:")
    log.info("  Solution: %s", solution_path)
    log.info("  README:   %s", readme_path)


def deploy(problem: "ProblemContext", config: dict) -> bool:
    """Commit and push changes to GitHub.

    Args:
        problem: The problem that was solved.
        config: Pipeline config.

    Returns:
        True if commit+push succeeded.
    """
    repo_config = config.get("repository", {}).get("git", {})
    git_mgr = GitManager(
        branch=repo_config.get("branch", "main"),
        author_name=repo_config.get("author_name", ""),
        author_email=repo_config.get("author_email", ""),
    )

    # In GitHub Actions, set up git config
    if os.environ.get("GITHUB_ACTIONS") == "true":
        git_mgr.setup_git_config()

    return git_mgr.commit_and_push(problem)


def run_dry(config: dict) -> None:
    """Run the pipeline in dry-run mode — no git operations.

    Useful for testing the ingestion + LLM flow without pushing to GitHub.
    If no OPENAI_API_KEY is set, the LLM steps are skipped.
    """
    log.info("=== DRY RUN MODE ===")

    excluded = _get_excluded_slugs(config)
    log.info("Step 1: Fetching problem (excluding %d solved)...", len(excluded))
    problem = fetch_problem(config, exclude_slugs=excluded)
    log.info("  -> Title: %s", problem.title)
    log.info("  -> Difficulty: %s", problem.difficulty.value)
    log.info("  -> Source: %s", problem.source)

    log.info("Step 2-3: Executing LLM pipeline...")
    try:
        execute_pipeline(problem, config)
        log.info("Step 4: Skipping git operations (dry-run)")
        log.info("=== DRY RUN COMPLETE ===")
        log.info("Output directory: %s/%s", config.get("pipeline", {}).get("output_root", "LeetCode"), problem.folder_name())
    except ExecutionError as e:
        log.warning("LLM execution skipped: %s", e)
        log.warning("Set OPENAI_API_KEY to enable code generation.")
        log.info("=== DRY RUN PARTIAL (ingestion OK, LLM skipped) ===")


def _pick_commit_count(config: dict) -> int:
    """Pick a random number of problems to solve this run.

    Returns a value between 1 and ``max_commits_per_run`` (from config
    or ``MAX_COMMITS`` env var, defaulting to 10).
    """
    max_commits = (
        config.get("pipeline", {}).get("max_commits_per_run")
        or int(os.environ.get("MAX_COMMITS", "10"))
    )
    max_commits = max(1, min(max_commits, 10))
    count = random.randint(1, max_commits)
    log.info("Will solve %d problem(s) this run", count)
    return count


# Probability of skipping a day entirely (0.0 = never, 1.0 = always)
_SKIP_PROBABILITY = 0.20
# Max seconds to jitter at start (small — free GitHub Actions can't sleep hours)
_JITTER_MAX_SECONDS = 300  # 5 minutes


def _should_skip_today() -> bool:
    """Roll the dice — should we skip today?
    
    Uses the date as seed so all crons firing the same day agree.
    With multiple cron entries at different hours, this prevents
    multiple solves on the same day — at most one fires.
    """
    today = date.today().isoformat()
    seed = hash(today) & 0x7FFFFFFF  # deterministic per-day
    rng = random.Random(seed)
    return rng.random() < _SKIP_PROBABILITY


def _jitter_time() -> None:
    """Small random delay at start to add minor variance to commit timestamps.
    
    Free GitHub Actions can't sustain long sleep, so this is intentionally
    short (0-15 min). For real time-scattering across the day, add multiple
    cron schedules in the workflow file pointing to different hours.
    """
    delay = random.uniform(0, _JITTER_MAX_SECONDS)
    minutes = delay / 60
    if minutes > 1:
        log.info("Jittering start by %.1f minutes", minutes)
        time.sleep(delay)


def run(config: dict) -> int:
    """Run the full production pipeline — may solve multiple problems.

    Picks a random number of problems (1-10), fetches each (skipping
    already-solved ones), generates code + docs, and commits separately
    so the contribution graph shows natural variation.

    Returns:
        0 on success, 1 on failure.
    """
    # Phase 0: Skip probability — some days have zero commits
    if _should_skip_today():
        log.info("Skipped — no solve today (probabilistic skip)")
        return 0

    # Phase 0: Small jitter so consecutive cron runs don't share the exact same timestamp
    _jitter_time()

    try:
        log.info("=" * 50)
        log.info("GitHubGreenCard Pipeline — Starting")
        log.info("=" * 50)

        excluded = _get_excluded_slugs(config)
        commit_count = _pick_commit_count(config)
        problems_solved = 0

        for i in range(commit_count):
            log.info("--- Problem %d/%d ---", i + 1, commit_count)
            try:
                problem = fetch_problem(config, exclude_slugs=excluded)
            except IngestionError as e:
                log.warning("Skipping — no problem available: %s", e)
                continue

            # Mark as solved so subsequent iterations don't re-pick
            slug = re.sub(
                r"[^a-zA-Z0-9]+", "-", problem.title.strip()
            ).strip("-").lower()
            excluded.add(slug)

            execute_pipeline(problem, config)
            deployed = deploy(problem, config)

            if deployed:
                problems_solved += 1
                log.info("Committed: %s", problem.commit_message())
            else:
                log.warning("Nothing new to commit for: %s", problem.title)

            # Random delay between commits to look natural
            if i < commit_count - 1:
                delay = random.uniform(10, 120)
                log.debug("Waiting %.0fs before next problem...", delay)
                time.sleep(delay)

        # Occasionally add a noise commit (non-LeetCode change)
        noise = maybe_noise_commit()
        if noise:
            file_path, msg = noise
            try:
                repo_config = config.get("repository", {}).get("git", {})
                git_mgr = GitManager(
                    branch=repo_config.get("branch", "main"),
                    author_name=repo_config.get("author_name", ""),
                    author_email=repo_config.get("author_email", ""),
                )
                if os.environ.get("GITHUB_ACTIONS") == "true":
                    git_mgr.setup_git_config()
                git_mgr.commit_and_push_path(file_path, msg)
                problems_solved += 1
            except RuntimeError as e:
                log.warning("Noise commit failed: %s", e)

        if problems_solved:
            log.info(
                "Pipeline complete — %d commit(s) pushed.",
                problems_solved,
            )
        else:
            log.warning("Pipeline complete — nothing new to commit.")

        return 0

    except (IngestionError, ExecutionError) as e:
        log.error("Pipeline failed: %s", e)
        return 1
    except Exception as e:
        log.exception("Unexpected pipeline error: %s", e)
        return 1


def main() -> int:
    """Entry point for the pipeline."""
    config = load_config()
    setup_logging(config)

    dry_run = os.environ.get("DRY_RUN", "").lower() in ("1", "true", "yes")
    if dry_run:
        run_dry(config)
        return 0

    return run(config)


if __name__ == "__main__":
    sys.exit(main())
