# Binary Tree Inorder Traversal

- **Difficulty**: Easy
- **Source**: [Backlog](https://leetcode.com/problems/binary-tree-inorder-traversal/)
- **Date**: 2026-07-01
- **Language**: java


**The Problem**

Given a binary tree, write a function to perform inorder traversal and return a sorted list of its values.

**Initial Thoughts**

At first, I thought about using a recursive approach, where I call the helper function for the left subtree, add the current node's value to the result list, and then call the helper function for the right subtree. However, this approach has a time complexity of O(n^2), as it requires visiting each node twice. I knew I had to find a more efficient solution.

**The Core Trick**

I realized that inorder traversal is a property of the binary tree's structure, where nodes are visited in the order they appear in a sorted array of their subtree values. This insight led me to the following solution:

1. Initialize an empty list to store the result.
2. Iterate over the nodes in the tree.
3. If the current node is not null, call the inorderTraversalHelper function with the left subtree as the argument.
4. After calling the helper function, add the current node's value to the result list.
5. Call the helper function with the right subtree as the argument.

**Complexity**

The time complexity of this solution is O(n), as each node is visited only once. The space complexity is also O(n), since we use a recursive call stack to keep track of the nodes in the tree.

**Key Takeaway**

This problem taught me that sometimes, the key to solving a problem is understanding the underlying property or structure that makes it interesting. In this case, it was the inorder traversal property of binary trees. I'll remember this lesson and apply it to other data structures and algorithms in the future.