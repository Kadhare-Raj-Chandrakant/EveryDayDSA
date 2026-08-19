# Maximum Sum BST in Binary Tree

- **Difficulty**: Hard
- **Source**: [Leetcode](https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/)
- **Date**: 2026-08-19
- **Language**: java


The problem I solved today was finding the maximum sum BST in a binary tree. This problem was on LeetCode, and it's tagged as a hard difficulty. My solution code is in Java and has a time and space complexity of O(n) and O(h), respectively.

Initially, I had some false starts with a brute-force approach, trying to find the maximum sum of all possible BSTs. However, I quickly realized that this was inefficient due to the exponential growth of possible subtrees. Instead, I used a depth-first search (DFS) approach to traverse the tree and find the maximum sum BST.

The core trick in this problem is to check if the current node is a valid BST by verifying that its value is greater than the root's left child's value and less than the root's right child's value. If the current node is a valid BST, we can recursively calculate the sums of its left and right subtrees and add them to the current node's value. If the current node is not a valid BST, we simply return the sum of the two subtrees as 0.

Overall, this was a good exercise in applying DFS to a binary tree problem. The key takeaway is that it's important to identify the core trick in a problem and apply it efficiently. The time complexity of this solution is O(n), where n is the number of nodes in the tree, so it's not too bad for a hard problem.