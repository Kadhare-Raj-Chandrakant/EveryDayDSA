# Design Exam Scores Tracker

- **Difficulty**: Medium
- **Source**: [Alt-Leetcode](https://leetcode.com/problems/design-exam-scores-tracker/)
- **Date**: 2026-08-22
- **Language**: java


Problem: Design Exam Scores Tracker

Difficulty: Medium

Source: https://leetcode.com/problems/design-exam-scores-tracker/

Initial Thoughts:
The problem seems straightforward at first glance, but I realized that maintaining the total score for a range of time intervals would require some optimization. I thought about using a data structure like a segment tree or a balanced binary search tree, but decided to go with a simple array to keep things simple and focused on the core trick.

The Core Trick:
The key insight here is that the total score for a range of time intervals can be calculated by summing up the scores in the given range and subtracting the scores in the range before it. This is because the scores are cumulative, meaning that the score in any interval is the sum of the scores in that interval and the interval before it.

Complexity:
The time complexity of the `record()` method is O(1), as it only involves updating a few elements in the array. The `totalScore()` method has a time complexity of O(log n) due to the binary search used to find the indices of the intervals. The space complexity of both methods is O(n), as we need to store all the recorded times and scores in the arrays.

Key Takeaway:
This problem taught me the importance of understanding the problem's requirements and constraints thoroughly before diving into a solution. It also reinforced the idea of focusing on the core trick, which can help simplify complex problems and make them more manageable.