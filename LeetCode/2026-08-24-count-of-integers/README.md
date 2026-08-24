# Count of Integers

- **Difficulty**: Hard
- **Source**: [Leetcode](https://leetcode.com/problems/count-of-integers/)
- **Date**: 2026-08-24
- **Language**: java


**The Problem**

Given two strings `num1` and `num2`, where each string represents a decimal integer, and a range of integers `[min\_sum, max\_sum]`, count the number of integers `n` such that `num1 + num2 < n <= num1 + num2 + max\_sum` and `num1 + num2 + min\_sum <= n <= num1 + num2 + max\_sum`. 

**Initial Thoughts**

This problem seems straightforward enough, but I struggled with the edge cases. I also had trouble with the complexity of the solution. 

**The Core Trick**

To solve this problem, I need to create a dynamic programming solution. I'll use a 3-D dp array to keep track of the count for each possible sum, digit, and whether or not the digit is less than or equal to the current number. This will help me avoid double-counting and ensure that my solution is correct.

**Complexity**

The time complexity of my solution is O(n \* (max\_sum - min\_sum + 1) \* 10^4) due to the nested loops and the 10^4 limit for `n`. The space complexity is also O(n \* max\_sum \* 2) due to the dp array size. 

**Key Takeaway**

This problem taught me to always consider edge cases and to be cautious when creating dynamic programming solutions. It's important to break down the problem into smaller, manageable steps and to ensure that your solution is correct before moving on to optimization or further implementation.