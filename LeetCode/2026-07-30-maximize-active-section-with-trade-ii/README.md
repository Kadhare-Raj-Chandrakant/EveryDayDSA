# Maximize Active Section with Trade II

- **Difficulty**: Hard
- **Source**: [Leetcode](https://leetcode.com/problems/maximize-active-section-with-trade-ii/)
- **Date**: 2026-07-30
- **Language**: java


The problem I solved today was "Maximize Active Section with Trade II" from LeetCode, a notoriously challenging dynamic programming problem. My solution took a brute-force approach at first, but I realized that I needed a cleverer strategy.

Initial Thoughts: I tried a simple bottom-up approach, iterating over all possible substrings and counting the number of '1's and '0's. This worked well for small inputs, but I quickly ran out of memory. I also tried a more efficient approach using segment trees, but it didn't quite work.

The Core Trick: After a lot of trial and error, I realized that I could use a technique similar to the one used in Segment Tree updates. Instead of keeping track of the number of '1's and '0's in each segment, I kept track of the maximum number of '0's that could come before a '1'. This allowed me to query the maximum number of '0's in a given range in constant time, which was crucial for the problem.

Complexity: This solution has a time complexity of O(n + q log n), where n is the length of the string s and q is the number of queries. The space complexity is also O(n) due to the need to store the segment tree.

Key Takeaway: This problem taught me the importance of rethinking my approach and trying new techniques. I also learned the value of segment trees for efficiently updating a range in a dynamic array.