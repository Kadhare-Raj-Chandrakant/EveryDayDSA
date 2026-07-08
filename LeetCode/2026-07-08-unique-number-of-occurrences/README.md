# Unique Number of Occurrences

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/unique-number-of-occurrences/)
- **Date**: 2026-07-08
- **Language**: java


The problem I solved today was "Unique Number of Occurrences," a relatively easy LeetCode question. It asks you to check if the count of each number in an unsorted array is unique. This problem is a variant of the "majority element" problem, but with a twist. My solution code is straightforward and elegant, using a hash map to count occurrences and a boolean array to keep track of unique counts.

My initial thoughts were to sort the array and use two-pointer technique to find the majority element. However, after some contemplation, I realized that sorting the array would have a time complexity of O(nlogn), which is not efficient for this problem. Instead, I decided to use a hash map, which has a time complexity of O(n). This approach also handles the case where there are multiple occurrences of the same number, as it counts the count of each number.

The core trick here is using a range of 1000 to represent the numbers in the array. This allows us to map an integer to its count in a more compact way and helps in avoiding overflow issues. The key takeaway is that when dealing with a problem of this type, it's important to think creatively and avoid using brute-force solutions.

This solution has a time complexity of O(n) and space complexity of O(n). Although it's not the most efficient solution for large inputs, it's a simple and clear approach to implement. The next time I encounter a problem like this, I'll remember to use a hash map and consider using a range to represent numbers.