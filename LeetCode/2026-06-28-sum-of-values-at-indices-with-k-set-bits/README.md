# Sum of Values at Indices With K Set Bits

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/sum-of-values-at-indices-with-k-set-bits/)
- **Date**: 2026-06-28
- **Language**: cpp


**The Problem**

Given an array of integers `nums` and an integer `k`, calculate the sum of all indices whose binary representations have exactly `k` set bits.

**Initial Thoughts**

At first, I thought about using a bitmask or a frequency counter to keep track of the count of set bits. However, I quickly realized that this approach would have a time complexity of O(n * log n), which is too slow for the constraints. I then tried using a brute-force approach with a loop, but that also didn't work well because of the large space complexity.

**The Core Trick**

To solve this problem efficiently, I needed to find a way to count the number of set bits in a binary representation without actually representing the binary representation. I remembered that the number of set bits in a number is equal to the number of ones in its binary representation minus one. I also recalled that by shifting a number to the left by one bit, we can remove the rightmost set bit. I used these insights to create an iterative solution that had a time complexity of O(n) and a space complexity of O(1).

**Complexity**

The time complexity of this solution is O(n) because for each element in the array, we need to shift it to the right k times to remove the rightmost set bits until it becomes zero. The space complexity is O(1) because we only need a constant amount of additional space to store the current index and the count of set bits.

**Key Takeaway**

This problem taught me that sometimes, when we encounter a problem with a seemingly complex solution, we can find a simpler and more efficient approach by thinking about the underlying principles and patterns in the problem. In this case, I was able to identify the key insight that allowed me to create an efficient solution to calculate the sum of indices with k set bits.

In conclusion, I am glad that I was able to solve this problem and learn from it.