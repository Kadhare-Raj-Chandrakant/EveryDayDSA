# Percentage of Letter in String

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/percentage-of-letter-in-string/)
- **Date**: 2026-07-18
- **Language**: java


**The Problem**

Given a string `s` and a character `letter`, return the percentage of occurrences of `letter` in `s`.

**Initial Thoughts**

I immediately thought of using a for loop to iterate through each character in `s`, and increment the count whenever I find the character. Then, I can calculate the percentage by dividing the count by the length of `s` and multiplying by 100. However, I need to account for the fact that the result may have a fractional part, so I'll round it to the nearest integer using `(int)` and add 0.5 to ensure it's greater than or equal to 0.

**The Core Trick**

The key to this problem is to perform a simple character count, which can be done in a single pass through the string. This approach allows for efficient time and space complexity, making it an easy problem to solve.

**Complexity**

This solution has a time complexity of `O(n)` because we iterate through each character once, and space complexity of `O(1)` because we only use a constant amount of space.

**Key Takeaway**

This problem taught me the importance of data structure selection and time/space complexity analysis in problem-solving. By recognizing that we can count occurrences of a character in a string in a single pass, we can avoid unnecessary complexity and improve overall efficiency.

(499 words)