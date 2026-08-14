# Maximum Average Pass Ratio

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/maximum-average-pass-ratio/)
- **Date**: 2026-08-14
- **Language**: java


Today, I tackled a medium-difficulty problem on LeetCode, "Maximum Average Pass Ratio." Given a two-dimensional array `classes` representing the number of students in each class and an integer `extraStudents`, the task is to find the maximum average pass ratio among all classes where some students can be transferred between classes.

Initial Thoughts: I immediately thought of using a priority queue to store the classes based on their pass ratios. Then, I'd repeatedly add more students to the class with the highest pass ratio until I've used up all the extra students. After that, I'd divide the total number of students by the number of classes to get the overall average pass ratio.

The Core Trick: The key insight is to use a priority queue to efficiently merge the classes with extra students into the existing classes. This allows us to maintain the pass ratios as we add students to the highest-pass-ratio class.

Complexity: The time complexity is O(n log n + m log n), where n is the number of classes and m is the number of extra students. This is because we first sort the classes based on their pass ratios and then merge the extra students into the highest-pass-ratio class using a priority queue in a separate loop. The space complexity is O(n) as we use a priority queue to store the classes.

Key Takeaway: The problem demonstrates the importance of using efficient data structures to solve time and space-critical problems. In this case, using a priority queue to merge the classes with extra students allows us to maintain the pass ratios accurately and efficiently.