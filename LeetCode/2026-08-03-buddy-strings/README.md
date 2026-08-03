# Buddy Strings

- **Difficulty**: Easy
- **Source**: [Alt-Leetcode](https://leetcode.com/problems/buddy-strings/)
- **Date**: 2026-08-03
- **Language**: java


Buddy Strings is a relatively straightforward problem, but it took me some time to figure out the best way to solve it. The problem asks you to determine if two strings are buddy strings, which means they are either equal or a single character difference apart. Here's how I approached it:

**The Problem:** Given two strings `s` and `goal`, determine if they are buddy strings. A buddy string is either equal or has a single character difference in exactly one position.

**Initial Thoughts:** At first, I thought about brute-forcing the problem by comparing each character of `s` with the corresponding character of `goal`. However, this approach would be inefficient because it would have a time complexity of O(n^2), where n is the length of the strings. To improve the time complexity, I decided to focus on finding the position of the different characters in both strings.

**The Core Trick:** To find the positions of the different characters, I used two arrays `diffIndices` and `charCount`. The `diffIndices` array keeps track of the indices where the characters differ, while the `charCount` array keeps track of whether a character has appeared twice in `s`. This approach allowed me to quickly identify the distinct characters and their positions.

**Complexity:** The time complexity of this solution is O(n), where n is the length of the strings, because we only iterate through the strings once. The space complexity is also O(1), excluding the space required for the input strings.

**Key Takeaway:** This problem serves as a great reminder to think about the time and space complexity of your solutions. Choosing the right data structures and algorithms can significantly impact the performance of your code. In this case, using arrays to keep track of different characters and their positions allowed me to efficiently find the buddy strings.

This problem was an easy one; however, it helped me practice thinking about different solution approaches and how they impact the time and space complexity of my code.