# Minimum Deletions to Make Character Frequencies Unique

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/)
- **Date**: 2026-08-18
- **Language**: java


**The Problem**

Given a string `s`, the task is to find the minimum number of deletions required to make the character frequencies in the string unique. A string's character frequency is the number of times a character appears in the string.

**Initial Thoughts**

At first, I thought of brute-forcing all possible deletions and checking if the character frequencies are unique after each deletion. However, this would be too slow for large strings. I also tried to find a pattern in the character frequencies, but I didn't find anything that could help me solve the problem efficiently.

**The Core Trick**

After some thought, I realized that I could use a sliding window approach. For each character in the string, I would increment its frequency in an auxiliary array. Then, I would iterate through the auxiliary array, decrementing the frequency of each character and adding one to the deletion count if the frequency is greater than zero. This would ensure that all characters with a frequency greater than zero are deleted before processing the next character.

**Complexity**

The time complexity of this solution is O(n log n) due to the sorting step in the auxiliary array. The space complexity is O(n) for storing the frequencies.

**Key Takeaway**

This problem taught me the value of using auxiliary arrays in algorithms. They can help simplify complex problems by breaking them down into smaller, manageable steps. Additionally, I should be more patient and think creatively when approaching problems, even if they seem difficult at first.