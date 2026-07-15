# GitHubGreenCard

**Automated DSA Portfolio Engine** — solves a random LeetCode problem daily using LLMs, commits the solution to GitHub, and builds a consistent contribution graph.

## How It Works

```
  1. Pick a random LeetCode problem
  2. write a C++ solution via NVIDIA NIM (meta/llama-3.1-70b-instruct)
  3. Write a humanized dev journal via a lighter LLM (nvidia/nemotron-mini-4b-instruct)
  4. Save to LeetCode/YYYY-MM-DD-title/{solution.cpp, README.md}
  5. Commit and push to GitHub (author = the triggering user)
```

Each commit produces a green square on your GitHub contribution graph for that day.

## Quick Start

### Prerequisites

- Python 3.14+
- A [NVIDIA NIM](https://build.nvidia.com) API key (free tier: 1,000 inference credits, 40 req/min)
- Git configured with access to your GitHub repository

### Local Setup

```bash
git clone https://github.com/yash1648/github-green.git
cd github-green
python -m venv .venv && source .venv/bin/activate
pip install -r requirements.txt

# Set your API key
export NVIDIA_API_KEY="nvapi-..."

# Dry-run (generates files, no git operations)
DRY_RUN=true python -m src.main

# Live run (generates + commits + pushes)
python -m src.main
```

### GitHub Actions Setup

1. Add `NVIDIA_API_KEY` to [repository secrets](https://github.com/yash1648/github-green/settings/secrets/actions)
2. Push to `main` or trigger manually via **Actions → Daily DSA Solve → Run workflow**

## Output Structure

```
LeetCode/
└── 2026-06-25-restore-the-array-from-adjacent-pairs/
    ├── solution.cpp      ← LeetCode-submittable C++ code
    └── README.md         ← Humanized dev journal
```

- **solution.cpp**: Contains only `class Solution { ... };` — no `#include`, `main()`, or I/O. Ready to paste into LeetCode.
- **README.md**: Problem summary, algorithmic approach, complexity analysis, and a "developer journal" section written to mimic a real developer's notes.

## Pipeline Details

| Stage | Tool | Model / Source |
|---|---|---|
| Ingestion | alfa-leetcode-api (REST) | `/problems` random page → `/select/raw` full detail |
| Code gen | NVIDIA NIM (LLM) | `meta/llama-3.1-70b-instruct`, temp 0.2 |
| Doc writing | NVIDIA NIM (LLM) | `nvidia/nemotron-mini-4b-instruct`, temp 0.7 |
| Structure | Local filesystem | `LeetCode/YYYY-MM-DD-title/{solution.cpp, README.md}` |
| Git | Git CLI | `git add → commit → pull --rebase → push` (3 retries) |

### Unique Features

- **Random problems** — picks from 3,973 free LeetCode problems, not the daily challenge
- **Exact boilerplate** — extracts the exact `class Solution` signature from LeetCode's `codeSnippets`
- **Anti-AI tone** — the doc model is prompted to avoid buzzwords like "furthermore" or "let's dive in"
- **Fallback** — if LeetCode API is down, loads from `backlog.json` (5 curated problems)
- **Randomized cron** — the scheduled run sleep-delays into one of two windows (midnight-3am or 6am-noon) to avoid predictability

## Configuration

All settings in [`config.yaml`](config.yaml):

```yaml
pipeline:
  language: "cpp"
  output_root: "LeetCode"

execution:
  llm:
    base_url: "https://integrate.api.nvidia.com/v1"
    model_code: "meta/llama-3.1-70b-instruct"
    model_doc: "nvidia/nemotron-mini-4b-instruct"
    temperature_code: 0.2
    temperature_doc: 0.7
    max_tokens_code: 4096
    max_tokens_doc: 1500
```

## Commands

```bash
# Dry run — fetch + generate, no git operations
DRY_RUN=true python -m src.main

# Production run
python -m src.main

# Run tests
python -m pytest tests/ -v

# Lint (if ruff installed)
ruff check src/
```

## Tests

26 tests across 8 test files covering ingestion, LLM execution, repository management, and end-to-end orchestration.

```bash
python -m pytest tests/ -v
```

## Environment Variables

| Variable | Required | Description |
|---|---|---|
| `NVIDIA_API_KEY` | Yes | NVIDIA NIM API key (starts with `nvapi-`) |
| `OPENAI_API_KEY` | No | Fallback if not using NVIDIA NIM |
| `GITHUB_TOKEN` | In CI | Auto-injected by GitHub Actions for push |
| `DRY_RUN` | No | Set to `true` to skip git operations |

## Project Structure

```
├── .github/workflows/daily-solve.yml   # CI pipeline
├── src/
│   ├── main.py                         # Orchestrator
│   ├── models/problem.py               # ProblemContext dataclass
│   ├── ingestion/
│   │   ├── leetcode.py                 # Random problem fetcher
│   │   ├── backlog.py                  # Local backlog fallback
│   │   └── base.py                     # Abstract fetcher
│   ├── execution/
│   │   ├── llm_client.py               # OpenAI-compatible LLM wrapper
│   │   ├── code_generator.py           # Stage 1: code generation
│   │   ├── doc_writer.py               # Stage 2: dev journal
│   │   └── exceptions.py               # Pipeline exception types
│   └── repository/
│       ├── structure.py                # File writer
│       └── git_ops.py                  # Commit + push with retry
├── tests/                              # 26 tests
├── config.yaml                         # Pipeline configuration
├── backlog.json                        # Fallback problem bank
├── requirements.txt                    # Python dependencies
└── README.md                           # This file
```

## License

MIT
