# Number of Excellent Pairs

- **Difficulty**: Hard
- **Source**: [Leetcode](https://leetcode.com/problems/number-of-excellent-pairs/)
- **Date**: 2026-08-01
- **Language**: java


**The Problem**

Given an array of integers `nums` and an integer `k`, return the number of excellent pairs. An excellent pair is defined as an array `[a, b]` where `nums[a] & nums[b] == k`, which means the bitwise AND of the two numbers is equal to `k`.

**Initial Thoughts**

This problem seems challenging due to the high time complexity. The brute-force idea would be to iterate through all pairs and check if they are excellent. However, this approach has a time complexity of O(n^2), which is too slow for large inputs.

**The Core Trick**

The key idea is to use a frequency map to count the occurrences of each bit value. Then, for each bit value `i`, we can iterate over all other bit values `j` from 0 to `k - 1`, and for each valid `j`, we can count the number of excellent pairs with `i` as the first bit and `j` as the second bit. The result is the number of excellent pairs with `i` as the first bit or equal to `k`, and `j` as the second bit or less than `i`. This approach has a time complexity of O(n log n) due to sorting and binary operations.

**Complexity**

The time complexity of this solution is O(n log n). This is because we are sorting the array and iterating over all pairs using a binary search, which has a time complexity of O(log n). The space complexity is O(n) due to storing the frequency map.

**Key Takeaway**

This problem is a good example of how to use a frequency map to solve problems with bitwise operations. It's essential to break down the problem into smaller, manageable parts and think clearly about the relationships between different components.