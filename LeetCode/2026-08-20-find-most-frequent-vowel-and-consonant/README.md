# Find Most Frequent Vowel and Consonant

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/find-most-frequent-vowel-and-consonant/)
- **Date**: 2026-08-20
- **Language**: java


**The Problem**

Given a string `s`, return the maximum sum of the frequency counts of its vowels and consonants. A consonant is any character that is not a vowel.

**Initial Thoughts**

This problem seems straightforward. I thought about using a map to count occurrences of vowels and consonants. But what if there are multiple vowels with the same frequency? I decided to keep track of the maximum frequency for both vowels and consonants separately.

**The Core Trick**

The key to this problem is understanding how to efficiently count the occurrences of vowels and consonants. Using a map for vowels can lead to a time complexity of O(n \* log n) due to the `containsKey()` method's complexity. Instead, I used an array to count the occurrences of vowels and consonants. This way, I can iterate through the string once and get a time complexity of O(n).

**Complexity**

Time complexity: O(n)
Space complexity: O(1)

**Key Takeaway**

This problem taught me the importance of using an array to count occurrences instead of a map when dealing with a large input.