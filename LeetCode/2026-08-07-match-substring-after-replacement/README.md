# Match Substring After Replacement

- **Difficulty**: Hard
- **Source**: [Leetcode](https://leetcode.com/problems/match-substring-after-replacement/)
- **Date**: 2026-08-07
- **Language**: java


**The Problem**

Given a string `s` and a substring `sub`, and a list of mappings representing how to replace a character with another character. The goal is to find if there's a substring of `s` that matches `sub` after all the replacements. 

**Initial Thoughts**

At first, I thought of iterating through all possible substrings of `s` and comparing them to `sub`. However, this would be a time complexity of O(n^2m), which is quite slow. I then remembered the concept of using a map to store the mappings and comparing each substring to `sub` character by character. But how to efficiently compare the characters?

**The Core Trick**

The key idea is to use a `map` to store the mappings for quick lookup and compare each character of the substring to `sub` character by character. If a character cannot be replaced according to the mappings, we can immediately break the loop and return `false`.

**Complexity**

Time complexity: O(n*m*k), where n is the length of `s`, m is the length of `sub`, and k is the number of mappings. Space complexity: O(k). Each mapping will be stored in the `map`, which has a maximum size of 128 characters.

**Key Takeaway**

This problem demonstrates the importance of using data structures wisely and thinking ahead to optimize solutions.