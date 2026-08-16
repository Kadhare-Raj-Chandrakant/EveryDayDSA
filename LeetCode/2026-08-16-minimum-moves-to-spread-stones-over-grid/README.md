# Minimum Moves to Spread Stones Over Grid

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/minimum-moves-to-spread-stones-over-grid/)
- **Date**: 2026-08-16
- **Language**: java


**The Problem**

Given a 2D grid, where each cell can have a value of either 1, 0, or -1. Find the minimum number of moves required to change all the cells containing 0 to 1, while keeping the rest unchanged. A valid move consists of changing a 0 to 1 and increasing the number of 1s by 1.

**Initial Thoughts**

At first, I thought about solving this using BFS or DFS, but those algorithms have a high time complexity. I needed a more efficient approach. After some thinking, I remembered that the number of 0s and 1s are equal in a grid. So, if I convert all the 0s to 1s, I'll increment the count of 1s by the number of 0s. This way, I'll have to make the minimum number of moves possible.

**The Core Trick**

In this problem, we need to convert all the cells from 0 to 1. Since the number of 0s and 1s are equal in a grid, we can simply change all the 0s to 1s. This will increase the count of 1s exactly by the number of 0s, thus making the minimum number of moves possible.

**Complexity**

The time complexity is O(1), as the input size is constant. The space complexity is also O(1), as the space used does not grow with the input size.

**Key Takeaway**

Always check if the problem can be solved by converting all the elements of one type to another. This approach can be quite useful in similar problems.