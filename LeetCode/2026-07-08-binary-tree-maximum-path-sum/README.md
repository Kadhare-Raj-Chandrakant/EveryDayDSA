# Binary Tree Maximum Path Sum

- **Difficulty**: Hard
- **Source**: [Leetcode](https://leetcode.com/problems/binary-tree-maximum-path-sum/)
- **Date**: 2026-07-08
- **Language**: java


**The Problem**

Given a binary tree, find the maximum path sum. The path may start and end at any node in the tree.

**Initial Thoughts**

At first, I thought of implementing a simple depth-first search (DFS) solution. However, I realized that this approach would not consider the possibility of negative numbers or a path that goes through a node with zero value.

**The Core Trick**

The key insight was to track the maximum sum of a path that ends at each node. This is done by maintaining a local variable called `maxGain` inside the `maxGain` helper function. The function calculates the maximum sum of a path that ends at the given node, including the node's value and the maximum sums of the left and right subtrees.

**Complexity**

The time complexity of this solution is O(N), where N is the number of nodes in the tree. This is because we visit each node once during the DFS traversal. The space complexity is O(H), where H is the height of the tree, due to the recursion stack.

**Key Takeaway**

This problem serves as a reminder that when dealing with tree traversal problems, it is crucial to consider all possible paths and their values. By tracking the maximum sum of a path at each node, we can efficiently find the maximum sum of any path in the tree.