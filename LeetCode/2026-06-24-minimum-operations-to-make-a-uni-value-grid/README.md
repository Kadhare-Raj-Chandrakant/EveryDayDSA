# Minimum Operations to Make a Uni-Value Grid

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/)
- **Date**: 2026-06-24
- **Language**: cpp


**The Problem**

Given a grid of integers, we need to find the minimum number of operations to make each row and column have the same value. Each operation changes one value in the grid by adding or subtracting 'x' to it. If it's impossible to achieve this for the given 'x', return -1.

**Initial Thoughts**

At first, I thought of sorting the grid and checking if the median value is divisible by 'x'. However, this approach has a time complexity of O(m * n * log(m * n)) due to sorting. I also considered using a binary search on the median value, but that would be too slow.

**The Core Trick**

I realized that for each number in the grid, it will have a unique remainder when divided by 'x'. So, if we iterate through the numbers and count how many numbers have a remainder of 0, 1, ..., x-1, we can find the median value and calculate the number of operations required to make each row and column have the same value.

**Complexity**

Time complexity: O(m * n * log(m * n)) due to sorting.
Space complexity: O(m * n) for storing the grid and vector 'nums'.

**Key Takeaway**

This problem can be solved efficiently by counting the number of elements with different remainders when divided by 'x', and then using that information to find the median value and calculate the number of operations required. This approach avoids sorting the entire grid and has a better time complexity than the initial idea.