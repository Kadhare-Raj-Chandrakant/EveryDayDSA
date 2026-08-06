# Number of Enclaves

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/number-of-enclaves/)
- **Date**: 2026-08-06
- **Language**: java


Problem: Number of Enclaves

Difficulty: Medium

Source: Leetcode Problem 695

Initial Thoughts: This problem seems simple, but I'm having trouble understanding the solution. I've tried a brute-force approach, but it doesn't seem to work efficiently. I need to find a clever way to mark all land cells connected to the boundary as visited.

The Core Trick: I realize that I need to visit each cell in the grid and mark it as visited only if it's a land cell and connected to the boundary. This way, I can ensure that all land cells are marked as visited and count them separately from the boundary cells.

Complexity: The time complexity is O(m * n) for a two-dimensional grid, where m and n are the dimensions of the grid. The space complexity is also O(m * n) for the visited grid cells.

Key Takeaway: When dealing with problems related to connected components or islands in a grid, it's essential to consider the connections between cells and mark them as visited only if they're part of the connected components. This approach ensures that the solution is efficient and correct.