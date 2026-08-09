# New 21 Game

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/new-21-game/)
- **Date**: 2026-08-09
- **Language**: java


**The Problem**

The New 21 Game asks to calculate the probability of winning given a deck of n cards, k chosen cards, and a maximum score of maxPts. This is a dynamic programming problem where we need to keep track of the probability at each step and maximize it over the range of valid moves.

**Initial Thoughts**

At first, I thought about using recursion, but I knew it would be too slow. Then I thought about a simpler approach using a loop, but I couldn't figure out how to calculate the probabilities for each step. I also tried using matrix exponentiation, but I couldn't make it work efficiently.

**The Core Trick**

The key to solving this problem is to keep track of the probabilities for each step and update them based on the valid moves. We can use dynamic programming to store the probabilities for each step and update them as needed. This way, we don't need to recalculate the probabilities for each step, which would be computationally expensive.

**Complexity**

Time complexity: O(n) because we are iterating over the range of valid steps. Space complexity: O(n) because we are storing the probabilities for each step in a 1-dimensional array.

**Key Takeaway**

This problem taught me the importance of dynamic programming in solving problems with overlapping subproblems. By using a bottom-up approach, we can avoid repeated calculations and solve the problem efficiently. I also learned that sometimes, even when we have a solution, it might not be the most efficient way to solve the problem. In this case, I had to think harder about how to update the probabilities for each step.