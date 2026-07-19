# Count Substrings Starting and Ending with Given Character

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/count-substrings-starting-and-ending-with-given-character/)
- **Date**: 2026-07-19
- **Language**: java


**The Problem**
Given a string `s` and a character `c`, count the number of substrings of `s` that start and end with `c`. For example, in the string `"abcabc"` and character `'a'`, there are four such substrings: `"aaa"`, `"aba"`, `"bac"`, and `"bca"`.

**Initial Thoughts**
I initially thought of using a sliding window approach to count the substrings of `s` that start and end with `c`, but it seemed too simple and time-consuming. I also considered using a prefix sum or suffix sum array to count the number of occurrences of `c` in `s`, but I found those solutions to be more complex than necessary.

**The Core Trick**
After some reflection, I realized that the problem can be solved using a simple formula for the number of substrings of length `n` that start and end with a given character `c`. The formula is: `(n * (n + 1)) / 2`, where `n` is the number of occurrences of `c` in `s`. In the example given above, the substrings are `"aaa"`, `"aba"`, `"bac"`, and `"bca"`, which have lengths `3`, `2`, `2`, and `2`, respectively. The total number of such substrings is `(3 * 4) / 2 + (2 * 3) / 2 + (2 * 2) / 2 + (2 * 1) / 2 = 6 + 3 + 4 + 2 = 15`.

**Complexity**
The time complexity of this solution is `O(n)`, where `n` is the length of `s`. This is because we iterate through each character of `s` in a single pass. The space complexity is also `O(1)` because we only use a constant amount of space to store the result.

**Key Takeaway**
This problem is a good example of how to apply simple mathematical formulas to solve problems efficiently. By thinking critically and creatively, we can often find the most elegant and efficient solutions to coding challenges.