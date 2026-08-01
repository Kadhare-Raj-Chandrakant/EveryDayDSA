# Swap Sex of Employees

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/swap-sex-of-employees/)
- **Date**: 2026-08-01
- **Language**: java


**The Problem**

Given an object `Salary`, swap the sex of its string `sex` attribute if it's 'm' to 'f' and vice versa.

**Initial Thoughts**

I thought about using a simple if-else statement to swap the sex. But I wanted to see if there's a more efficient way to do it.

**The Core Trick**

I realized that using the `equals()` method can simplify the code. It checks if two strings are the same, so I can directly compare them and swap them without any additional logic.

**Complexity**

This problem has a time complexity of O(1) because it doesn't involve any loops or recursive calls. The space complexity is also O(1) as we're not creating or destroying any additional data structures.

**Key Takeaway**

When dealing with simple boolean conditions, using the `equals()` method can save time and make the code more readable.