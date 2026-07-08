# Binary Tree Inorder Traversal

- **Difficulty**: Easy
- **Source**: [Backlog](https://leetcode.com/problems/binary-tree-inorder-traversal/)
- **Date**: 2026-06-27
- **Language**: cpp


**The Problem**

Given a binary tree, write a function to perform inorder traversal and return a vector of integers representing the tree's nodes' values.

**Initial Thoughts**

Initially, I thought of using recursion to traverse the tree and store the visited nodes in a vector. But then I realized that recursion might lead to stack overflow for large trees. So, I decided to use an iterative approach with a stack.

**The Core Trick**

The core trick in this problem is using a stack to keep track of the nodes to be visited next. We start with the left subtree and push all nodes onto the stack. Then, we pop the top node from the stack and print its value. We also push the right subtree onto the stack. This way, we ensure that all nodes are visited in the correct order.

**Complexity**

The time complexity is O(n), where n is the number of nodes in the tree, because we visit each node once in the worst case. The space complexity is also O(n) because we use a stack that grows with the height of the tree.

**Key Takeaway**

This problem taught me the importance of using the right data structures to solve coding problems. In this case, using a stack for iterative traversal of a binary tree was a clever solution.