# Maximum XOR of Subsequences

- **Difficulty**: Hard
- **Source**: [Leetcode](https://leetcode.com/problems/maximum-xor-of-subsequences/)
- **Date**: 2026-08-16
- **Language**: java


**The Problem**

Given an array of integers `nums`, find the maximum XOR value among all the subsequences. An XOR operation is performed on integers by taking the bitwise exclusive OR of each pair of integers. The result of XOR operation on a bitwise pair of integers is 1 only if the corresponding bits in the two integers are different, and 0 otherwise.

**Initial Thoughts**

At first, I tried to generate all subsequences and compute their XOR values, but that solution had a time complexity of O(2^n), which is too slow. I then thought about using a binary search approach to find the maximum XOR value among all possible subarrays with a fixed size. However, I realized that this method would still result in a time complexity of O(n log n), as I needed to sort the subarrays based on their XOR values.

**The Core Trick**

The key to solving this problem is to maintain a basis array that stores the maximum XOR value among all the numbers that have their least significant bit set to 1. We then iterate through the input array and maintain the maximum XOR value among all the numbers with their least significant bit set to 0. Lastly, we XOR all the numbers with their least significant bit set to 1 to get the final result.

**Complexity**

The time complexity of this solution is O(n log n) due to the binary search approach to find the maximum XOR value among all possible subarrays with a fixed size. The space complexity is O(n) for the basis array.

**Key Takeaway**

This problem demonstrates the importance of using a binary search approach to efficiently solve problems with a large number of elements. Additionally, it highlights the significance of maintaining a basis array to efficiently compute maximum XOR values among numbers with specific combinations of bits set to 1.