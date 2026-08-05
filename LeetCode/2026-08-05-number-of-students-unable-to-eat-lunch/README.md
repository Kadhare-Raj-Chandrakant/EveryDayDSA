# Number of Students Unable to Eat Lunch

- **Difficulty**: Easy
- **Source**: [Alt-Leetcode](https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/)
- **Date**: 2026-08-05
- **Language**: java


**The Problem**

Given an array of integers `students` representing the number of sandwiches the students can eat in a day, and another array `sandwiches` representing the number of sandwiches the students actually eat, the problem asks to count the number of students unable to eat lunch. I.e., the number of students who have fewer sandwiches than required to eat lunch.

**Initial Thoughts**

At first, I thought about using a brute-force approach where we iterate through both arrays and check if the number of students who have fewer sandwiches than required to eat lunch is greater than zero. However, this approach has a time complexity of O(n^2), which is not efficient for large arrays. So, I decided to look for a more efficient solution.

**The Core Trick**

The key to solving this problem is to keep track of the number of students who have 0 sandwiches and the number of students who have non-zero sandwiches. Then, we can iterate through the `sandwiches` array to update these counters whenever a student eats or doesn't eat lunch. If at any point in time, the number of students who have 0 sandwiches is zero, it means that all students have eaten enough sandwiches to eat lunch. Consequently, if the number of students who have non-zero sandwiches is zero, it means that no student has eaten enough sandwiches to eat lunch. This approach has a time complexity of O(n) and O(1) space complexity.

**Complexity**

The time complexity of this solution is O(n), where n is the number of students. This is because we iterate through the `students` and `sandwiches` arrays only once. The space complexity is O(1), as we only use a constant amount of space to store the counters.

**Key Takeaway**

In this problem, the key takeaway is thinking about the constraints of the problem. In this case, the number of sandwiches a student has is not limited, so we cannot use a simple brute-force approach. Instead, we need to think about how the number of students who have 0 sandwiches and the number of students who have non-zero sandwiches changes as the students eat or don't eat lunch. This approach helps us to quickly identify the students who are unable to eat lunch.