# Binary String With Substrings Representing 1 To N

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/binary-string-with-substrings-representing-1-to-n/)
- **Date**: 2026-07-14
- **Language**: java


**The Problem**

Given a binary string `s`, determine if it contains a substring for each integer from `1` to `n` inclusive. For example, given `s = "0101", n = 3`, the string contains the substrings "001", "01", and "1" representing the numbers 0, 1, and 2, respectively.

**Initial Thoughts**

Initially, I tried brute-forcing the problem by checking for each integer `i` in the range from `1` to `n` if it's a substring of `s`. However, this approach has a time complexity of `O(n * n)`, which is too slow for large inputs.

**The Core Trick**

To optimize the solution, I realized that I can use the binary representation of each integer as a substring check. This way, I can reduce the time complexity to `O(n log n)` due to the binary representation of integers.

**Complexity**

The time complexity of this solution is `O(n log n)` because we are converting integers to binary strings, which is an `O(log n)` operation, and then checking if any of those substrings are present in `s`. The space complexity is also `O(1)` as we only use a constant amount of space.

**Key Takeaway**

For problems that deal with substrings or string manipulation, consider using the binary representation of integers as a check for each substring. This can help reduce the time complexity significantly.