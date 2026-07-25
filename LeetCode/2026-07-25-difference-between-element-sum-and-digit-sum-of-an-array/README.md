# Difference Between Element Sum and Digit Sum of an Array

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/difference-between-element-sum-and-digit-sum-of-an-array/)
- **Date**: 2026-07-25
- **Language**: java


**The Problem**

Given an array of integers, your task is to find the difference between the element sum and the digit sum of each element. The digit sum refers to the sum of the individual digits of an element. For example, the digit sum of 123 is (1 + 2 + 3) = 6.

**Initial Thoughts**

At first glance, this problem seems simple enough. I thought about using a loop to iterate over each element in the array, calculate its digit sum, and then subtract it from the element sum. However, I realized that this would have a time complexity of O(n^2), as I would need to perform a separate operation (digit sum calculation) for each element. I also thought about using a combination of the element sum and digit sum, but I couldn't think of a way to optimize this approach further.

**The Core Trick**

After some consideration, I realized that I could use a simple loop to iterate over each digit of each element, add it to the digit sum, and then remove it from the element sum when it's no longer needed. This way, I would only perform the digit sum calculation once for each element, reducing the time complexity of the problem to O(n * log(m)), where n is the number of elements in nums and m is the maximum value in nums.

**Complexity**

The time complexity of the above solution is O(n * log(m)), as we need to iterate over each element in the array once, and for each element, we need to perform a digit sum calculation, which involves iterating over each digit of the element. The space complexity is O(1), as we only use a constant amount of additional memory to store the digit sum.

**Key Takeaway**

This problem serves as a good reminder not to jump to conclusions about a problem's solution too quickly. There are often multiple approaches to solve a problem, and understanding the constraints and trade-offs involved can lead to more efficient solutions.