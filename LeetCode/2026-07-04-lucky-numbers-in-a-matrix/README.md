# Lucky Numbers in a Matrix

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/lucky-numbers-in-a-matrix/)
- **Date**: 2026-07-04
- **Language**: java


The problem I solved today was "Lucky Numbers in a Matrix," a relatively easy question on LeetCode. The objective was to find the numbers that appear in the same row and column as the minimum and maximum values, respectively.

Initially, I thought of brute-forcing the algorithm by iterating through each number in the matrix and checking if it was the minimum in its row and the maximum in its column. However, this approach would have a time complexity of O(m \* n \* (m + n)), which is too inefficient.

After some thought, I realized that the problem could be solved more efficiently by using two auxiliary arrays to store the minimum values of each row and the maximum values of each column. This would allow me to efficiently check if a number is both the minimum in its row and the maximum in its column, which is the definition of a lucky number.

With this insight, I wrote a solution that has a time complexity of O(m \* n) and a space complexity of O(m + n). The code I wrote is a straightforward implementation of this idea.

In conclusion, finding the lucky numbers in a matrix was an interesting problem that required thinking creatively to arrive at an efficient solution.