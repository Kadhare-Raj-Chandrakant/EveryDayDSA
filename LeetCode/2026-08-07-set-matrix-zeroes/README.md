# Set Matrix Zeroes

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/set-matrix-zeroes/)
- **Date**: 2026-08-07
- **Language**: java


Today, I tackled the "Set Matrix Zeroes" problem, which was a medium difficulty question from LeetCode. The problem asks us to set all zeros in a matrix to zero while minimizing the number of operations. 

Initially, I thought about using two pointers to iterate over the matrix and marking all zeros as visited. However, this approach had a time complexity of O(m*n), which was not optimal. I then realized that the problem can be solved efficiently by using two rows and two columns as flags to determine which elements need to be zeroed out. This solution has a time complexity of O(m*n) and a space complexity of O(1).

The core trick in this problem is to use the first row and column as flags to keep track of the elements that need to be zeroed out. This allows us to zero out the elements in a row-wise and column-wise manner, further reducing the time and space complexity.

In terms of complexity, this solution has a time complexity of O(m*n) as we need to iterate through each element in the matrix only once. The space complexity is O(1) as we are only using constant additional space to store the flags.

For next time, I'd remember to think about the time and space complexity of an algorithm before implementing it, and to consider using flags or other auxiliary data structures to optimize the solution.