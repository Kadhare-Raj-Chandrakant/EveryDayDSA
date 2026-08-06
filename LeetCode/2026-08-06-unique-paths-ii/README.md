# Unique Paths II

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/unique-paths-ii/)
- **Date**: 2026-08-06
- **Language**: java


The problem I solved today was "Unique Paths II," a Medium difficulty question from LeetCode. The question involves navigating a grid with obstacles, where each cell can be visited only if it's not an obstacle. Here's the problem statement:

"A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below). The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below). How many possible unique paths are there?"

Initial Thoughts:

At first, I thought of using dynamic programming to solve this problem. I tried to create a 2D array to store the possible paths for each cell, but I realized that this approach wouldn't work because it would take exponential time complexity. I also tried using recursion, but I couldn't implement it correctly.

The Core Trick:

After some thinking, I realized that the problem is similar to "Unique Paths." The main difference is that in "Unique Paths," the robot can't enter any cell that has an obstacle, whereas in this problem, the robot can move through cells with obstacles as long as it's not in the current cell. To solve this problem, I used the same dynamic programming approach as in "Unique Paths," but I modified the base cases and the calculation of each cell based on its neighbors.

Complexity:

The time complexity of this solution is O(m * n) because we visit each cell exactly once. The space complexity is also O(m * n) because we store the possible paths for each cell in a 2D array.

Key Takeaway:

In this problem, we learned that when dealing with similar problems, it's crucial to understand the key differences before implementing a solution. This approach allowed me to design an efficient algorithm, which is a valuable skill in software engineering.