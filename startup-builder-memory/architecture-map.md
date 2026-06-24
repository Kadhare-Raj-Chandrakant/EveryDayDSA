# Architecture Map

## System Context
Automated batch pipeline that runs daily at 01:00 UTC via GitHub Actions.

## Architecture Diagram (Text)

```
[GitHub Actions Cron] --> {01:00 UTC daily}
         |
         v
  ┌──────────────────────────────┐
  │   Orchestrator (main.py)     │
  │   - Coordinates pipeline     │
  │   - Error handling + retry   │
  └──────┬───────────────────────┘
         |
    ┌────┴───────────────────────┐
    │  Module 1: Ingestion       │
    │  ┌────────────────────┐    │
    │  │ LeetCode GraphQL   │    │  <- Primary path
    │  │ (Primary)          │    │
    │  └────────┬───────────┘    │
    │           │ (fails)        │
    │           v                │
    │  ┌────────────────────┐    │
    │  │ Backlog JSON       │    │  <- Fallback path
    │  │ (Local)            │    │
    │  └────────┬───────────┘    │
    └───────────┼────────────────┘
                │ Problem Context
                v
  ┌──────────────────────────────┐
  │  Module 2: Execution (LLM)   │
  │  ┌────────────────────┐      │
  │  │ Stage 1: Code Gen  │      │  -> solution.cpp
  │  │ (LLM Gen 1)        │      │
  │  └────────┬───────────┘      │
  │           │ code + problem    │
  │           v                  │
  │  ┌────────────────────┐      │
  │  │ Stage 2: Doc Writer│      │  -> README.md
  │  │ (LLM Gen 2)        │      │
  │  └────────┬───────────┘      │
  └───────────┼──────────────────┘
              │ artifacts
              v
  ┌──────────────────────────────┐
  │  Module 3: Repository        │
  │  - Create folder structure   │
  │  - Write solution + README   │
  └───────────┬──────────────────┘
              │ staged files
              v
  ┌──────────────────────────────┐
  │  Module 4: Deployment        │
  │  - git add / commit / push   │
  │  -> GitHub contribution       │
  └──────────────────────────────┘
```

## Data Flow
1. Cron trigger → orchestrator
2. Orchestrator calls ingestion module
3. Ingestion returns `ProblemContext` (title, description, constraints, boilerplate, source)
4. `ProblemContext` → Stage 1 (LLM Code Gen) → solution code string
5. `ProblemContext` + solution code → Stage 2 (LLM Doc Writer) → markdown string
6. Repository module creates `./LeetCode/YYYY-MM-DD-Title/` directory
7. Writes `solution.cpp` and `README.md`
8. Git module stages, commits with message, pushes to `main`

## Boundaries
- **Ingestion** ↔ **Execution**: `ProblemContext` dataclass
- **Execution** ↔ **Repository**: file content strings + metadata
- **Repository** ↔ **Deployment**: git commands

## Security Boundaries
- LLM API key in GitHub Secrets (not in repo)
- GitHub token auto-injected by Actions
- No user input — fully automated pipeline

## Failure Modes
1. LeetCode API down → backlog fallback (circuit breaker)
2. LLM API failure → retry 3x, then skip day
3. Git push conflict → retry with rebase
4. Any unhandled error → log, fail gracefully, no partial commits
