# Snakes and Ladders

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/snakes-and-ladders/)
- **Date**: 2026-07-17
- **Language**: java


**The Problem**

The problem asks to find the shortest path from start to finish in Snakes and Ladders board. The board consists of an n x n grid of tiles, where some tiles have a ladder that adds a certain number of steps to the player's position, and others have a snake that subtracts a certain number of steps.

**Initial Thoughts**

At first, I thought of using Breadth-First Search (BFS) to solve the problem. However, I realized that BFS doesn't guarantee the shortest path. To find the shortest path, I need to know the labels of all tiles in the board. I also need to consider the possibility of ladders and snakes. So, I decided to use Depth-First Search (DFS) combined with a queue to explore all possible paths.

**The Core Trick**

To keep track of the labels of all tiles, I used a boolean 2D array `visited` to keep track of whether a tile has been visited or not. I also used a queue to store the tiles I need to explore next.

**Complexity**

The time complexity of my solution is O(n^2) because I need to explore all tiles in the grid. The space complexity is also O(n^2) because I store the labels of all tiles in the visited array.

**Key Takeaway**

To solve this problem, I need to combine DFS with a queue to explore all possible paths. I also need to keep track of the labels of all tiles in the grid.