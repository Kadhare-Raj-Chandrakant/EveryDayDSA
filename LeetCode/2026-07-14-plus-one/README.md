# Plus One

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/plus-one/)
- **Date**: 2026-07-14
- **Language**: java


**The Problem**

The problem asks to increment a one-dimensional array of integers representing a non-negative integer by one. This can be done by iterating through the array from the end, checking each digit, and incrementing it by one if it's less than 9; otherwise, setting it to 0 and moving to the next digit. If all digits are 9, the function should return a new array with an extra digit set to 1 at the beginning.

**Initial Thoughts**

My first thought was to iterate through the array from the end, checking each digit, and incrementing it by one if it's less than 9. I thought this would be an easy brute-force solution. However, I realized that this approach would have time and space complexity of O(n), where n is the number of digits in the input array. This was not an efficient solution for large input arrays.

**The Core Trick**

The core trick here is to iterate through the array from the end, checking each digit, and incrementing it by one if it's less than 9. If all digits are 9, the function should return a new array with an extra digit set to 1 at the beginning.

**Complexity**

The time complexity of this solution is O(n) because we iterate through the array only once, and the space complexity is also O(n) because we are creating a new array with the same length as the input array.

**Key Takeaway**

This problem taught me the importance of considering time and space complexity when solving problems. It's always helpful to analyze the problem first and then come up with a solution that meets the constraints.