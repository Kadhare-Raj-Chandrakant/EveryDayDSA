# Number of Ways to Reach a Position After Exactly k Steps

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/number-of-ways-to-reach-a-position-after-exactly-k-steps/)
- **Date**: 2026-08-18
- **Language**: java


**The Problem**

Given the starting position and ending position of a person on a chessboard, find the number of ways to reach the ending position after exactly `k` steps. The steps should be either forward, backward, or sideways.

**Initial Thoughts**

* At first, I tried using a brute-force approach, where I iterated through all possible combinations of steps for `k` steps. However, this approach has a time complexity of O(n!), which is too slow for large values of `k`.
* Next, I thought about using dynamic programming to optimize the time complexity. I decided to use a memoization approach, where I stored the results of subproblems in a memo table and reused them when they were needed.

**The Core Trick**

The key to solving this problem is understanding that the number of ways to reach a position after exactly `k` steps is the same as the number of ways to reach a position after exactly `(k - diff)` steps, where `diff` is the difference between the starting and ending positions. This is because the steps taken before reaching the ending position are irrelevant.

**Complexity**

Time complexity: O(1), as the number of ways depends only on the difference between the starting and ending positions and the value of `k`.
Space complexity: O(1), as the memo table has a fixed size.

**Key Takeaway**

When solving a problem that involves a combination of steps, it's important to think about the underlying pattern and how it can be generalized to other cases. In this problem, I was able to find a simpler solution by understanding the underlying pattern and its connection to a simpler problem.