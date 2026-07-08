# Binary Tree Inorder Traversal

- **Difficulty**: Easy
- **Source**: [Backlog](https://leetcode.com/problems/binary-tree-inorder-traversal/)
- **Date**: 2026-06-29
- **Language**: java


**The Problem**

Given a binary tree, return its inorder traversal.

**Initial Thoughts**

I had never encountered this problem before, but I knew that inorder traversal means visiting each node in the order of their postorder traversal. I thought it might involve recursion and using the left and right subtrees to traverse through them.

**The Core Trick**

The core trick is to use a helper function that recursively calls itself with the left and right subtrees until it reaches a null node, at which point it adds the current node's value to the result list and continues with the next subtree.

**Complexity**

The time complexity is O(n), where n is the number of nodes in the tree. This is because we are visiting each node exactly once, and the depth of the tree is O(h), where h is the height of the tree. The space complexity is also O(n), as we are storing the result list, which is potentially as large as the tree itself.

**Key Takeaway**

This problem is a great example of how recursion can be used to traverse through a binary tree, even if you're not familiar with inorder traversal directly. I'll remember to use a helper function to break down the problem into smaller, more manageable parts.