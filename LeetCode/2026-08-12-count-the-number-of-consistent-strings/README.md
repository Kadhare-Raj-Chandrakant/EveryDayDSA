# Count the Number of Consistent Strings

- **Difficulty**: Easy
- **Source**: [Alt-Leetcode](https://leetcode.com/problems/count-the-number-of-consistent-strings/)
- **Date**: 2026-08-12
- **Language**: java


**The Problem**

Given an array of words and an allowed string, count the number of consistent strings in the array. A string is considered consistent if every character in the string is either in the allowed string or any character that is not in the allowed string.

**Initial Thoughts**

At first, I thought about using a hash map to count the occurrences of each character in the allowed string and then checking if each character in each word is in the allowed string or not. However, this approach has a time complexity of O(n*m), where n is the number of words and m is the maximum length of a word, which is not efficient enough for large inputs.

**The Core Trick**

To optimize the time complexity, I realized that I don't need to check if each character in the word is in the allowed string or not. Instead, I can iterate through the allowed string and check if each character in the word is not in the allowed string. This way, I can avoid iterating through the allowed string for each word, reducing the time complexity to O(n*m).

**Complexity**

This solution has a time complexity of O(n*m) and a space complexity of O(1) since the space used does not grow with the size of the input.

**Key Takeaway**

This problem taught me that it's important to think about the core trick in a problem statement before diving into the brute-force approach. In this case, I was able to optimize the time complexity by avoiding unnecessary iterations.