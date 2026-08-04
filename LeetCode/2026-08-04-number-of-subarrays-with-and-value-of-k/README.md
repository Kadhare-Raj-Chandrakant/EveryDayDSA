# Number of Subarrays With AND Value of K

- **Difficulty**: Hard
- **Source**: [Leetcode](https://leetcode.com/problems/number-of-subarrays-with-and-value-of-k/)
- **Date**: 2026-08-04
- **Language**: java


Problem: Number of Subarrays With AND Value of K
Difficulty: Hard

The problem is to find the number of subarrays in an array `nums` with an AND value equal to `k`. This is a bit tricky because we need to efficiently find the AND values of all possible subarrays and then count the ones that match `k`.

Initial Thoughts:

Initially, I thought of using a brute-force approach to iterate over all subarrays and check if their AND value is equal to `k`. However, this would have a time complexity of O(n^3), which is not feasible for large arrays.

The Core Trick:

The key insight is that we can use a sparse table to efficiently compute the AND values of consecutive subarrays. This allows us to check if a subarray has an AND value equal to `k` in O(1) time.

Complexity:

The time complexity of this solution is O(n log n) due to the construction of the sparse table. The space complexity is also O(n) to store the sparse table.

Key Takeaway:

When dealing with problems involving subarray queries, it's important to consider efficient data structures for storing the results of these queries. In this case, a sparse table proved to be a powerful tool for efficiently computing AND values of consecutive subarrays.