# Intersection of Two Arrays

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/intersection-of-two-arrays/)
- **Date**: 2026-08-11
- **Language**: java


Problem: Given two arrays, find the intersection of elements.

Initial Thoughts: This problem is straightforward and easy, but I struggled at first to come up with a clean and efficient solution. I initially tried using nested loops to iterate through both arrays and check for common elements, but this resulted in a time complexity of O(n^2), which is not acceptable for large inputs.

The Core Trick: I realized that we can use a set data structure to efficiently store the elements from the first array and then iterate through the second array to find the intersection. Since sets only allow unique elements, we can remove duplicates by iterating through the second array and checking if the element exists in our set.

Complexity: The time complexity of this solution is O(n + m), which is more efficient than the nested loop approach. The space complexity is O(min(n, m)), for the set to store unique elements from the first array.

Key Takeaway: When dealing with arrays, use data structures like sets to improve time and space complexity. This problem also demonstrates the importance of understanding the constraints and requirements of the problem to come up with an efficient solution.