# Construct Binary Tree from Preorder and Postorder Traversal

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/)
- **Date**: 2026-07-06
- **Language**: java


**The Problem**

Given preorder and postorder traversals of a binary tree, construct the binary tree. For example, given [3,9,20,15,7] as preorder and [9,15,7,20,3] as postorder, the corresponding binary tree would be:

```
   3
  / \
 9  20
    /  \
   15   7
```

**Initial Thoughts**

The first thing that comes to mind is to iterate through the postorder traversal and find the root, then recursively construct the left and right subtrees. However, this approach will not work because it won't handle duplicate elements in the postorder traversal. So I need a better algorithm.

**The Core Trick**

The key to solving this problem is to realize that the preorder traversal and postorder traversal contain enough information to construct the binary tree. The preorder traversal provides the root value and the direction of the left and right subtrees. The postorder traversal provides the direction of the left and right subtrees and the order of the subtrees. By matching these values, we can construct the binary tree.

**Complexity**

Time complexity: O(n)
Space complexity: O(n) for recursion stack.

**Key Takeaway**

When dealing with tree traversals, remember that each element provides enough information to construct the tree. In this case, the preorder traversal provides the root value and the direction of the left and right subtrees, while the postorder traversal provides the direction of the left and right subtrees and the order of the subtrees. By matching these values, we can construct the binary tree.