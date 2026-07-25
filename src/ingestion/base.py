"""Abstract base for problem ingestion sources."""

from abc import ABC, abstractmethod

from src.models.problem import ProblemContext

class ProblemFetcher(ABC):
    """Abstract interface for all problem ingestion sources."""

    @abstractmethod
    def fetch(self) -> ProblemContext:
        """Fetch a problem and return a normalized ProblemContext.

        Raises:
            IngestionError: If the problem cannot be fetched.
        """
        ...


class IngestionError(Exception):
    """Raised when problem ingestion fails."""
    pass
