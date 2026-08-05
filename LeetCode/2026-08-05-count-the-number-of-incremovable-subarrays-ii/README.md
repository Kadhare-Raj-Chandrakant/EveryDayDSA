# Count the Number of Incremovable Subarrays II

- **Difficulty**: Hard
- **Source**: [Alt-Leetcode](https://leetcode.com/problems/count-the-number-of-incremovable-subarrays-ii/)
- **Date**: 2026-08-05
- **Language**: java


The problem I solved today was "Count the Number of Incremovable Subarrays II" from LeetCode. Given an array of integers, count the number of subarrays where the elements are in increasing order. Here's what I came up with:

**The Problem**
Given an array `nums`, count the number of subarrays where the elements are in increasing order. For example, given `[1, 2, 3]`, the output would be `3`, since there are three subarrays with increasing elements: `[1]`, `[2]`, and `[3]`.

**Initial Thoughts**
At first, I thought about using a sliding window approach and checking if the elements in each window are in increasing order. However, I realized that this approach would have a time complexity of O(n^2), which is too slow for large inputs. I also considered using a prefix sum array to quickly check if an element is greater than or equal to its previous element, but it would still have a time complexity of O(n).

**The Core Trick**
After some thinking, I realized that if I fix the starting index `i` and keep moving the ending index `j` until I either reach the end of the array or the elements in the current subarray are not in increasing order, I can count the number of such subarrays efficiently. To check if the elements in the current subarray are in increasing order, I can simply compare the last element with the previous one. If they are equal, I need to move `j` to the right until I find an element that is greater than or equal to the last element.

**Complexity**
The time complexity of this solution is O(n), since we are iterating through the array only once. The space complexity is O(1), as we are not using any auxiliary data structures.

**Key Takeaway**
This problem taught me that sometimes, even when the problem seems difficult, there might be a simpler and more efficient solution lurking underneath. By carefully analyzing the problem, I was able to identify the core trick that allowed me to solve the problem efficiently.