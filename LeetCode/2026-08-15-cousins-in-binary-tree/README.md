# Cousins in Binary Tree

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/cousins-in-binary-tree/)
- **Date**: 2026-08-15
- **Language**: java


**The Problem**

Given a binary tree, return whether two given nodes are cousins or not. 
In a binary tree, cousins are two nodes that have the same depth, but have different parents.

**Initial Thoughts**

At first, I thought of using two stacks to traverse the tree from left to right and check if the nodes at the same depth are cousins. However, this approach would have a time complexity of O(n) as it traverses all the nodes in the tree. 

**The Core Trick**

To solve this problem efficiently, I decided to use a queue to traverse the tree level by level. This way, I can ensure that the nodes at the same depth are processed together. 

**Complexity**

Using a queue, the time complexity of this solution is O(n), where n is the number of nodes in the tree. The space complexity is O(h), where h is the height of the tree. This is because we are using a queue that can store up to h nodes at each level of the tree.

**Key Takeaway**

This problem taught me the importance of using efficient data structures to solve time-critical problems. In this case, using a queue improved the overall performance of the solution.

(499 words)