# Find Consistently Improving Employees

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/find-consistently-improving-employees/)
- **Date**: 2026-08-25
- **Language**: java


Today, I tackled a medium-difficulty problem on LeetCode, "Find Consistently Improving Employees." Given a table of employees and their performance reviews, the task was to find employees who consistently improved in their performance over the course of the reviews.

Initial Thoughts: I thought about first sorting the reviews by date and employee ID, then iterating through the reviews and calculating the improvement score for each employee. I also considered using a priority queue to efficiently find the best-performing employees in terms of improvement score.

The Core Trick: I decided to use a map to store the performance reviews for each employee, then sort the reviews for each employee by date. This allowed me to efficiently access the reviews for a given employee without having to iterate through the entire list of reviews. I also used the fact that the performance reviews are ordered by date to ensure that the most recent reviews were always considered when calculating improvement scores.

Complexity: The time complexity of this solution is O(n log n) due to sorting the reviews for each employee, where n is the number of employees. The space complexity is O(n) for storing the result.

Key Takeaway: It's important to break down complex problems into smaller, manageable parts. In this case, I approached the problem by first sorting the reviews for each employee, then calculating the improvement score for each employee based on the most recent three reviews. This approach allowed me to efficiently find employees who consistently improved their performance. Additionally, I made sure to consider the order of the performance reviews when calculating the improvement score, as the most recent reviews were always considered.

In conclusion, I found this problem to be a good exercise in breaking down a complex problem into smaller, manageable parts, and in efficiently calculating improvement scores based on the most recent reviews.