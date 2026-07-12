# Lowest Common Ancestor of Deepest Leaves

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/)
- **Date**: 2026-07-12
- **Language**: java


The problem I solved today was "Lowest Common Ancestor of Deepest Leaves" on LeetCode. The problem asks to find the lowest common ancestor of the deepest leaves in a binary tree. Here's the initial thought process and my solution.

**Initial Thoughts:**
It's a medium problem that asks to find the lowest common ancestor of nodes in a binary tree. I thought of using a depth-first search (DFS) to traverse the tree and update the max depth as I go. I also considered a recursive solution, but it might lead to an infinite loop if the tree is deep.

**The Core Trick:**
To avoid the infinite loop, I decided to use an iterative solution with a stack. I push nodes onto the stack when I encounter left and right children. When I reach a leaf node, I pop the stack until I find a non-null node, which is the deepest ancestor.

**Complexity:**
The time complexity is O(n), where n is the number of nodes in the tree, as we traverse the entire tree. The space complexity is O(h), where h is the height of the tree, as we push and pop elements from the stack.

**Key Takeaway:**
My takeaway is to be careful when using a recursive solution, especially in a tree traversal problem, and to think about the base case and edge cases. I also learned the importance of using an iterative solution with a stack to avoid infinite loops.