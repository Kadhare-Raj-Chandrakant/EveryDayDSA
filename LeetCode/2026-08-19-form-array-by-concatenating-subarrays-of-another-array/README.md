# Form Array by Concatenating Subarrays of Another Array

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/form-array-by-concatenating-subarrays-of-another-array/)
- **Date**: 2026-08-19
- **Language**: java


**The Problem**

Given an array `groups` and an array `nums`, write a function that determines if it's possible to form `nums` by concatenating subarrays from `groups`. Two subarrays are considered equal if their elements are equal.

For example, given `groups` = `[[1, 2, 3], [4, 5], [6, 7, 8]]` and `nums` = `[1, 2, 3, 4, 5, 6, 7, 8]`, the function should return `true`.

**Initial Thoughts**

This problem seems like a sliding window solution, where I'll check if there's a subarray of `groups` that matches `nums` when slid over `nums`. I'll also need to keep track of the current index of `groups` to avoid using the same subarray twice.

**The Core Trick**

Since `groups` contains subarrays, I can treat them as equal if their elements are equal. So, I'll compare each subarray from `groups` to `nums`, and if there's a match, I can use a sliding window to move forward in `nums`. If I find a subarray from `groups` that doesn't match any subarray in `nums`, I'll return `false`.

**Complexity**

The time complexity is O(n * m * k), where n is the length of `groups`, m is the average length of `groups[i]`, and k is the length of `nums`. This is because I'm checking every subarray from `groups` and `nums`, and moving the sliding window accordingly. The space complexity is O(m) to store the current slide of `groups`.

**Key Takeaway**

This was a good practice in using arrays and comparing elements. I'll remember that I can treat subarrays as equal if their elements are equal when solving similar problems.