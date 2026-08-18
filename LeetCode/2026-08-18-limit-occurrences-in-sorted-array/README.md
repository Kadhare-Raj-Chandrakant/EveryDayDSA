# Limit Occurrences in Sorted Array

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/limit-occurrences-in-sorted-array/)
- **Date**: 2026-08-18
- **Language**: java


**The Problem**

Given an array of integers `nums` and an integer `k`, remove the duplicates in `nums` that occur more than `k` times. Return the array after removing these excess duplicates.

**Initial Thoughts**

This problem seems to be a combination of removing duplicates and limiting occurrences. I initially thought about using a hash map to keep track of the count of each element in `nums`. Then, iterate through the map, keeping only the elements with count less than or equal to `k`. However, this solution has a time complexity of O(n^2), as we need to iterate through the array and the map separately.

**The Core Trick**

To optimize the time complexity, I realized that we can make a single pass through the array and use a sliding window approach. In this approach, we keep track of the last seen element and increment its count. If the count exceeds `k`, we update the last seen element with the current element and reset its count.

**Complexity**

This solution has a time complexity of O(n) and a space complexity of O(n), as we are creating a new array of the same size as the original array.

**Key Takeaway**

This problem highlights the importance of optimization in data structures and algorithms. Although a hash map solution would have worked, the sliding window approach is more efficient.

In conclusion, even if the problem seems simple, it's essential to think about the time and space complexity to come up with an optimal solution.