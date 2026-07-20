# Reverse String

- **Difficulty**: Easy
- **Source**: [Alt-Leetcode](https://leetcode.com/problems/reverse-string/)
- **Date**: 2026-07-20
- **Language**: java


**The Problem**

Given a string, reverse it without using any built-in reverse methods. The problem I found on LeetCode asks for a solution in various programming languages. I decided to tackle it in Java.

**Initial Thoughts**

Initially, I felt that reversing a string might be simple, but I had to consider edge cases like empty strings or strings with only one character. I also realized that I needed to be careful about the string's memory usage, as reversing a large string could be an O(n^2) operation.

**The Core Trick**

The core trick was to use two pointers, one from the beginning and one from the end, and swap their values until they meet. This approach ensures that the characters are always moved towards each other, and the complexity is linear.

**Complexity**

The time complexity of this solution is O(n), where n is the number of characters in the string. The space complexity is O(1), as it only uses a constant amount of extra memory.

**Key Takeaway**

This problem taught me the importance of considering edge cases and efficient memory usage when working with strings. Reversing a string is a great exercise to practice adding a level of complexity to simple algorithms.