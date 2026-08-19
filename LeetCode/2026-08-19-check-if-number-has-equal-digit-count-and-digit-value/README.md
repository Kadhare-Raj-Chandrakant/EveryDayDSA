# Check if Number Has Equal Digit Count and Digit Value

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/check-if-number-has-equal-digit-count-and-digit-value/)
- **Date**: 2026-08-19
- **Language**: java


**The Problem**

Given a non-negative integer, determine if it has equal digit count and digit value. For example, given the integer 123123, return true.

**Initial Thoughts**

At first, I thought this problem could be solved using a brute-force approach where I iterate through each digit and compare its count with its value. However, I realized that this approach would have a time complexity of O(n^2) and space complexity of O(n), which would make it inefficient for large inputs.

**The Core Trick**

I decided to use a hash map to count the occurrences of each digit. Then, I iterated through the digits of the input string and compared their count with their value. If at any point there's a mismatch, I return false. If all digits match, I return true. This approach has a time complexity of O(n) and space complexity of O(1), making it efficient for large inputs.

**Complexity**

The time complexity of this solution is O(n), where n is the length of the input string. This is because each digit is traversed exactly once and the time taken to traverse each digit is constant. The space complexity of this solution is O(1), as we only need a constant amount of space to store the hash map.

**Key Takeaway**

This problem demonstrates the importance of considering time and space complexity when solving coding problems. Using a hash map to count the occurrences of each digit allowed me to efficiently solve this problem in linear time, making it a valuable skill to have when coding.