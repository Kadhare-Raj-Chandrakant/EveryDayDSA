# K Inverse Pairs Array

- **Difficulty**: Hard
- **Source**: [Leetcode](https://leetcode.com/problems/k-inverse-pairs-array/)
- **Date**: 2026-08-19
- **Language**: java


The problem I solved today was the "K Inverse Pairs Array" from LeetCode. It involves finding the number of ways to partition a given array into k subarrays with a specific condition. My solution was a dynamic programming approach with a time complexity of O(n*k) and a space complexity of O(n*k). Here's how I approached it.

**The Problem**
Given an array of integers `nums` and an integer `k`, return the number of ways to partition `nums` into `k` non-empty subarrays such that the sum of elements in each subarray is equal.

**Initial Thoughts**
At first, I thought about brute-forcing all possible partitions and checking if the sum of elements in each subarray is equal. However, this approach would be exponential in time complexity, so I decided to use dynamic programming to optimize it.

**The Core Trick**
The core trick in this problem is to use a two-dimensional array `dp` of size `n+1` x `k+1`, where `dp[i][j]` represents the number of ways to partition the first `i` elements of the array into `j` subarrays. The base case `dp[0][0]` is set to 1 since we can partition an empty array into zero subarrays.

**Complexity**
The time complexity of this solution is O(n*k) because for each element in the array, we need to consider all possible partitions up to that element's index. The space complexity is also O(n*k) because we are storing the results for all possible partitions of all elements in the array.

**Key Takeaway**
This problem taught me the importance of using dynamic programming to optimize brute-force solutions. By carefully designing the state and transition rules, we can create a custom solution tailored to the specific problem.