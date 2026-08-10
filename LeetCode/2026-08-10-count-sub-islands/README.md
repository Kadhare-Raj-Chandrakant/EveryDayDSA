# Count Sub Islands

- **Difficulty**: Medium
- **Source**: [Alt-Leetcode](https://leetcode.com/problems/count-sub-islands/)
- **Date**: 2026-08-10
- **Language**: java


Problem: Count Sub Islands

Difficulty: Medium

Source: https://leetcode.com/problems/count-sub-islands/

My solution code:

This problem asks us to count the number of sub-islands in a given grid. Sub-islands are groups of connected 1s that are surrounded by 0s. The solution involves a recursive depth-first search (DFS) to traverse the grid and identify connected 1s.

Initial Thoughts:

This problem seemed straightforward at first, but I struggled to find an efficient algorithm. I tried a brute-force approach, checking every possible combination of connected 1s, but it was too slow. I also tried using BFS, but it had a higher space complexity.

The Core Trick:

The key to solving this problem is to use DFS to efficiently traverse the grid and identify connected 1s. By keeping track of the grid's state (0s and 1s) as we traverse, we can avoid unnecessary checks and improve efficiency.

Complexity:

The time complexity of this solution is O(m*n), where m and n are the dimensions of the grid. The space complexity is O(m*n) as well, due to the recursive calls and grid state tracking.

Key Takeaway:

This problem taught me the importance of efficient algorithms and data structures. Using DFS and memoization (tracking the grid state) allowed me to solve this problem more efficiently than a brute-force approach.

In conclusion, solving this problem required careful thought and consideration of time and space complexity. Using DFS and memoization allowed me to identify and traverse connected 1s more efficiently than other approaches.