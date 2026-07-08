# Last Day Where You Can Still Cross

- **Difficulty**: Hard
- **Source**: [Leetcode](https://leetcode.com/problems/last-day-where-you-can-still-cross/)
- **Date**: 2026-07-08
- **Language**: java


Problem: Last Day Where You Can Still Cross
Difficulty: Hard

Initial Thoughts: This problem seems difficult because it involves a grid of cells and requires finding the latest day to cross the entire grid. My first instinct was to try a brute-force approach, checking each day step-by-step, but this would be too slow. I decided to use a more efficient algorithm, like DFS or BFS, but I wasn't sure which one would work best for this problem.

The Core Trick: After reading the problem description, I realized that the key to solving this problem is to treat each cell as a state, and the grid as a state space. If we can find a way to reach the bottom-right cell, then we know we can cross the entire grid on that day. This insight led me to use DFS to explore the grid and check if it's possible to reach the bottom-right cell.

Complexity: The time complexity of this solution is O(m * n * log(m * n)) where m is the number of rows and n is the number of columns. This is because we need to check every cell and its four neighboring cells, which takes O(m * n) time. The log-time factor comes from the DFS function, which uses recursion to explore the state space. The space complexity is O(m * n) because we need to store the grid state for each day and each DFS exploration.

Key Takeaway: This problem taught me the importance of understanding the problem space and recognizing the key idea that can lead to a simpler solution. It's also a good reminder to use efficient algorithms that take advantage of the problem's structure.