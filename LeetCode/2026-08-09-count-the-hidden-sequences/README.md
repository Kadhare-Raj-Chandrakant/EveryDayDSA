# Count the Hidden Sequences

- **Difficulty**: Medium
- **Source**: [Alt-Leetcode](https://leetcode.com/problems/count-the-hidden-sequences/)
- **Date**: 2026-08-09
- **Language**: java


**The Problem**

Given an array of integers `differences` and two integers `lower` and `upper`, count the number of arrays `arr` such that `lower <= arr[i] - arr[j] <= upper` for all `i` and `j`. Here, `arr[i]` represents the `i`-th element of the array.

**Initial Thoughts**

I first tried to solve this problem by iterating over the input array and checking if each element `diff` is in the valid range. This approach had a time complexity of O(n^2) and was not efficient enough.

**The Core Trick**

The key to solving this problem is to use a sliding window approach. We maintain a sum of elements and keep updating the minimum and maximum sum. By doing this, we can efficiently calculate the range of valid elements in constant time.

**Complexity**

This solution has a time complexity of O(n) and a space complexity of O(1). The time complexity is because we need to iterate over the input array only once, and the space complexity is because we store only three variables (`min`, `max`, and `sum`).

**Key Takeaway**

Always try to solve problems using a systematic approach and avoid brute-force solutions. In this problem, using a sliding window approach allowed me to solve it efficiently.