# Maximize Sum Of Array After K Negations

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/)
- **Date**: 2026-06-29
- **Language**: cpp


**The Problem**

Given an array of integers `nums` and an integer `k`, write a function to maximize the sum of the array after `k` negations.

**Initial Thoughts**

At first, I thought about using a greedy approach to sort the array and then negate the first `k` elements. However, this would not guarantee the maximum sum. To find the maximum sum, I needed to consider the fact that negating an element changes its position in the sorted array.

**The Core Trick**

After negating the first `k` elements, I realized that I could use a binary search to find the index of the smallest element that, when negated, would maximize the sum. Then, I would negate that element and try again. This process would continue until the sum became negative, at which point I would stop.

**Complexity**

The time complexity of this solution is `O(n log n)` due to sorting the array. The space complexity is `O(1)`, excluding the input space.

**Key Takeaway**

When solving problems involving arrays and negations, always consider the effects of negating elements on the array's position in a sorted state, as this can lead to unexpected results and a more efficient solution.