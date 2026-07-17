# Orderly Queue

- **Difficulty**: Hard
- **Source**: [Leetcode](https://leetcode.com/problems/orderly-queue/)
- **Date**: 2026-07-17
- **Language**: java


**The Problem**

Given a string `s` and an integer `k`, reorder `s` to minimize the difference between any two consecutive characters. If `k` is 1, rearrange the string as `s[0] + s[1] + ... + s[n-1]`.

**Initial Thoughts**

Initially, I thought about using a brute-force approach, where I would sort the string and compare the adjacent characters to see if they were in order. This would take `O(n log n)` time complexity for sorting and `O(n)` time complexity for string concatenation, resulting in a total time complexity of `O(n log n)`. I also considered using a priority queue to keep track of the characters in descending order based on their value, but that would require additional data structures and would be slower than the brute-force approach.

**The Core Trick**

The interesting part of this problem is that `k` can be 1 or more than 1. In the case of `k > 1`, the problem becomes a classic sorting problem, where we need to sort the string in ascending order. The tricky part is to minimize the difference between any two consecutive characters. Therefore, a natural approach is to sort the string in descending order instead of ascending order. This way, the smallest character will be at the beginning and the largest character will be at the end. In the case of `k = 1`, we just need to concatenate the first and second characters in ascending order to get the minimum difference.

**Complexity**

Time complexity: `O(n log n)` for sorting, `O(n)` for string concatenation.

Space complexity: `O(n)` for storing the sorted string.

**Key Takeaway**

The key takeaway from this problem is that small changes in the problem formulation can lead to significant optimizations. In this problem, changing the order of comparison from ascending to descending leads to a faster sorting algorithm and a simpler solution.