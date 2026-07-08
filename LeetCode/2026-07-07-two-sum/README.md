# Two Sum

- **Difficulty**: Easy
- **Source**: [Backlog](https://leetcode.com/problems/two-sum/)
- **Date**: 2026-07-07
- **Language**: java


**The Problem**

Given an array of integers `nums` and an integer `target`, return the indices of the two numbers such that they add up to `target`. You may assume that each input would have exactly one solution, and you may not use the same element twice.

**Initial Thoughts**

I started by thinking about how I could solve this problem using a brute-force approach. I tried to iterate through the array and compare each number with every other number to see if their sum equals `target`. However, this approach has a time complexity of O(n^2), which is not efficient for large arrays.

**The Core Trick**

To optimize the time complexity, I decided to use a hash map to store the numbers that have a complement that equals `target`. Then, I iterated through the array again and checked if each number has a complement in the hash map. If it does, I returned their indices as the solution. This approach has a time complexity of O(n) and a space complexity of O(n), making it more efficient.

**Complexity**

The time complexity of the solution is O(n), which is optimal because we only need to iterate through the array once using a hash map. The space complexity is O(n) as well because we store all the elements in the hash map.

**Key Takeaway**

This problem is a great example of how we can use data structures like hash maps to optimize our algorithms and improve their time complexity. By thinking about how we can store the information we need in a more efficient way, we can make our code more readable, maintainable, and faster.