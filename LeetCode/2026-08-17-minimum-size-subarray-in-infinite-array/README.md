# Minimum Size Subarray in Infinite Array

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/minimum-size-subarray-in-infinite-array/)
- **Date**: 2026-08-17
- **Language**: java


Today, I tackled a medium-difficulty problem from LeetCode, Minimum Size Subarray in Infinite Array. This problem asks to find the minimum size of a subarray in an infinite array that adds up to a specific target value.

Initially, I approached this problem by looking at the brute-force idea of checking all possible subarrays, but it was clear that this would be too slow. I then thought about using a prefix sum array, which would help me to quickly calculate the sum of any contiguous subarray. With this insight, I implemented a solution that iterates over the array and the target sum, checking if any subarray sums up to the target. If it does, I update the minimum length of the subarray.

The complexity of this solution is linear with respect to the size of the array, as I iterate over all possible subarrays. However, the space complexity is also linear due to the use of a prefix sum array.

This problem taught me the importance of thinking about the problem structure before diving into coding. By identifying the core trick (the use of a prefix sum array) early on, I was able to design an efficient algorithm. I'm excited to use this approach in future problems.