# Number of Integers With Popcount-Depth Equal to K I

- **Difficulty**: Hard
- **Source**: [Leetcode](https://leetcode.com/problems/number-of-integers-with-popcount-depth-equal-to-k-i/)
- **Date**: 2026-07-31
- **Language**: java


Problem: Number of Integers With Popcount-Depth Equal to K I

Difficulty: Hard
Source: https://leetcode.com/problems/number-of-integers-with-popcount-depth-equal-to-k-i/

I was given a problem that required counting the number of integers with a specific popcount-depth. The problem statement was quite complex, but the core trick was to use dynamic programming to keep track of the number of integers with a certain popcount-depth for each bit position.

Initial Thoughts:

At first, I thought about using a brute-force approach, where I would iterate through all possible integers and count the ones with the desired popcount-depth. However, this approach would be slow for large values of k. I then tried using a bitwise operation to count the number of bits set to 1 in a given integer. This idea was inspired by a similar problem I had solved before, where I had used a similar technique to calculate the number of bits set to 1 in an integer. However, this approach would still be inefficient for large values of k.

The Core Trick:

In the end, I decided to use dynamic programming to solve the problem. I created a 2D array dp, where dp[i][j][k] represents the number of integers with a popcount-depth equal to k for the first i bits and tight[k] == 1. I iterated through all possible integers and updated the dp array accordingly.

Complexity:

My solution has a time complexity of O(log n * k * 64) and a space complexity of O(log n * k). This is because I need to keep track of the dp array, which has a size of O(log n * k), and each iteration through the integer space amounts to O(log n * 64), which is dominated by the log n factor.

Key Takeaway:

Dynamic programming can be a powerful technique for solving problems that involve counting or iterating over all possible combinations of a given size. By keeping track of the previous state and using it to calculate the next state, we can reduce the time complexity of the problem significantly.

In this particular problem, I used a 2D array to keep track of the dp array, which allowed me to quickly iterate through all possible combinations of a given size. This approach was efficient enough to solve the problem efficiently for large values of k.