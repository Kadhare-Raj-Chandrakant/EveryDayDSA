# Restore Finishing Order

- **Difficulty**: Easy
- **Source**: [Alt-Leetcode](https://leetcode.com/problems/restore-finishing-order/)
- **Date**: 2026-07-21
- **Language**: java


**The Problem**

Given an array `order` where `order[i]` represents a task, and another array `friends`, where `friends[i]` represents a pair of friends. 

Find out a possible finishing order for tasks, where a task is always finished only after all its dependent tasks have been finished. If there is no such finishing order, return an empty array.

**Initial Thoughts**

At first, I thought about a topological sorting approach, but I realized that some tasks might have negative cycles, which would make the algorithm fail. So, I decided to use a different approach.

**The Core Trick**

I noticed that each task is either a task or a friend of a task. I decided to create a set of all the friends of each task and then sort the tasks based on their friend sets. If a task has no friends, it means it's a root task, and we add it to the result array.

**Complexity**

Time complexity: O(n + m), where n is the length of order and m is the length of friends. This is because we create a set of friends for each task in a single pass, and then we iterate through the tasks.

Space complexity: O(m), where m is the length of friends. This is because we store the set of friends for each task in a separate data structure.

**Key Takeaway**

This problem taught me that when dealing with directed graphs, it's essential to consider negative cycles. By using a set of friends instead of a directed graph, I was able to solve the problem efficiently without worrying about negative cycles.