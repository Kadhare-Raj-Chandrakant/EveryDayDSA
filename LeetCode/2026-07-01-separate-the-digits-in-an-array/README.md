# Separate the Digits in an Array

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/separate-the-digits-in-an-array/)
- **Date**: 2026-07-01
- **Language**: cpp


**The Problem**

Given an array of integers, separate the digits in each integer and return them in a separate vector. For example, `separateDigits([123, 321, 45])` should return `[1, 2, 3, 3, 2, 1, 4, 5]`.

**Initial Thoughts**

At first, I thought about using a for loop to iterate over each integer in the array and converting it to a string. Then, I would use another for loop to extract each digit and add it to a new vector. This approach seemed straightforward but inefficient as it has a time complexity of O(n^2) where n is the total number of digits in the array, since each integer needs to be converted to a string and then iterated over again.

**The Core Trick**

After some thinking, I realized that I can use a simple for loop to iterate over each character in the string representation of an integer. This approach has a time complexity of O(n) where n is the total number of digits in the array, since it only iterates over each character once.

**Complexity**

The time complexity analysis of this solution is as follows:
- Converting each integer to a string has a time complexity of O(m), where m is the number of digits in the integer.
- Iterating over each character in the string representation of an integer has a time complexity of O(m).
- Combining these two steps results in a total time complexity of O(n*m), where n is the total number of integers in the array.

**Key Takeaway**

This problem serves as a reminder that sometimes, simple and efficient solutions can be found by breaking down the problem into smaller, manageable parts and analyzing each part's complexity. Next time I encounter a similar problem, I will pay more attention to analyzing the time and space complexity of each step in the solution.