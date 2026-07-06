# Two Sum

- **Difficulty**: Easy
- **Source**: [Backlog](https://leetcode.com/problems/two-sum/)
- **Date**: 2026-07-06
- **Language**: cpp


**The Problem**

Given an array of integers `nums` and an integer `target`, return the indices of the two numbers such that they add up to `target`. You may assume that each input would have exactly one solution, and you may not use the same element twice.

**Initial Thoughts**

I started by thinking about how to solve this problem in a brute-force way, which would involve iterating through the array and comparing each element with every other element until I found a pair that added up to the target. However, I quickly realized that this would have a time complexity of O(n^2), which is not efficient for large inputs.

**The Core Trick**

Instead, I decided to use a hash map to keep track of numbers seen so far and their indices. I iterated through the array, and for each element, I calculated its complement with respect to the target. If this complement was already present in the hash map, I immediately returned its index as the index of the element I was currently looking at. If it wasn't, I added the current element to the hash map with its index as the value. This approach has a time complexity of O(n), which is much more efficient.

**Complexity**

The time complexity of this solution is O(n), where n is the length of the input array. This is because we iterate through the array only once, and for each element, we perform a constant-time operation (storing in a hash map or checking if the complement exists). The space complexity is also O(n), as we store all the elements of the input array in the hash map.

**Key Takeaway**

This problem is a great example of how a hash map can be used to efficiently solve a problem with a brute-force approach. By storing the numbers we've seen so far and their indices in a hash map, we can quickly check if there's a complement for each number we encounter, and return its index when we find one.