# Minimum Number of Moves to Seat Everyone

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/)
- **Date**: 2026-07-13
- **Language**: java


**The Problem**
Given an array of seats and an array of students, find the minimum number of moves required for each student to find their assigned seat. A move for a student is defined as moving them to the closest available seat.

**Initial Thoughts**
This problem seems trivial, just sort the students by distance from their assigned seats and move each student to their assigned seat. However, I quickly realized that this approach would have a time complexity of O(n^2) due to the nested loops required to compare students' distances.

**The Core Trick**
I decided to use a heap to efficiently compare students' distances. I created a min-heap to store the students' distances and popped off the student with the smallest distance when a seat became available. This way, I could guarantee that the student with the smallest distance was always moved first, resulting in the optimal solution in O(n log n) time complexity.

**Complexity**
The time complexity of this solution is O(n log n), as we are sorting the students and maintaining a min-heap to efficiently compare their distances. The space complexity is O(n) to store the students' distances in the heap.

**Key Takeaway**
This problem demonstrates that even with seemingly simple algorithms, there can be subtle complexities that make them slower or more space-efficient. By using a min-heap to compare students' distances, I was able to optimize this solution to handle a large number of students efficiently.