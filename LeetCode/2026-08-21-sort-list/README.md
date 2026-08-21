# Sort List

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/sort-list/)
- **Date**: 2026-08-21
- **Language**: java


Problem: Sort a linked list from 1 to n.

Initial Thoughts: This problem seemed straightforward. I recall trying to sort linked lists in the past using brute-force methods, but they always seemed inefficient. Maybe there's a more efficient way to sort a linked list? What if I use a recursive approach to split the list into two halves, sort them, and then merge them? That could be a good start.

The Core Trick: The key to this problem is to use a recursive approach to split the list into two halves, sort them, and then merge them. This approach allows us to leverage the divide-and-conquer strategy, which is often used in algorithms.

Complexity: The time complexity of this solution is O(n log n) because we're using a merge sort algorithm. The space complexity is also O(log n) because we're using a recursive approach and storing the two sorted halves on the call stack.

Key Takeaway: This problem taught me the importance of using efficient algorithms and data structures when solving coding challenges. By leveraging the divide-and-conquer strategy, we can solve complex problems in a more manageable way.