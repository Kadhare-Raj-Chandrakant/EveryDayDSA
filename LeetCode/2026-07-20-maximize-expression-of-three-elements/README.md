# Maximize Expression of Three Elements

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/maximize-expression-of-three-elements/)
- **Date**: 2026-07-20
- **Language**: java


**The Problem**

Given an array of three integers representing the values of three variables, design an algorithm to find the maximum possible expression you can create by combining these three variables. The expression should contain only addition, subtraction, and parentheses. For example, given the array [1, 2, 3], a valid expression could be (3 + 2) - 1, which equals 7.

**Initial Thoughts**

Initially, I thought I could try to use a brute-force approach by trying every possible combination of the three variables and checking if the resulting expression is greater than or equal to zero. However, this would be very time-consuming and inefficient for larger arrays.

**The Core Trick**

After some thought, I realized that this problem is essentially asking us to sort the three variables and then calculate the maximum possible expression that can be formed by subtracting the smallest variable from the largest. This approach has two advantages: first, it reduces the problem to a simple arithmetic operation, making it much easier to analyze and optimize. Second, by using sorting, we can ensure that the maximum expression will always be positive, even if some variables are negative.

**Complexity**

The time complexity of this solution is O(n log n) due to the sorting operation. The space complexity is O(1), as we only use a constant amount of extra space to store the sorted array.

**Key Takeaway**

When faced with a problem involving arithmetic operations and variables, always try to simplify the problem by reducing it to a more basic form or using a clever trick. In this case, sorting the variables allowed me to focus on a simple arithmetic operation and guaranteed that the resulting expression would always be positive.