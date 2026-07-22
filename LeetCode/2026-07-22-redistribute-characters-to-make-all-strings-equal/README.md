# Redistribute Characters to Make All Strings Equal

- **Difficulty**: Easy
- **Source**: [Alt-Leetcode](https://leetcode.com/problems/redistribute-characters-to-make-all-strings-equal/)
- **Date**: 2026-07-22
- **Language**: java


**The Problem**

Given an array of strings `words`, determine if it's possible to redistribute all the characters in all strings to make all strings equal. If so, return `true`, otherwise return `false`.

**Initial Thoughts**

My first instinct was to iterate through each word in the array and count the frequency of each character using a hash map. Then, I checked if the count of each character is divisible by the number of words and if they all equal zero. If so, I returned `true`, otherwise I returned `false`.

**The Core Trick**

The key to solving this problem is to ensure that the total number of characters in all words is a multiple of the number of words. This can be achieved by calculating the total number of characters in all words and then checking if the remainder is zero when divided by the number of words. If the remainder is not zero, then it's not possible to redistribute the characters to make all strings equal.

**Complexity**

The time complexity of this solution is O(n*m), where n is the number of words and m is the maximum length of a word. The space complexity is O(26) = O(1) since we only need to store the frequency of 26 lowercase English letters.

**Key Takeaway**

This problem taught me the importance of considering the total number of characters in all words when redistributing the characters to make all strings equal. By checking if the remainder is zero when dividing the total number of characters by the number of words, I was able to efficiently solve this problem.