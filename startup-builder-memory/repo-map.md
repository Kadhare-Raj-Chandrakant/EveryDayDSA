# Repository Map

## Structure (Planned)

```
GitHubGreenCard/
├── .github/
│   └── workflows/
│       └── daily-solve.yml       # GitHub Actions cron trigger
├── backlog.json                   # Fallback DSA problem bank
├── config.yaml                    # Pipeline configuration
├── src/
│   ├── __init__.py
│   ├── main.py                    # Pipeline orchestrator
│   ├── ingestion/
│   │   ├── __init__.py
│   │   ├── base.py               # Abstract problem fetcher
│   │   ├── leetcode.py           # LeetCode GraphQL API fetcher
│   │   └── backlog.py            # Local backlog fallback
│   ├── execution/
│   │   ├── __init__.py
│   │   ├── llm_client.py         # OpenAI/LLM API client
│   │   ├── code_generator.py     # Stage 1: Generate solution code
│   │   └── doc_writer.py         # Stage 2: Generate dev journal
│   ├── repository/
│   │   ├── __init__.py
│   │   ├── structure.py          # Directory/file creation
│   │   └── git_ops.py            # Git staging, commit, push
│   └── models/
│       ├── __init__.py
│       └── problem.py            # Problem data model
├── tests/
│   ├── __init__.py
│   ├── test_ingestion.py
│   ├── test_execution.py
│   ├── test_repository.py
│   └── test_integration.py
├── requirements.txt
├── setup.py
└── README.md
```

## Key Files
- `src/main.py` — Entry point, pipeline orchestration
- `src/ingestion/leetcode.py` — Primary ingestion path
- `src/ingestion/backlog.py` — Fallback ingestion
- `src/execution/code_generator.py` — LLM Stage 1
- `src/execution/doc_writer.py` — LLM Stage 2
- `src/repository/git_ops.py` — Git commit/push
- `.github/workflows/daily-solve.yml` — Cron trigger
- `config.yaml` — All configuration (API keys, language, paths)
- `backlog.json` — Curated DSA problems for fallback
