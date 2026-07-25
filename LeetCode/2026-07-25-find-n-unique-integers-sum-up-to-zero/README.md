# Find N Unique Integers Sum up to Zero

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/)
- **Date**: 2026-07-25
- **Language**: java


**The Problem**

Given an integer `n`, return a list of `n` distinct integers whose sum equals zero.

**Initial Thoughts**

First, I thought about brute-forcing all the possibilities, but that would be too slow for larger `n`. Then, I remembered that the sum of two integers is always zero, so I thought about using two pointers to move towards zero. However, I realized that the order of the numbers didn't matter. For example, `[-1, 1]` is the same as `[1, -1]`, so I decided to optimize my solution by using half of the numbers and filling the other half with their negatives.

**The Core Trick**

The core trick is to use a sliding window optimization approach, where we move two pointers towards zero, filling the list with the current numbers and their negatives. We stop when the sum of the first `n / 2` numbers equals zero, and if `n % 2 != 0`, we add the missing integer at the middle index.

**Complexity**

Time complexity: O(n) because we traverse the array only once.

Space complexity: O(n) because we store all the required numbers in the result array.

**Key Takeaway**

Always think about the edge cases and optimize your solutions to handle them efficiently. In this problem, we used the fact that the sum of two integers is always zero to optimize our approach.