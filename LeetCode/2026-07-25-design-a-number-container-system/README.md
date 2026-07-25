# Design a Number Container System

- **Difficulty**: Medium
- **Source**: [Alt-Leetcode](https://leetcode.com/problems/design-a-number-container-system/)
- **Date**: 2026-07-25
- **Language**: java


**The Problem**

Design a number container system that supports two operations: `change` and `find`. After each `change`, the system should ensure that the current numbers are unique. The system should also be efficient for both operations.

**Initial Thoughts**

Initially, I thought about using an unordered map to store the indices of each number. However, this approach would have a time complexity of O(n) for `find` operation as we'd need to iterate through all indices to find the requested number. To improve this, I decided to use a tree set to store indices for each number. This way, we can perform a logarithmic search to find the index of a specific number in O(log n).

**The Core Trick**

After implementing the basic structure, I realized that we need to keep track of the numbers that correspond to each index. To do this, I created two maps: `numToIndices` and `indexToNum`. The first map stores the numbers that correspond to each index, and the second map stores the indices that correspond to each number. By maintaining these two maps, we can easily update the indices of each number after `change`.

**Complexity**

The overall time complexity of this solution is O(log n) for `find` and O(log n) for `change`, which is efficient since it scales logarithmically with the number of elements. The space complexity is O(n) due to storing the tree sets and maps, but it's also efficient since it scales linearly with the number of elements.

**Key Takeaway**

This problem taught me the importance of maintaining a balance between data structures and their implementation. By using a tree set to store indices and a map to keep track of numbers and their corresponding indices, I was able to create a system that efficiently supports both operations. Reflect on how you can balance the complexity of your approach to optimize performance, especially when dealing with large datasets.