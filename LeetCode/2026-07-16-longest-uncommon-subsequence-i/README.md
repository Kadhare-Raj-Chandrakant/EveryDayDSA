# Longest Uncommon Subsequence I

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/longest-uncommon-subsequence-i/)
- **Date**: 2026-07-16
- **Language**: java


**The Problem**

Given two strings `A` and `B`, find the length of the longest uncommon subsequence between them. A subsequence is a sequence that can be derived from one sequence by deleting some elements without changing the order of the remaining elements. For example, `string1 = "abc"`, `string2 = "abcd"`, the longest uncommon subsequence is `length = 2`, which is `'bc'`.

**Initial Thoughts**

I thought about the problem for a minute and came up with a brute-force approach. I would check all possible substrings of `A` and `B`, and find the longest one that doesn't appear in the other string. This approach has a time complexity of O(n^3) where n is the length of `A` and `B`. I realized that this solution was too slow for large inputs.

**The Core Trick**

I decided to use a more efficient approach, which is to compare the lengths of `A` and `B`. If they are equal, then the longest uncommon subsequence has length -1. Otherwise, I'll take the maximum of their lengths to find the length of the longest uncommon subsequence. This way, I can avoid checking all possible substrings.

**Complexity**

Time complexity: O(1) since the lengths of `A` and `B` are fixed.

Space complexity: O(1) since no extra space is used.

**Key Takeaway**

This problem taught me to think efficiently and avoid unnecessary computations. In this case, comparing the lengths of two strings is much faster than checking all possible substrings.