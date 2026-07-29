# K-th Symbol in Grammar

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/k-th-symbol-in-grammar/)
- **Date**: 2026-07-29
- **Language**: java


**The Problem**

Given an integer `n` and an integer `k`, return the `k`th symbol in the nth grammar. The grammar is defined recursively as follows:

1. For `n = 0`, the only symbol is `0`.
2. For `n > 0`, the symbol is `0` if and only if the kth bit in the binary representation of `n` is `0`.

For example, the binary representation of `3` is `11`, and the second bit is `1`, so the 2nd symbol in the 3rd grammar is `0`.

**Initial Thoughts**

I initially thought about using a while loop to iterate through the bits of `n` and checking if they match the kth bit. However, this approach has a time complexity of O(n), which is too slow for large `n`.

**The Core Trick**

The key insight is that we can directly manipulate the binary representation of `n` to get the kth symbol without checking each bit separately. If `k` is even, then we can simply shift `n` to the right by `k / 2`. If `k` is odd, then we first check the last bit of `n`, which is the kth bit, and then XOR it with `n`.

**Complexity**

The time complexity of this solution is O(log k), which is much faster than the previous approach. The space complexity is O(1), since we only use a constant amount of additional storage.

**Key Takeaway**

This problem demonstrates the power of binary manipulation in solving problems related to binary representations. It's always worth considering how to directly manipulate the bits of a number to achieve a specific result.