# Minimum Speed to Arrive on Time

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/minimum-speed-to-arrive-on-time/)
- **Date**: 2026-08-16
- **Language**: java


**The Problem**

Given an array of distances between trains and the number of hours to catch the train, return the minimum speed to reach the train on time.

**Initial Thoughts**

At first glance, this problem seems like a classic optimization problem, where we need to find the minimum value of a function subject to certain constraints. However, it's not immediately clear how to translate this into a coding problem. I tried a brute-force approach, checking every possible speed and seeing if it meets the time constraint, but it was too slow for large inputs.

**The Core Trick**

The key to solving this problem is to realize that we can use binary search to find the minimum speed that meets the time constraint. By repeatedly dividing the speed range in half, we can quickly narrow down the possible speeds and find the minimum one that works.

**Complexity**

The time complexity of this solution is O(n log k), where n is the number of trains and k is the maximum possible speed. This is because we need to perform binary search on a range of possible speeds, which takes log(right - left) operations on average. The space complexity is O(1), as we only need a constant amount of auxiliary space.

**Key Takeaway**

This problem teaches us that sometimes, even seemingly simple optimization problems can be solved using clever algorithms. By recognizing that binary search is an effective tool for finding the minimum value of a function subject to certain constraints, we can solve this problem efficiently.