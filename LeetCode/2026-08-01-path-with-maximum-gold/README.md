# Path with Maximum Gold

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/path-with-maximum-gold/)
- **Date**: 2026-08-01
- **Language**: java


The problem I solved today was "Path with Maximum Gold" on LeetCode. It's a medium-difficulty question that requires finding the path with the most gold from the top-left corner to the bottom-right corner of a grid filled with gold and obstacles.

At first, I thought of using dynamic programming to keep track of the maximum gold value at each cell. However, the time complexity of this approach is exponential due to the maximum number of possible paths (4^(m*n)). So, I decided to use a brute-force approach with a backtracking function.

The key trick in this problem is to consider all possible directions and recursively call the function with the updated grid and updated path. This way, we can explore all possible paths and find the path with the maximum gold.

The complexity of this approach is still exponential, but it's more manageable than the dynamic programming solution. The space complexity is O(m*n) due to the recursion stack.

In conclusion, I used a brute-force approach with backtracking to solve the "Path with Maximum Gold" problem on LeetCode. The key takeaway for next time is to think creatively and not be afraid to try different approaches, even if they seem unlikely to work.