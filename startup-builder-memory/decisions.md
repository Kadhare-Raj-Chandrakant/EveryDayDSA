# Decision Log

## ADR-001: Python as Primary Implementation Language
**Status**: Accepted
**Context**: Need a scripting language with excellent LLM API support, file I/O, and git integration
**Decision**: Python 3.14+ — best ecosystem for OpenAI/LLM APIs, simple filesystem ops, gitpython
**Consequences**: Fast prototyping, wide LLM library support

## ADR-002: NVIDIA NIM as Default LLM Provider
**Status**: Accepted (2026-06-24, supersedes default model choice)
**Context**: Need cost-effective LLM inference for code generation and documentation
**Decision**: Use NVIDIA NIM (free tier: 1,000 inference credits, 40 req/min) via OpenAI-compatible endpoint at `https://integrate.api.nvidia.com/v1`. Default model: `nvidia/nemotron-mini-4b-instruct`. API key read from `NVIDIA_API_KEY` env var (falls back to `OPENAI_API_KEY`).
**Consequences**: Free LLM access for prototyping, same OpenAI SDK, swap `base_url` to switch providers; 40 req/min rate limit is sufficient for daily single-call pipeline

## ADR-003: GitHub Actions as Cron Trigger
**Status**: Accepted
**Context**: Need daily scheduled execution at 01:00 UTC
**Decision**: GitHub Actions with cron schedule — free, serverless, built-in git + secrets
**Consequences**: No infrastructure to manage, GitHub token auto-injected

## ADR-004: Local Backlog as Fail-Safe (No External API Dependency)
**Status**: Accepted
**Context**: Must maintain daily contributions even if LeetCode API is down
**Decision**: Embedded `backlog.json` with curated classic DSA problems
**Consequences**: Works offline, no API key needed for backlog mode

## ADR-005: Two-Stage LLM Pipeline
**Status**: Accepted
**Context**: Need production-quality code AND human-like documentation
**Decision**: Stage 1 = code generator (correctness-focused), Stage 2 = dev journal writer (natural language)
**Consequences**: Higher token cost but better output quality; each stage has distinct system prompt

## ADR-006: Flat File Storage (No Database)
**Status**: Accepted
**Context**: Only storing DSA solutions organized by date and problem name
**Decision**: Git-based filesystem storage: `./LeetCode/YYYY-MM-DD-Problem-Name/{solution.cpp,README.md}`
**Consequences**: No DB ops, simple git tracking, human-readable

## ADR-007: No Frontend / No Web Server
**Status**: Accepted
**Context**: This is an automated batch pipeline, not a web service
**Decision**: Pure CLI/script-based pipeline triggered by cron
**Consequences**: Simpler deployment, no uptime concerns, no UI to maintain
