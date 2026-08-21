# Number of Digit One

- **Difficulty**: Hard
- **Source**: [Leetcode](https://leetcode.com/problems/number-of-digit-one/)
- **Date**: 2026-08-21
- **Language**: java


**The Problem**

Given an integer `n`, return the number of digits that are one (`1`). A digit that is one (`1`) can be at any position.

**Initial Thoughts**

Initially, I thought about using a brute-force approach where for each digit from right to left, I check if it's a `1`. This would have a time complexity of `O(n^2)` and space complexity of `O(1)`. However, this approach seems inefficient for larger `n`.

**The Core Trick**

The key to solving this problem is to understand that we can count the number of digits that are one (`1`) by subtracting the count of digits that are not one (`0`, `2`, ..., `9`) from the total number of digits. To do this, we can use the property that for any number `n`, the number of digits that are one (`1`) is equal to the number of digits that are less than or equal to `n / 10` plus the number of digits that are `n % 10 = 1`.

**Complexity**

The time complexity of the solution is `O(log n)`, which is sublinear, as we are only considering each digit once. The space complexity remains `O(1)` as we are not storing any intermediate results.

**Key Takeaway**

This problem teaches us how to use properties of numbers to simplify counting problems. By understanding the structure of numbers, we can often come up with more efficient solutions. This approach can be applied to other counting problems.