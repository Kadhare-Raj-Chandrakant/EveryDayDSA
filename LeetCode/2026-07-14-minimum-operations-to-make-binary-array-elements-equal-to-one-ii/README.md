# Minimum Operations to Make Binary Array Elements Equal to One II

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-ii/)
- **Date**: 2026-07-14
- **Language**: java


**The Problem**

Given an array of non-negative integers, find the minimum number of operations to make every element equal to one. An operation is incrementing every element by one.

**Initial Thoughts**

At first, I thought about using a greedy approach, i.e., incrementing elements one by one until all elements become equal to one. However, this approach has a time complexity of O(n \* log(n)), which is too slow for large inputs.

**The Core Trick**

To solve this problem efficiently, I realized that we can use a single pass over the array to count the number of zeros and ones, and then adjust the count of zeros by incrementing them by one. This way, we can ensure that every element has the same value (one) without worrying about the order in which they become one.

**Complexity**

The time complexity of this solution is O(n), as we only need to iterate through the array once. The space complexity is O(1), as we only use a constant amount of space to store the count of zeros and ones.

**Key Takeaway**

When solving a problem that involves counting elements of a specific value, it's worth considering the number of operations required to convert the array to a single value. In this case, incrementing every element by one is the most straightforward approach, but it may not be the most efficient one if there are many elements with a specific value.