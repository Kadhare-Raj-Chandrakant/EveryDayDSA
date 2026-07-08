# Find Three Consecutive Integers That Sum to a Given Number

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/find-three-consecutive-integers-that-sum-to-a-given-number/)
- **Date**: 2026-07-08
- **Language**: java


**The Problem**

Given a number `num`, return three consecutive integers that sum to `num` if it exists, otherwise return an empty array. For example, for `num = 9`, the output would be `[2, 3, 4]`.

**Initial Thoughts**

Initially, I thought about trying all possible combinations of three integers and checking if they sum up to `num`. However, this approach would be too slow, considering that the number of possible combinations is `(n + 2) / 3`, where `n` is the number. 

**The Core Trick**

The key idea is to notice that since the numbers are consecutive, we can use the formula `(n - 1) + (n) + (n + 1) = 3n`. If `num` is divisible by 3, we can easily find three consecutive integers that sum to it. 

**Complexity**

The time complexity of this approach is `O(1)`, since we don't perform any operations on the array elements. The space complexity is also `O(1)`, since we only allocate a constant amount of space to store the result.

**Key Takeaway**

This problem teaches us to think carefully about constraints and edge cases, as well as to be aware of mathematical formulas and properties. By applying these insights, we can create efficient and concise solutions.