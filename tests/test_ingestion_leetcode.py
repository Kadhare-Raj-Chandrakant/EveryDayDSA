"""Tests for the LeetCode fetcher (primary ingestion path)."""

from unittest.mock import Mock, patch

import pytest
import requests

from src.ingestion.leetcode import LeetCodeFetcher
from src.ingestion.base import IngestionError


def _mock_listing(problems: list[dict]) -> dict:
    return {"problemsetQuestionList": problems, "totalQuestions": 1000}


SAMPLE_PROBLEM = {
    "title": "Two Sum",
    "titleSlug": "two-sum",
    "difficulty": "Easy",
    "isPaidOnly": False,
}


class TestLeetCodeFetcher:
    def setup_method(self):
        self.fetcher = LeetCodeFetcher(
            api_url="https://fake-api.test",
            timeout=5,
            language="cpp",
            page_size=50,
        )

    def test_parse_problem_basic(self):
        """Parse raw API response into ProblemContext."""
        data = {
            "title": "Two Sum",
            "titleSlug": "two-sum",
            "difficulty": "Easy",
            "content": "<p>Find two numbers.</p>",
            "exampleTestcases": "[1,2,3]\n6\n",
            "codeSnippets": [
                {"langSlug": "cpp", "code": "class Solution {};"}
            ],
            "hints": ["Use a hash map"],
        }
        problem = self.fetcher._parse_problem(data)
        assert problem.title == "Two Sum"
        assert problem.difficulty.value == "Easy"
        assert "Find two numbers." in problem.description
        assert problem.boilerplate == "class Solution {};"
        assert len(problem.examples) == 1
        assert problem.hints == ["Use a hash map"]
        assert problem.source == "leetcode"

    def test_parse_problem_falls_back_to_first_snippet(self):
        """When target language snippet is missing, use first available."""
        data = {
            "title": "Test",
            "titleSlug": "test",
            "difficulty": "Medium",
            "content": "",
            "codeSnippets": [
                {"langSlug": "python", "code": "def test(): pass"},
                {"langSlug": "java", "code": "class Test {}"},
            ],
        }
        problem = self.fetcher._parse_problem(data)
        assert problem.boilerplate == "def test(): pass"

    def test_strip_html(self):
        """HTML tags should be stripped from descriptions."""
        html = "<p>Hello <b>World</b> &amp; Co.</p>"
        text = LeetCodeFetcher._strip_html(html)
        assert "Hello World & Co." in text
        assert "<" not in text

    @patch.object(LeetCodeFetcher, "_list_problems")
    @patch.object(LeetCodeFetcher, "_get_total_problems")
    @patch.object(LeetCodeFetcher, "fetch_by_slug")
    def test_fetch_returns_problem(
        self, mock_fetch_by_slug, mock_total, mock_list
    ):
        """fetch() should return a ProblemContext."""
        mock_total.return_value = 1000
        mock_list.return_value = [SAMPLE_PROBLEM]
        mock_fetch_by_slug.return_value = Mock(
            title="Two Sum",
            difficulty=Mock(value="Easy"),
            source="leetcode",
        )

        problem = self.fetcher.fetch()
        assert problem.title == "Two Sum"

    @patch.object(LeetCodeFetcher, "_list_problems")
    @patch.object(LeetCodeFetcher, "_get_total_problems")
    def test_fetch_excludes_solved_slugs(
        self, mock_total, mock_list
    ):
        """fetch() should skip problems in exclude_slugs."""
        mock_total.return_value = 1000
        problem_b = {**SAMPLE_PROBLEM, "title": "Three Sum", "titleSlug": "three-sum"}
        mock_list.return_value = [SAMPLE_PROBLEM, problem_b]

        with patch.object(self.fetcher, "fetch_by_slug") as mock_detail:
            mock_detail.return_value = Mock(title="Three Sum")
            problem = self.fetcher.fetch(exclude_slugs={"two-sum"})
            # Should pick three-sum (two-sum is excluded)
            assert mock_detail.call_args[0][0] == "three-sum"

    @patch.object(LeetCodeFetcher, "_list_problems")
    @patch.object(LeetCodeFetcher, "_get_total_problems")
    def test_fetch_raises_when_all_excluded(
        self, mock_total, mock_list
    ):
        """fetch() should raise when all candidates are excluded."""
        mock_total.return_value = 1000
        mock_list.return_value = [SAMPLE_PROBLEM]

        with pytest.raises(IngestionError, match="No unsolved problems"):
            self.fetcher.fetch(exclude_slugs={"two-sum", "other-slug"})

    @patch.object(LeetCodeFetcher, "_list_problems")
    @patch.object(LeetCodeFetcher, "_get_total_problems")
    def test_fetch_filters_paid_only(self, mock_total, mock_list):
        """Paid-only problems should be filtered out."""
        mock_total.return_value = 1000
        paid = {**SAMPLE_PROBLEM, "isPaidOnly": True}
        free = SAMPLE_PROBLEM
        mock_list.return_value = [paid, free]

        with patch.object(self.fetcher, "fetch_by_slug") as mock_detail:
            mock_detail.return_value = Mock(title="Two Sum")
            self.fetcher.fetch()
            # Should pick the free one
            assert mock_detail.called

    def test_fetch_by_slug_network_error(self):
        """Network errors in fetch_by_slug should raise IngestionError."""
        with patch.object(self.fetcher.session, "get") as mock_get:
            mock_get.side_effect = requests.RequestException("timeout")
            with pytest.raises(IngestionError, match="Network error"):
                self.fetcher.fetch_by_slug("two-sum")

    def test_extract_constraints(self):
        """Constraints should be extracted from HTML."""
        html = """
        <p><strong>Constraints:</strong></p>
        <ul>
        <li>2 &lt;= n &lt;= 10^4</li>
        </ul>
        <p>Some more text</p>
        """
        constraints = LeetCodeFetcher._extract_constraints(html)
        assert "2 <= n <= 10^4" in constraints

    def test_extract_constraints_no_match(self):
        """Empty string when no constraints section found."""
        html = "<p>Just a description</p>"
        assert LeetCodeFetcher._extract_constraints(html) == ""

    @patch.object(LeetCodeFetcher, "_get_total_problems")
    def test_fetch_multiple_returns_count(self, mock_total):
        """fetch_multiple should return the requested number of problems."""
        mock_total.return_value = 1000
        problems = [
            {**SAMPLE_PROBLEM, "title": f"Problem {i}", "titleSlug": f"problem-{i}"}
            for i in range(10)
        ]
        with patch.object(self.fetcher, "_list_problems") as mock_list:
            mock_list.return_value = problems
            with patch.object(self.fetcher, "fetch_by_slug") as mock_detail:
                mock_detail.side_effect = [
                    Mock(title=f"Problem {i}") for i in range(3)
                ]
                results = self.fetcher.fetch_multiple(count=3)
                assert len(results) == 3

    @patch.object(LeetCodeFetcher, "_get_total_problems")
    def test_fetch_multiple_excludes_solved(self, mock_total):
        """fetch_multiple should skip excluded slugs."""
        mock_total.return_value = 1000
        problems = [
            {**SAMPLE_PROBLEM, "title": "Skip Me", "titleSlug": "skip-me"},
            {**SAMPLE_PROBLEM, "title": "Keep Me", "titleSlug": "keep-me"},
        ]
        with patch.object(self.fetcher, "_list_problems") as mock_list:
            mock_list.return_value = problems
            with patch.object(self.fetcher, "fetch_by_slug") as mock_detail:
                mock_detail.return_value = Mock(title="Keep Me")
                results = self.fetcher.fetch_multiple(
                    count=1, exclude_slugs={"skip-me"}
                )
                assert len(results) == 1
                assert mock_detail.call_args[0][0] == "keep-me"

    @patch.object(LeetCodeFetcher, "_get_total_problems")
    def test_fetch_multiple_raises_when_insufficient(self, mock_total):
        """fetch_multiple should raise when not enough candidates."""
        mock_total.return_value = 1000
        with patch.object(self.fetcher, "_list_problems") as mock_list:
            mock_list.return_value = [SAMPLE_PROBLEM]
            with pytest.raises(IngestionError, match="Could not find"):
                self.fetcher.fetch_multiple(count=5)
