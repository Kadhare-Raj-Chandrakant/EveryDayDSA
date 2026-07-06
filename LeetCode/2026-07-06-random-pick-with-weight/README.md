# Random Pick with Weight

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/random-pick-with-weight/)
- **Date**: 2026-07-06
- **Language**: java


**The Problem**

Given an array of integers representing the weights of items, implement a weighted random pick function with a time complexity of O(n) and a space complexity of O(n).

**Initial Thoughts**

Initially, I thought of using a hashmap to store the cumulative sum of weights and then using it to pick a random index. However, this approach has a time complexity of O(n) for the constructor and O(log n) for the pickIndex function, which is not good enough. I also considered using a priority queue, but it has a time complexity of O(log n) for both the constructor and the pickIndex function.

**The Core Trick**

The key to this problem is to use binary search to pick an index with a given probability. We maintain two pointers, `left` and `right`, that represent the range of indices with cumulative sums less than or equal to the target. We then increment the `left` pointer if the current cumulative sum is greater than the target, and decrement the `right` pointer otherwise. This way, we ensure that the probability of picking an index from the `left` pointer to the current index is equal to the target probability.

**Complexity**

The time complexity of this solution is O(n) for the constructor and O(log n) for the pickIndex function. The space complexity is O(n) to store the cumulative sums.

**Key Takeaway**

This problem taught me the importance of using binary search when dealing with probability-based problems and maintaining cumulative sums. It also reinforced the idea of using a binary search to optimize time complexity.