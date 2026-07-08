"""Noise commits — small, realistic non-LeetCode changes that make the
contribution history look more human. Each commit touches an existing
project file with a trivial but legitimate-looking change."""

from __future__ import annotations

import logging
import os
import random
import re
from pathlib import Path

log = logging.getLogger(__name__)

# Probability of making a noise commit in a given run (in addition to solves)
_NOISE_PROBABILITY = 0.35


def _read_and_write(path: Path) -> int:
    """Make a small cosmetic change to a text file. Returns number of bytes changed."""
    if not path.exists():
        return 0
    original = path.read_text()
    modified = _tweak_file(path.name, original)
    if modified and modified != original:
        path.write_text(modified)
        return len(original) - len(modified)  # negative = grew, positive = shrank
    return 0


def _tweak_file(filename: str, content: str) -> str:
    """Apply a random cosmetic tweak to file content based on its type."""
    if filename == "README.md":
        return _tweak_readme(content)
    if filename == "config.yaml":
        return _tweak_config(content)
    if filename == "backlog.json":
        return _tweak_backlog(content)
    if filename.endswith(".py"):
        return _tweak_python(content)
    return ""


def _tweak_readme(content: str) -> str:
    """Occasionally update a stat or reword a sentence in README."""
    tweaks = [
        # Bump the test count
        (r"(\d+) tests across", lambda m: f"{int(m.group(1)) + random.randint(0, 2)} tests across"),
        # Update the "Last updated" or similar
        (r"(## )(\w+ \w+ \d+)", lambda m: f"{m.group(1)}v{random.randint(2, 5)}.{random.randint(0, 9)}"),
        # Fix a tiny typo-like variation
        (r"(Unique|Notable|Key) Features", random.choice(["Features", "Highlights", "Characteristics", "Details"])),
    ]
    tweak = random.choice(tweaks)
    if isinstance(tweak, tuple):
        pattern, repl = tweak
        if callable(repl):
            return re.sub(pattern, repl, content, count=1)
        return re.sub(pattern, repl, content, count=1)
    return content


def _tweak_config(content: str) -> str:
    """Bump a config value slightly."""
    tweaks = [
        (r"(temperature_code:) [\d.]+", lambda m: f"{m.group(1)} {random.choice(['0.15', '0.18', '0.22', '0.25'])}"),
        (r"(temperature_doc:) [\d.]+", lambda m: f"{m.group(1)} {random.choice(['0.65', '0.7', '0.75', '0.8'])}"),
    ]
    tweak = random.choice(tweaks)
    pattern, repl = tweak
    return re.sub(pattern, repl, content, count=1)


def _tweak_backlog(content: str) -> str:
    """Minor formatting tweak to backlog — whitespace-only change that doesn't affect JSON parsing."""
    lines = content.split("\n")
    if len(lines) > 20 and random.random() < 0.5:
        # Re-indent a random line slightly (cosmetic, valid JSON still)
        idx = random.randint(5, len(lines) - 5)
        current = lines[idx]
        stripped = current.lstrip()
        if stripped and not stripped.startswith("#"):
            new_indent = random.choice(["  ", "    ", "      "])
            lines[idx] = new_indent + stripped
            return "\n".join(lines)
    return content


def _tweak_python(content: str) -> str:
    """Add or remove a blank line, or tweak a comment."""
    lines = content.split("\n")
    if not lines:
        return content
    coin = random.random()
    if coin < 0.33 and len(lines) > 10:
        # Remove a random blank line
        blank_indices = [i for i, l in enumerate(lines) if not l.strip()]
        if blank_indices:
            idx = random.choice(blank_indices)
            lines.pop(idx)
    elif coin < 0.66 and len(lines) > 5:
        # Add a blank line somewhere reasonable (between functions/classes)
        for _ in range(20):
            idx = random.randint(1, len(lines) - 1)
            if lines[idx].strip() and not lines[idx - 1].strip() == "":
                before = idx - 1
                if before >= 0 and lines[before].strip() == "":
                    continue
                lines.insert(idx, "")
                break
    else:
        # Tweak a comment — rephrase slightly
        comment_indices = [i for i, l in enumerate(lines) if l.strip().startswith("#")]
        target = [i for i in comment_indices if len(lines[i].strip()) > 15]
        if target:
            idx = random.choice(target)
            comment = lines[idx].strip()
            comment = comment.replace("# ", "# ")
            swaps = {
                "Get": "Retrieve",
                "Retrieve": "Fetch",
                "Fetch": "Read",
                "Read": "Get",
                "creates": "builds",
                "builds": "generates",
                "generates": "creates",
                "check": "verify",
                "verify": "check",
                "config": "configuration",
                "configuration": "config",
            }
            for old, new in swaps.items():
                if old in comment and random.random() < 0.4:
                    comment = comment.replace(old, new, 1)
                    break
            indent = lines[idx][: len(lines[idx]) - len(lines[idx].lstrip())]
            lines[idx] = indent + comment
    return "\n".join(lines)


def _pick_noise_target(repo_root: Path) -> Path | None:
    """Pick a file to make a noise commit on, or None if nothing suitable."""
    candidates = [
        repo_root / "README.md",
        repo_root / "config.yaml",
        repo_root / "backlog.json",
    ]
    # Add src/ Python files
    src_dir = repo_root / "src"
    if src_dir.is_dir():
        for pyfile in sorted(src_dir.rglob("*.py")):
            candidates.append(pyfile)

    # Filter to files that exist
    existing = [p for p in candidates if p.exists() and p.is_file()]
    if not existing:
        return None
    return random.choice(existing)


def generate_noise_commit(repo_root: str | Path = ".") -> tuple[str, str] | None:
    """Attempt to generate a small noise commit on a random file.

    Args:
        repo_root: Path to the repository root.

    Returns:
        (file_path_relative, commit_message) tuple if successful, None otherwise.
    """
    repo_root = Path(repo_root).resolve()
    target = _pick_noise_target(repo_root)
    if target is None:
        return None

    bytes_changed = _read_and_write(target)
    if bytes_changed == 0:
        log.debug("No noise change applied to %s", target)
        return None

    rel_path = target.relative_to(repo_root)
    messages = [
        f"tweak: {rel_path}",
        f"minor: {rel_path}",
        f"chore: update {rel_path}",
        f"cleanup: {rel_path}",
        f"small fix in {rel_path}",
        f"nit: {rel_path}",
        f"style: {rel_path}",
        f"refactor: {rel_path}",
        f"docs: update {rel_path}",
        f"polish: {rel_path}",
    ]
    msg = random.choice(messages)
    log.info("Noise commit: %s (%+d bytes)", msg, -bytes_changed)
    return (str(rel_path), msg)


def maybe_noise_commit(repo_root: str | Path = ".") -> tuple[str, str] | None:
    """Conditionally generate a noise commit based on probability.

    Args:
        repo_root: Path to the repository root.

    Returns:
        (file_path_relative, commit_message) if a noise commit was generated, else None.
    """
    if random.random() > _NOISE_PROBABILITY:
        return None
    return generate_noise_commit(repo_root)
