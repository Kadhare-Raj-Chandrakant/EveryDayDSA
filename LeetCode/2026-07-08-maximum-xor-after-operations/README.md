# Maximum XOR After Operations 

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/maximum-xor-after-operations/)
- **Date**: 2026-07-08
- **Language**: java


**The Problem**

Given an array of integers `nums`, find the maximum XOR value among all subsets of `nums`. The XOR operation is done between two integers in the following manner: a ^ b. Here's the problem statement from LeetCode: <https://leetcode.com/problems/maximum-xor-after-operations/>

**Initial Thoughts**

At first, I thought about using a greedy approach, iterating through each element in the array and updating the maximum XOR with the current element. However, this approach has a time complexity of O(n^2), which is too slow for large inputs.

**The Core Trick**

The core trick is to use a combination of binary search and bit manipulation to solve this problem efficiently. We can iterate through each bit of the maximum number in the array and use binary search to find the first number that has this bit set to 1, and update the maximum XOR accordingly. This way, we can avoid checking each subset of the array and reduce the time complexity to O(n log n).

**Complexity**

The time complexity of the solution is O(n log n), which is the result of the binary search and iterating through each bit of the maximum number. The space complexity is also O(n) due to storing the numbers in the array.

**Key Takeaway**

This problem taught me that binary search is a powerful tool for solving problems related to bit manipulation and XOR operations. It also reinforced my understanding of the time and space complexities of common algorithms.