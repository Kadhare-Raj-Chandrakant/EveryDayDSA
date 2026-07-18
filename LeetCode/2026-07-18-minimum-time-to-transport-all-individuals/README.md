# Minimum Time to Transport All Individuals

- **Difficulty**: Hard
- **Source**: [Leetcode](https://leetcode.com/problems/minimum-time-to-transport-all-individuals/)
- **Date**: 2026-07-18
- **Language**: java


**The Problem**

Given the number of people n, the number of planes k, and the time to cross each plane m and time required to cross each plane (time, mul) pair, find the minimum time to transport all individuals.

**Initial Thoughts**

Let's start by using dynamic programming to solve this problem. We'll create a 2D array dp of size (n+1) x (1<<n) x m, where dp[i][j][k] represents the minimum time required to transport the first i people, with masks j and the current stage k.

We'll start by initializing dp[0][0][0] as 0. Then, we'll iterate through all possible people and stages using a priority queue (pq) to find the minimum time required.

**The Core Trick**

The key to solving this problem is using a mask to track which people have been transported. We'll use a binary mask to represent a subset of people, and update the mask as we add or remove people from the transport. This allows us to efficiently track which people have been transported and which haven't.

**Complexity**

Time complexity: O(n * 2^n * m * k log(n * 2^n * m * k))

Space complexity: O(n * 2^n * m)

**Key Takeaway**

When dealing with problems involving dynamic programming and masks, it's important to carefully consider how to represent the current state and update it as the problem evolves. In this case, the mask allows us to efficiently track which people have been transported, making it possible to efficiently find the minimum time required to transport all people.