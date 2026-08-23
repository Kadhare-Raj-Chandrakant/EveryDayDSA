# Minimum Positive Sum Subarray 

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/minimum-positive-sum-subarray/)
- **Date**: 2026-08-23
- **Language**: java


The problem I solved today was Minimum Positive Sum Subarray from LeetCode. The goal was to find a contiguous subarray within an array `nums` with the maximum sum, where the subarray's size is between `l` and `r`. 

Initially, I tried a brute-force approach, iterating through all possible subarrays and calculating their sums. However, this solution had a time complexity of O(n^3), which was not efficient.

The core trick that made this problem interesting was realizing that we only needed to consider subarrays that had a sum greater than zero. This significantly reduced the number of calculations required. 

To analyze the time and space complexity, let's consider the worst case scenario. If we have an array containing all positive numbers, the time complexity of this solution would be O(n^2), which is still too high. However, if we assume that `l` and `r` are both less than or equal to the size of the array `nums`, then the time complexity becomes O(n), and the space complexity remains O(1). 

In conclusion, I found this problem to be challenging but solvable. The key takeaway is to be mindful of the boundaries of our solutions and think creatively to reduce the number of calculations required.