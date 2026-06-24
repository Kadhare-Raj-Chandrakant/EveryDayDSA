# Product Brief: Automated DSA Portfolio Engine

## One-Liner
A fully autonomous pipeline that solves a daily DSA problem, generates human-quality documentation, and commits it to GitHub — maintaining a consistent green contribution graph.

## Target Personas
1. **Job-Seeking Developer** — wants a professional DSA portfolio on GitHub to showcase problem-solving skills to recruiters
2. **Consistency-Focused Engineer** — wants to maintain daily coding habits but lacks time to manually solve + document every day
3. **Profile Optimizer** — wants the GitHub contribution graph to show consistent daily activity

## User Journeys

### Primary Journey: Daily Auto-Solve
1. At 01:00 UTC, pipeline fetches LeetCode Problem of the Day
2. LLM generates optimal solution code
3. Second LLM writes a human-sounding "dev journal" README
4. Files are committed and pushed to GitHub
5. User wakes up to a new solved problem + green square

### Fallback Journey: Offline/Backlog Mode
1. If LeetCode API unreachable, system picks from curated backlog
2. Same LLM pipeline generates solution + docs
3. Commit still happens — contribution graph maintained

## MVP Scope

### Must Have (Phase 1)
- [x] Daily GitHub Actions cron trigger
- [x] LeetCode GraphQL API ingestion
- [x] Local backlog fallback (JSON)
- [x] LLM Stage 1: Code generation
- [x] LLM Stage 2: Humanized documentation
- [x] Git commit + push
- [x] Config file (language, paths, API keys)
- [x] Comprehensive error handling

### Nice to Have (Post-MVP)
- [ ] Multiple language support (Python, Java, etc.)
- [ ] Solution testing via LeetCode submit
- [ ] Multiple platform support (CodeForces, etc.)
- [ ] Metrics dashboard
- [ ] PR review workflow

### Non-Goals (Explicitly Out of Scope)
- No web UI or frontend
- No user authentication system
- No database (pure git storage)
- No real-time processing
- No mobile app
- No social features

## Key Metrics
- Daily commits: 1 per day
- Zero failed days (backlog fallback ensures this)
- Green contribution graph: 365 days/year
