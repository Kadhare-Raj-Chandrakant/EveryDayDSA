"""Stage 1: LLM Code Generator — produces LeetCode-format solution code."""

from __future__ import annotations

import logging
import random
import re

from src.execution.llm_client import LLMClient
from src.models.problem import ProblemContext

log = logging.getLogger(__name__)

# Probability of generating a suboptimal (brute-force) solution
_BRUTE_FORCE_PROBABILITY = 0.22

# Language-specific style guidance for the code generation prompt
_LANGUAGE_STYLE: dict[str, str] = {
    "cpp": "Write clean, idiomatic C++ with STL containers and algorithms.",
    "c++": "Write clean, idiomatic C++ with STL containers and algorithms.",
    "java": "Write clean, idiomatic Java with standard library collections.",
    "python": "Write clean, idiomatic Python. Prefer list comprehensions and built-in functions.",
    "javascript": "Write clean, idiomatic JavaScript/Node.js with standard array methods.",
    "typescript": "Write clean, idiomatic TypeScript with proper type annotations.",
    "go": "Write clean, idiomatic Go. Prefer standard library where possible.",
    "rust": "Write clean, idiomatic Rust. Respect ownership and borrowing rules.",
    "swift": "Write clean, idiomatic Swift with standard library where possible.",
    "kotlin": "Write clean, idiomatic Kotlin with standard library collections.",
    "ruby": "Write clean, idiomatic Ruby. Prefer Enumerable methods where appropriate.",
    "scala": "Write clean, idiomatic Scala. Prefer functional style where appropriate.",
}


def _build_code_system_prompt(language: str) -> str:
    """Build a language-specific system prompt for code generation."""
    style = _LANGUAGE_STYLE.get(language.lower(),
                                f"Write clean, idiomatic {language}.")
    return f"""You are an expert competitive programmer. Your task is to write correct, 
efficient LeetCode solutions that pass ALL test cases.

CRITICAL RULES:
- Output ONLY the solution class/function — no explanations, no markdown.
- You MUST use the EXACT boilerplate provided below. Do NOT change the method name, return type, or parameters.
- Consider the CONSTRAINTS carefully to choose the right algorithm:
  * n <= 10^4 -> O(n^2) may be acceptable
  * n <= 10^5 -> O(n log n) or better
  * n <= 10^6 -> O(n) or better
  * n <= 10^9 -> O(log n) (matrix exponentiation, binary search) or O(1)
  * n <= 10^12 -> O(log n) or O(1)
- Study the HINTS section — they point to the correct approach.
- {style}
- Handle edge cases and respect modulo operations when specified.
- Include time/space complexity comments at the top of the method.
"""


class CodeGenerator:
    """Stage 1 of the LLM pipeline — generates solution code.

    Takes a ProblemContext with exact LeetCode boilerplate and produces
    a solution file string in standard LeetCode format.
    """

    def __init__(self, llm_client: LLMClient):
        self.llm = llm_client

    def generate_code(self, problem: ProblemContext, force_brute_force: bool | None = None) -> str:
        """Generate solution code for the given problem.

        Args:
            problem: The problem context from ingestion (must include boilerplate + hints).
            force_brute_force: If True, force suboptimal/brute-force solution.
                If None, decides randomly (~22% chance).

        Returns:
            Solution source code as a string (LeetCode format).
        """
        log.info("Generating solution code for: %s", problem.title)

        is_brute = force_brute_force if force_brute_force is not None else random.random() < _BRUTE_FORCE_PROBABILITY

        if is_brute:
            log.info("Using suboptimal/brute-force approach for this problem")
            system_prompt = _build_code_system_prompt(problem.language).replace(
                "efficient LeetCode solutions that pass ALL test cases.",
                "readable LeetCode solutions. Prioritize simplicity and straightforward logic over optimization.",
            )
            user_prompt = self._build_prompt(problem)
            # Drop efficiency guidance so the LLM doesn't get pushed toward optimal
            user_prompt = re.sub(
                r"EFFICIENCY REQUIREMENT:.*?(?=\n\S|\n\n|$)",
                "",
                user_prompt,
            )
            user_prompt = user_prompt.replace(
                "Follow the hints to choose the most efficient algorithm.",
                "Follow the hints if they help, but a straightforward approach is fine.",
            )
            code = self.llm.generate(
                system_prompt=system_prompt,
                user_prompt=user_prompt,
                temperature=0.5,
                max_tokens=4096,
            )
        else:
            system_prompt = _build_code_system_prompt(problem.language)
            user_prompt = self._build_prompt(problem)
            code = self.llm.generate(
                system_prompt=system_prompt,
                user_prompt=user_prompt,
                temperature=0.2,
                max_tokens=4096,
            )

        code = self._clean_code(code)
        log.debug("Generated %d bytes of solution code", len(code))
        return code

    def _build_prompt(self, problem: ProblemContext) -> str:
        """Construct the prompt with exact boilerplate and hints."""
        examples_str = ""
        if problem.examples:
            examples_str = "\n".join(
                f"Example {i+1}:\n  Input: {ex['input']}\n  Output: {ex['output']}"
                for i, ex in enumerate(problem.examples)
            )

        hints_str = ""
        if problem.hints:
            hints_str = "\n".join(
                f"Hint {i+1}: {h}" for i, h in enumerate(problem.hints)
            )

        boilerplate_section = f"""
=== EXACT LEETCODE BOILERPLATE (DO NOT CHANGE SIGNATURE) ===
{problem.boilerplate}
=== END BOILERPLATE ===
""" if problem.boilerplate else ""

        hints_section = f"""
=== HINTS (algorithm guidance) ===
{hints_str}
=== END HINTS ===
""" if hints_str else ""

        constraints_note = self._constraints_guide(problem.constraints)

        return f"""Problem: {problem.title}
Difficulty: {problem.difficulty.value}

Description:
{problem.description}

Constraints:
{problem.constraints}

{constraints_note}

Examples:
{examples_str}
{boilerplate_section}
{hints_section}
Fill in the boilerplate above with the complete solution in {problem.language}.
Follow the hints to choose the most efficient algorithm.
DO NOT change the method signature."""

    @staticmethod
    def _constraints_guide(constraints: str) -> str:
        """Add efficiency guidance based on constraints analysis."""
        # Extract max values from constraints to suggest algorithm complexity
        max_vals = []
        for match in __import__("re").finditer(r"(?:10\^|10<sup>)(\d+)", constraints):
            max_vals.append(int(match.group(1)))

        guide = ""
        if any(v >= 9 for v in max_vals):
            guide = "⚠️ n can be up to 10^9 or more — MUST use O(log n) or O(1) algorithm (matrix exponentiation, math, binary search). O(n) will timeout."
        elif any(v >= 6 for v in max_vals):
            guide = "⚠️ n can be up to 10^6 — use O(n) or O(n log n) algorithm at most."
        elif any(v >= 5 for v in max_vals):
            guide = "⚠️ n can be up to 10^5 — use O(n log n) or better."

        return f"\nEFFICIENCY REQUIREMENT: {guide}" if guide else ""

    @staticmethod
    def _clean_code(code: str) -> str:
        """Remove markdown code fences if present."""
        code = code.strip()
        if code.startswith("```"):
            first_newline = code.find("\n")
            if first_newline != -1:
                code = code[first_newline + 1:]
        if code.endswith("```"):
            code = code[:-3].rstrip()
        return code.strip()
