# Not Boring Movies

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/not-boring-movies/)
- **Date**: 2026-08-10
- **Language**: java


**The Problem**

Given a list of movie schedules and their genres, find the movies with a different release hour and a non-"boring" genre.

**Initial Thoughts**

This problem seems simple; just iterate through the list, check if the release hour is odd (to avoid "boring" movies at odd hours) and if the genre is not "boring". However, I immediately thought about the sorting part. How can I sort the results based on the "watch time" (duration) instead of the release hour? I've seen problems where sorting was based on a specific field, not just the default order.

**The Core Trick**

The core trick is to use the time difference between the start and end times of the movie. By subtracting one time from the other, we get the duration, which is a number that can be easily compared. This allows us to sort the results based on the "watch time" first, and then release hour.

**Complexity**

This problem has a time complexity of O(n log n) due to the sorting step. The space complexity is O(n) for storing the results.

**Key Takeaway**

When dealing with sorting problems, think about ways to create a custom comparator or use the built-in sorting function with a custom key. Also, consider the data type of the field you're sorting on. In this case, using double for "watch time" makes sense, as it can represent a wide range of durations.