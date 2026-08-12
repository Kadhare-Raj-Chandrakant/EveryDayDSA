# Unique Paths

- **Difficulty**: Medium
- **Source**: [Alt-Leetcode](https://leetcode.com/problems/unique-paths/)
- **Date**: 2026-08-12
- **Language**: java


The problem I solved today was "Unique Paths" on LeetCode, a medium-difficulty question about traversing a grid to reach the bottom-right corner. The most straightforward approach would be to brute-force the grid, but that's not efficient for larger inputs. Instead, we can use dynamic programming to store and reuse the results of subproblems, resulting in a time complexity of O(m * n).

Initially, I thought of filling up the grid by checking each cell and adding the result of the previous cells. However, this method would be inefficient as it would recalculate the same result for each cell multiple times. To avoid this, I initialized the first row and column with 1, representing a single path to the cell. Then, I filled up the table from the second row to the last row and column to column, storing the sum of the results from the previous rows and columns.

After implementing this solution, I had to analyze the time and space complexity. I realized that the time complexity is indeed O(m * n), which is the maximum number of steps required to traverse the grid. For space complexity, I used a 2D array of size m * n, which is also the maximum amount of memory required to represent the entire grid.

In conclusion, this problem was a great example of how dynamic programming can be used to solve a seemingly complex problem more efficiently. I'll remember to always consider space and time efficiency when tackling grid-based problems in the future.