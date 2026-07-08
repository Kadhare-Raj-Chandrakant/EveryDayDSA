# Number of Subarrays That Match a Pattern I

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/number-of-subarrays-that-match-a-pattern-i/)
- **Date**: 2026-07-08
- **Language**: java


The problem I solved today was "Number of Subarrays That Match a Pattern I" from LeetCode, a medium difficulty question. It asks us to count the number of subarrays in an array that satisfy a given pattern. The pattern consists of three elements: -1, 0, and 1. A subarray matches the pattern if all the elements with value 1 are in increasing order, while elements with value 0 are in non-decreasing order. If there is an element with value -1, it can appear in either increasing or decreasing order.

My initial thoughts were to use two pointers, one for the current subarray and another for the pattern. I'd compare the values at those indices and update the pointers accordingly. However, this approach had a high time complexity of O(n^2), where n is the length of the array. To improve this, I realized that I could use a sliding window approach and count the number of matching subarrays as I move the window.

The core trick was to maintain a boolean array of the same size as the pattern to keep track of the last valid index for each value. This helped me in efficiently checking for valid patterns without iterating over the entire array for each subarray.

Time and space complexity: O(n*m), where n is the length of nums and m is the length of pattern. Space complexity is O(1).

Key takeaway: When dealing with subarray problems, think about using sliding window techniques and maintaining a boolean array to keep track of the last valid index for each value. This can significantly improve the time complexity.