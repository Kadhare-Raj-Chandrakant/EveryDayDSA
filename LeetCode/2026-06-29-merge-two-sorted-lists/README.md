# Merge Two Sorted Lists

- **Difficulty**: Easy
- **Source**: [Backlog](https://leetcode.com/problems/merge-two-sorted-lists/)
- **Date**: 2026-06-29
- **Language**: java


The problem I solved today was merging two sorted linked lists. Although it sounds simple, I found the core trick to be quite interesting. Here's what I wrote:

**The Problem:**
Given two sorted linked lists, merge them into one sorted list. The input lists are very large, so we cannot compare each node's value directly.

**Initial Thoughts:**
At first, I tried to create a new list and iterate through both lists, adding nodes with lower values to the new list. However, this method has a time complexity of O(n + m), which is not efficient enough for large lists. I also tried using a while loop, but that didn't work either.

**The Core Trick:**
To solve this problem efficiently, I need to keep track of the smaller list's end and move both lists forward until one list ends. This way, I can compare the values directly and avoid iterating through both lists at the same time.

**Complexity:**
The time complexity is O(n + m) because we need to go through each node in both lists at most once. The space complexity is O(1) because we only use a constant amount of space.

**Key Takeaway:**
Merge sort can be used to solve this problem by recursively splitting the list into two halves and merging the results. However, this method has a time complexity of O(n log n), which is much higher than this solution. For large lists, this solution is much more efficient.