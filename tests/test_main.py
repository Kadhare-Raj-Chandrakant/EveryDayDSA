"""Tests for main pipeline orchestration."""

from unittest.mock import Mock, patch

import pytest

from src.main import load_config, setup_logging, fetch_problem


class TestLoadConfig:
    def test_load_existing_config(self):
        """load_config should parse the YAML config file."""
        config = load_config("config.yaml")
        assert isinstance(config, dict)
        assert "pipeline" in config
        assert "ingestion" in config
        assert "execution" in config
        assert config["pipeline"]["language"] == "java"

    def test_load_missing_config(self):
        """Missing config file should return empty dict."""
        config = load_config("/nonexistent/config.yaml")
        assert config == {}


class TestSetupLogging:
    def test_setup_logging_does_not_crash(self):
        """Logging setup should not raise exceptions."""
        config = {"logging": {"level": "DEBUG", "format": "%(message)s"}}
        setup_logging(config)  # Should not raise


class TestFetchProblem:
    @patch("src.main.LeetCodeFetcher")
    def test_fetch_primary_path(self, mock_fetcher_class):
        """fetch_problem should try LeetCode first."""
        mock_fetcher = Mock()
        mock_fetcher_class.return_value = mock_fetcher
        mock_problem = Mock()
        mock_problem.title = "Daily Problem"
        mock_fetcher.fetch.return_value = mock_problem

        config = {"ingestion": {"leetcode": {"enabled": True}}, "pipeline": {"language": "cpp"}}
        problem = fetch_problem(config)
        assert problem.title == "Daily Problem"
        mock_fetcher_class.assert_called_once()

    @patch("src.main.AltLeetCodeFetcher")
    @patch("src.main.LeetCodeFetcher")
    @patch("src.main.BacklogFetcher")
    def test_fetch_fallback_path(self, mock_backlog_class, mock_leetcode_class, mock_alt_class):
        """fetch_problem should fallback to backlog when both live APIs fail."""
        from src.ingestion.base import IngestionError

        mock_leetcode = Mock()
        mock_leetcode_class.return_value = mock_leetcode
        mock_leetcode.fetch.side_effect = IngestionError("API down")

        mock_alt = Mock()
        mock_alt_class.return_value = mock_alt
        mock_alt.fetch.side_effect = IngestionError("Alt API down")

        mock_backlog = Mock()
        mock_backlog_class.return_value = mock_backlog
        mock_problem = Mock()
        mock_problem.title = "Backup Problem"
        mock_backlog.fetch.return_value = mock_problem

        config = {"ingestion": {"leetcode": {"enabled": True}}, "pipeline": {"language": "cpp"}}
        problem = fetch_problem(config)
        assert problem.title == "Backup Problem"

    @patch("src.main.AltLeetCodeFetcher")
    @patch("src.main.LeetCodeFetcher")
    def test_fetch_alt_leetcode_fallback(self, mock_leetcode_class, mock_alt_class):
        """fetch_problem should use AltLeetCode when primary API fails."""
        from src.ingestion.base import IngestionError

        mock_leetcode = Mock()
        mock_leetcode_class.return_value = mock_leetcode
        mock_leetcode.fetch.side_effect = IngestionError("API down")

        mock_alt = Mock()
        mock_alt_class.return_value = mock_alt
        mock_problem = Mock()
        mock_problem.title = "Alt Problem"
        mock_problem.source = "alt-leetcode"
        mock_alt.fetch.return_value = mock_problem

        config = {"ingestion": {"leetcode": {"enabled": True}}, "pipeline": {"language": "cpp"}}
        problem = fetch_problem(config)
        assert problem.title == "Alt Problem"
        assert problem.source == "alt-leetcode"
