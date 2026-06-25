# Reverse Linked List

- **Difficulty**: Easy
- **Source**: [Backlog](https://leetcode.com/problems/reverse-linked-list/)
- **Date**: 2026-06-25
- **Language**: cpp


**The Problem**

Given a linked list, reverse its nodes.

**Initial Thoughts**

Hmm, this sounds simple. I'll just keep track of the previous node and move the current one to the new head. But how do I keep track of the start of the list?

**The Core Trick**

Since we're reversing the entire list, the head will become the tail and vice versa. So, I can initialize `prev` to `nullptr` to keep track of the start.

**Complexity**

The time complexity is O(n), where n is the number of nodes in the list. This is because we need to iterate through every node once. The space complexity is O(1), as we're only using a constant amount of space.

**Key Takeaway**

When reversing a linked list, keep track of the start by initializing `prev` to `nullptr`. The head will become the tail and vice versa, allowing us to move the current node to the new head without needing to worry about the start.