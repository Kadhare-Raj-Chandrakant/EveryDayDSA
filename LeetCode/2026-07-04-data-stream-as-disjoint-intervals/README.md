# Data Stream as Disjoint Intervals

- **Difficulty**: Hard
- **Source**: [Leetcode](https://leetcode.com/problems/data-stream-as-disjoint-intervals/)
- **Date**: 2026-07-04
- **Language**: cpp


Problem: Data Stream as Disjoint Intervals

Difficulty: Hard

Source: https://leetcode.com/problems/data-stream-as-disjoint-intervals/

Initial Thoughts: This problem seems like a classic disjoint set union problem, but what's the key trick here? How can I efficiently add numbers and get intervals?

The Core Trick: Instead of maintaining disjoint sets for each number, I can maintain disjoint sets for groups of consecutive numbers. This way, I can quickly determine if two numbers belong to the same group by checking if their corresponding disjoint set roots are the same. To add a number, I need to find its root and union it with the root of the group it belongs to, if it doesn't already belong to any group.

Complexity: Time complexity: O(log n) for addNum, O(n) for getIntervals. Space complexity: O(n).

Key Takeaway: When dealing with disjoint sets, it's crucial to consider the problem's specific constraints and design efficient data structures and algorithms accordingly. In this case, grouping consecutive numbers and using the disjoint set union property significantly improves the efficiency of the solution.