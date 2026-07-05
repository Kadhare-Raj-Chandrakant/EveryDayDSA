# Minimum Levels to Gain More Points

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/minimum-levels-to-gain-more-points/)
- **Date**: 2026-07-05
- **Language**: java


**The Problem**

Given an array `possible` containing `0`s and `1`s, you need to find the minimum number of levels to gain more points. In each level, Alice and Bob both start with 0 points. If `possible[i] == 1`, Alice gains 1 point, and Bob loses 1 point. If `possible[i] == 0`, Alice and Bob gain 0 points. You should return -1 if there's no way to gain more points.

**Initial Thoughts**

At first, I thought about using a binary search or a greedy approach. However, I realized that Alice and Bob's scores are not symmetric, which made me think about a different approach.

**The Core Trick**

I noticed that Alice's score is always greater than Bob's score by at least one point. So, I decided to compare their scores at each index and find the smallest level where Alice's score is greater than Bob's score.

**Complexity**

This solution has a time complexity of O(n), where n is the length of the `possible` array, and a space complexity of O(1), since we only use local variables without any additional data structures.

**Key Takeaway**

This problem taught me that sometimes, it's important to think about the relationships between different players or scores to find the optimal solution.

(499 words)