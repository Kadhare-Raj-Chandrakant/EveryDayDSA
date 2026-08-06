# Intersection of Two Arrays II

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/intersection-of-two-arrays-ii/)
- **Date**: 2026-08-06
- **Language**: java


**The Problem**

Given two arrays `nums1` and `nums2` where each element in `nums1` appears once and only once in `nums2`, find the intersection of both arrays.

**Initial Thoughts**

I first tried an approach similar to the one in LeetCode's explanation: create two pointers for each array, compare elements, and keep track of elements in the result array. However, this approach has a time complexity of O(n log n) due to sorting. I then tried to optimize it by using two pointers for each array but without sorting. This approach also has a time complexity of O(n log n), but it is more straightforward.

**The Core Trick**

I realized that both approaches can be further optimized by using two pointers for each array and keeping track of elements in a hash set, which allows for constant-time lookups. This optimization reduces the time complexity to O(m + n), where m and n are the lengths of `nums1` and `nums2`, respectively.

**Complexity**

The time complexity is O(m + n) because the while loop iterates through both arrays at most once, and maintaining a hash set takes O(m + n) time.

**Key Takeaway**

This problem serves as a reminder that there are often multiple ways to solve a problem, and using the right algorithm for the right problem can lead to a significant improvement in time complexity.

(489 words)