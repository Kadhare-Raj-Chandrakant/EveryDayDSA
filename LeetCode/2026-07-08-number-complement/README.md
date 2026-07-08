# Number Complement

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/number-complement/)
- **Date**: 2026-07-08
- **Language**: java


**The Problem**

Given an integer `num`, return its complement integer. The complement of a number `n` is the unique number which has the same number of 1's as `n` in its binary representation.

**Initial Thoughts**

I initially tried to convert the number into binary representation and then count the number of ones, but this approach was too slow and required more space.

**The Core Trick**

The problem statement was straightforward. I needed to find a way to convert `num` into its binary representation and then toggle all the bits to get the complement.

**Complexity**

The time complexity of this solution is O(log n) due to the binary representation of `num`. The space complexity is O(1) as no additional space is used.

**Key Takeaway**

This problem is a great example of how to efficiently find the complement of a number using the binary representation. Always think about the binary representation of numbers when dealing with binary related problems.