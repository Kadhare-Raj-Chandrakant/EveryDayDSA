# Reverse Linked List

- **Difficulty**: Easy
- **Source**: [Backlog](https://leetcode.com/problems/reverse-linked-list/)
- **Date**: 2026-07-07
- **Language**: java


**The Problem**

Given a linked list, reverse its nodes.

**Initial Thoughts**

When I first saw the problem, I thought about using a stack to reverse the linked list. However, after a few minutes of coding, I realized that I could do it simply by iterating through the list, swapping the next pointers of each node. It was a bit tricky to keep track of the previous node and the current node, but I eventually figured it out.

**The Core Trick**

The core trick was to keep track of the previous node and the current node while iterating through the list. By swapping the next pointers of each node, I could reverse the linked list without using an additional data structure like a stack.

**Complexity**

In terms of time complexity, this solution has a time complexity of O(n), where n is the number of nodes in the linked list. This is because we iterate through each node exactly once. In terms of space complexity, this solution has a space complexity of O(1), as we only use a constant amount of space.

**Key Takeaway**

This problem taught me that simple solutions often exist and are often more efficient than more complex ones. Keeping track of the nodes' next pointers allowed me to reverse the linked list without using any additional data structures.

In conclusion, this was a great problem to work on as it reinforced my understanding of linked lists and their reversal, while also emphasizing the importance of simplicity in problem-solving.