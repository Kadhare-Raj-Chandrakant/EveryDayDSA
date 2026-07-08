# Non-decreasing Array

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/non-decreasing-array/)
- **Date**: 2026-07-08
- **Language**: java


**The Problem**

Given an array of integers `nums`, you need to check whether it's possible to remove exactly one duplicate in such a way that all elements in the resulting array are non-decreasing.

**Initial Thoughts**

Initially, I approached this problem by iterating through the array and checking for adjacent elements that are not in non-decreasing order. However, this approach had a time complexity of O(n^2) as I was checking every pair of adjacent elements. I needed to find a more efficient solution.

**The Core Trick**

I realized that if an element is greater than its next element, then removing that element would result in a non-decreasing array. This meant that I could simply count the number of times an element is greater than its next element and return false if that count is greater than one. If no such element exists, then the array is already non-decreasing, and I could return true.

**Complexity**

My solution has a time complexity of O(n), which is the same as the problem statement's. This is because I only need to iterate through the array once to count the number of elements that are not in non-decreasing order. The space complexity is also O(1), as I only store a constant amount of additional data.

**Key Takeaway**

This problem taught me the importance of considering all possible solutions upfront, even if they seem inefficient. Sometimes, the most straightforward solution is the best one, and it's crucial to consider all possible pitfalls and edge cases.