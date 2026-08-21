# Maximum Difference Between Increasing Elements

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/maximum-difference-between-increasing-elements/)
- **Date**: 2026-08-21
- **Language**: java


**The Problem**

Given an array of integers, the task is to find the maximum possible difference between any two increasing elements in the array. An increasing element is one that is strictly greater than all elements before it in the array.

**Initial Thoughts**

At first glance, this problem seems simple, but I struggled to come up with a clear approach. I tried using a brute-force method, checking every pair of elements and finding the maximum difference, but that would be too slow for large inputs. I also tried using a binary search, but that would have a higher time complexity.

**The Core Trick**

The key to solving this problem efficiently is to notice that we can find all increasing elements in the array and then iterate through them, finding the difference with each element. This way, we can avoid checking every pair of elements and instead focus on the increasing elements themselves.

**Complexity**

Time complexity: O(n), where n is the number of elements in the array. We iterate through the array once to find all increasing elements, and then we iterate through them once to find the maximum difference.

Space complexity: O(1), as we only use a constant amount of space to store the minimum number seen so far.

**Key Takeaway**

When faced with a problem that seems too simple or too complex, try to break it down into smaller, more manageable pieces. In this case, noticing that we could find all increasing elements and then iterate through them was a crucial step in solving this problem efficiently.