# Maximum Product of Two Elements in an Array

- **Difficulty**: Easy
- **Source**: [Alt-Leetcode](https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/)
- **Date**: 2026-07-16
- **Language**: java


**The Problem**

Given an array of integers, the task is to find the maximum product of two elements from the array. The array may contain negative numbers. For example, for the array [2, -8, 11, -2, 4], the maximum product is 44 (from elements 11 and 4).

**Initial Thoughts**

I started by thinking about how to iterate through the array and find the two largest and two smallest numbers. I thought about using a priority queue to efficiently find the largest and smallest numbers. However, I realized that a priority queue would have a time complexity of O(log n) for each insertion, which would be too slow. I also thought about using two pointers to find the largest and smallest elements but couldn't come up with a solution.

**The Core Trick**

The key idea is to iterate through the array once and maintain two variables, max1 and max2, to keep track of the two largest numbers. When updating max1 or max2, also update the variable corresponding to the smaller number. This way, we ensure that the product of the current largest and smallest numbers is always calculated efficiently.

**Complexity**

The time complexity is O(n) because we iterate through the array only once. The space complexity is O(1) because we only use a constant amount of extra space.

**Key Takeaway**

Always think about the time and space complexity of your algorithms. In this case, we need to balance the efficiency of finding the largest and smallest elements with the space complexity. In this problem, we can achieve both using a simple approach with a time complexity of O(n) and a space complexity of O(1).