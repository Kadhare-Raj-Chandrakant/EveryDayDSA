# Maximum Level Sum of a Binary Tree

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/)
- **Date**: 2026-07-08
- **Language**: java


**The Problem**

Given a binary tree, find the maximum level sum of all nodes at that level. 

**Initial Thoughts**

At first, I thought about using a breadth-first search to traverse the tree and calculate the sum of all nodes at each level, but I realized that it wouldn't be efficient enough. 

**The Core Trick**

I decided to use a queue to keep track of the nodes at each level and their sums. This way, I can efficiently calculate the max level sum without having to traverse the tree again. 

**Complexity**

The time complexity of this solution is O(n), where n is the number of nodes in the tree. This is because we only need to traverse the tree once using a queue. The space complexity is also O(n), since we use a queue to store all the nodes at each level.

**Key Takeaway**

This problem taught me the importance of using data structures like queues to efficiently traverse a tree and calculate the max level sum.