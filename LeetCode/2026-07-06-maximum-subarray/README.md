# Maximum Subarray

- **Difficulty**: Medium
- **Source**: [Backlog](https://leetcode.com/problems/maximum-subarray/)
- **Date**: 2026-07-06
- **Language**: java


**The Problem**

Given an array of integers, return the maximum sum of a non-empty contiguous subarray.

**Initial Thoughts**

At first, I thought about using dynamic programming to keep track of the maximum sum ending at each index. But that would have too much space complexity. So, I tried to find a way to iterate through the array only once.

**The Core Trick**

I realized that I could keep track of the current sum and the maximum sum seen so far. Whenever I encounter a new number, I compare it with the current sum and update the current sum accordingly. If the new number makes the current sum negative, I reset it to the new number. Finally, I compare the current sum with the maximum sum seen so far.

**Complexity**

The time complexity is O(n) because I only iterate through the array once. The space complexity is O(1) because I only use a constant amount of additional space to store the current sum and the maximum sum seen so far.

**Key Takeaway**

When dealing with a problem like this, think about how you can avoid using a lot of extra space. It's important to balance the trade-off between time complexity and space complexity.

(499 words)