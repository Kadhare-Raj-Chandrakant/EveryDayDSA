# Max Dot Product of Two Subsequences

- **Difficulty**: Hard
- **Source**: [Leetcode](https://leetcode.com/problems/max-dot-product-of-two-subsequences/)
- **Date**: 2026-07-17
- **Language**: java


The problem I solved today was the "Max Dot Product of Two Subsequences" from LeetCode. This problem is quite challenging because we need to find the maximum dot product of two subsequences in a given array, while considering constraints on the lengths of the subsequences.

My first reaction was to try all possible combinations of subsequences and calculate their dot products. However, this approach would be very slow due to the exponential time complexity. I then thought about using dynamic programming to solve this problem more efficiently. I created a 2D DP array to store the maximum dot product ending at each index of the two arrays.

The core trick in this problem is that we can reuse the results from previous rows and columns. For example, if we have already calculated the maximum dot product of two subsequences ending at indices (i-1, j-1) and (i-1, j), we can simply add the current element of the first array and check if it's greater than the current maximum. This way, we don't need to recalculate the maximum for those combinations.

The time complexity of my solution is O(m*n) and the space complexity is O(m*n) as well. The code I wrote is compact and readable, which I believe is an important aspect of a good solution.

In conclusion, this problem was a great learning experience for me. It taught me the importance of using dynamic programming to solve more complex problems, and also reinforced my understanding of constraints and constraints on constraints.