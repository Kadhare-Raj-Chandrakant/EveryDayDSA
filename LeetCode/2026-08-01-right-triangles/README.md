# Right Triangles

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/right-triangles/)
- **Date**: 2026-08-01
- **Language**: java


The problem I solved today was from LeetCode: "Right Triangles." The goal was to count the number of right triangles in a grid, where each cell is either 0 or 1. A right triangle has at least one side of length 1.

Initial Thoughts
At first, I thought of iterating through the grid and checking for each cell if it's a right triangle by checking if its neighbors are also 1s. This approach would be slow since we'd have to check each cell's neighbors, and it wouldn't be efficient.

The Core Trick
Then, I realized that for each cell with a value of 1, we can count the number of right triangles it can form by subtracting one from the number of 1s above and to the left of it. This is because we're essentially counting the number of right triangles that contain that cell as a vertex.

Complexity
The time complexity of this solution is O(m * n), where m and n are the dimensions of the grid. The space complexity is also O(m + n), which includes the extra space needed to store the counts of 1s in each row and column.

Key Takeaway
This problem taught me about counting triangles in a grid. It's a good exercise in thinking creatively about how to count various shapes in a grid.