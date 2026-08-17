# Find Positive Integer Solution for a Given Equation

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/find-positive-integer-solution-for-a-given-equation/)
- **Date**: 2026-08-17
- **Language**: java


**The Problem**

Given a custom function `f` that takes two integers `x` and `y`, and returns the value of `f(x, y)`, find all positive integer solutions `[x, y]` to the equation `f(x, y) == z`.

**Initial Thoughts**

I initially thought of brute-forcing all possible combinations of `x` and `y`, but that would be too slow and inefficient for larger inputs. I also considered using a backtracking approach, but I was worried about handling duplicate solutions.

**The Core Trick**

The key to solving this problem is to realize that `f(x, y)` is always an integer, and that the equation can be rewritten as `x * y - z` being an integer. This means that `x` and `y` can be considered as the roots of a quadratic equation, and the solutions can be found using a quadratic formula.

**Complexity**

The time complexity is `O(n^2)` because for each pair of `x` and `y`, we need to check if `f(x, y) == z`, and we do this for all possible values of `x` and `y` from 1 to 1000. The space complexity is also `O(n)` because we store all the solutions found in a list.

**Key Takeaway**

For a problem that seems difficult at first, it's important to break it down into smaller components and look for patterns or underlying principles. This problem was solved by recognizing that the equation could be rewritten as a quadratic equation, which allowed us to use a more efficient algorithm.