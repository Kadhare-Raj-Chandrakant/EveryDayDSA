# Average of Levels in Binary Tree

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/average-of-levels-in-binary-tree/)
- **Date**: 2026-08-01
- **Language**: java


**The Problem**

Given a binary tree, find the average value of all nodes at each level and return them as a list.

**Initial Thoughts**

At first, I thought about using a DFS approach to traverse the tree and calculate the sum of values at each level. However, I quickly realized that this would have a time complexity of O(n^2), which is too slow for large trees. I also considered using BFS, but I was worried about handling cases where a level might have fewer nodes compared to other levels.

**The Core Trick**

The key idea was to use a queue to keep track of nodes at each level and calculate the average value of those nodes in a single pass. This allowed me to avoid the issue of handling differing lengths between levels and ensured a time complexity of O(n).

**Complexity**

Time complexity: O(n), where n is the number of nodes in the tree. This is because we are visiting each node exactly once and not depending on the depth of the tree.

Space complexity: O(n), where n is the number of nodes in the tree. This is because we are storing nodes in a queue, which can grow up to n nodes long if we have a balanced tree.

**Key Takeaway**

This problem taught me the importance of using efficient data structures and algorithms in solving tree-related problems. It also reinforced my understanding of queue usage in graph traversal problems.