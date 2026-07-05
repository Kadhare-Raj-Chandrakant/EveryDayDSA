# Delete Operation for Two Strings

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/delete-operation-for-two-strings/)
- **Date**: 2026-07-05
- **Language**: cpp


**The Problem**

Given two strings `word1` and `word2`, delete all characters from `word1` that don't match with those in `word2`. Return the minimum number of characters needed to be deleted.

**Initial Thoughts**

I brute-forced the problem by checking if each character in `word1` matches with the corresponding character in `word2`. If not, I increment a counter and move on to the next pair of characters. This approach has a time complexity of O(m*n), where m and n are the lengths of `word1` and `word2`, respectively.

**The Core Trick**

I realized that we can make use of dynamic programming to efficiently solve this problem. I created a two-dimensional array `dp` to store the minimum number of deletions required to transform `word1` into `word2`. The base cases are when either `word1` or `word2` is empty, or when the characters at the top left and bottom right corners match. The algorithm iterates over the array from top to bottom and from left to right, updating the values accordingly.

**Complexity**

The time complexity of this solution is O(m * n) because we need to iterate over both strings to build the `dp` array. The space complexity is also O(m * n) because we are storing the entire `dp` array in memory.

**Key Takeaway**

This problem is a good example of how dynamic programming can be used to solve problems involving transformations between sequences. It's important to break down the problem into smaller sub-problems and find a recursive or iterative solution to build the overall solution.