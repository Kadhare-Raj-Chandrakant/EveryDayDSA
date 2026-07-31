# Double a Number Represented as a Linked List

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/double-a-number-represented-as-a-linked-list/)
- **Date**: 2026-07-31
- **Language**: java


**The Problem**

Given a singly linked list representing an integer, double each node's value, and return the new head. The list should contain only non-negative integers.

**Initial Thoughts**

I thought about using a while loop to traverse the list and multiplying each node's value by two. Then, I realized that this method would have a time complexity of O(n^2) since I would need to traverse the list twice.

**The Core Trick**

I realized that instead of using a while loop, I could iterate through the list using two pointers - one to traverse the original list and another to traverse the modified list. I could keep track of the carry digit and add it to the new node's value in each iteration.

**Complexity**

The time complexity of this solution is O(n) since we are traversing the list only once. The space complexity is O(n) in the worst case when the input is a list of 9's.

**Key Takeaway**

It's important to think about the problem and analyze the solution's time and space complexity. In this case, using two pointers helped me avoid traversing the list twice and improved the efficiency of my solution.