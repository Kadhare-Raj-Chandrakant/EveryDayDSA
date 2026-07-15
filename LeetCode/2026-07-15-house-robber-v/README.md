# House Robber V

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/house-robber-v/)
- **Date**: 2026-07-15
- **Language**: java


**The Problem**

House Robber V is a Medium-difficulty problem where you need to determine the maximum amount of money that can be stolen from a house using different colored houses. The input is an integer array `nums` representing the value of each house, and an additional integer array `colors` indicating whether the house is red or blue. If a house is red, it can be robbed only once. If a house is blue, it can be robbed twice. You need to return the maximum amount of money you can steal from the house.

**Initial Thoughts**

At first glance, this problem seems quite straightforward. However, I quickly realized that it involves a dynamic programming approach, which might be challenging to implement. My initial thought was to use a brute force solution, where I iterate through all possible combinations of houses to be robbed and compare their values. This approach has a time complexity of O(2^n), which is unacceptable for large inputs.

**The Core Trick**

The core trick in this problem is to use a dynamic programming approach. We maintain two arrays `dp[i]` and `dp[i-1]`, where `dp[i]` represents the maximum amount of money that can be stolen from i-1 houses, considering that the house at index i is red or not. If the house at index i is blue, we can rob it twice, so we also consider `dp[i-2]` as an alternative. We iterate through all houses, updating `dp[i]` based on its previous values and the value of the current house.

**Complexity**

The time complexity of the solution is O(n), as we iterate through all houses only once. The space complexity is also O(n), as we maintain two arrays to store the dynamic programming state.

**Key Takeaway**

This problem teaches you the importance of considering edge cases when implementing dynamic programming solutions. In addition, it highlights the need for careful analysis of the input data to determine the appropriate approach for solving a problem.