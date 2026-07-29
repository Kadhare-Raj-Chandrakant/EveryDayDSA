# Combinations

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/combinations/)
- **Date**: 2026-07-29
- **Language**: java


**The Problem**

Given two integers `n` and `k`, find all possible combinations of `n` items taken `k` at a time.

**Initial Thoughts**

At first, I thought about using a brute-force approach, where I generate all combinations of `n` items taken `k` at a time and then check if they satisfy the condition. However, this would be too slow for large values of `n` and `k`.

**The Core Trick**

Instead, I decided to use backtracking to generate all combinations recursively. This approach has a time complexity of O(C(n, k)) and a space complexity of O(C(n, k) * k) for storing the combinations.

**Complexity**

The time complexity of the algorithm is O(C(n, k)) because for each combination, we need to generate `k` elements out of `n` elements. The space complexity is also O(C(n, k) * k) because we need to store the intermediate results and the final combinations.

**Key Takeaway**

Backtracking is a powerful technique for generating all combinations of a given set of elements. It can be used efficiently by combining it with dynamic programming or other optimization techniques.

In conclusion, this problem taught me the importance of using efficient algorithms and data structures when dealing with large inputs.