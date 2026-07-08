# Binary Tree Inorder Traversal

- **Difficulty**: Easy
- **Source**: [Backlog](https://leetcode.com/problems/binary-tree-inorder-traversal/)
- **Date**: 2026-06-25
- **Language**: cpp


**The Problem**

Given a binary tree, write a function to perform inorder traversal and return a vector of integers representing the tree's nodes' values in ascending order.

**Initial Thoughts**

I've seen this problem before, and I know that to perform inorder traversal, we need to visit the left subtree first, then the root, and finally the right subtree. This means that we need to use recursion to visit the tree's nodes.

**The Core Trick**

The core trick here is to keep track of the nodes' values as we traverse the tree, so we can return them in the correct order. We can use a stack to keep track of the nodes' addresses, and when we encounter a left node, we push its address onto the stack. When we encounter the root, we add its value to the result vector and then pop all the addresses from the stack.

**Complexity**

The time complexity of this solution is O(n), where n is the number of nodes in the tree, since we need to visit each node once. The space complexity is also O(n), as we use a stack to keep track of the nodes' addresses.

**Key Takeaway**

This problem teaches me the importance of thinking about how to traverse a tree data structure and how to keep track of the nodes' values during traversal.