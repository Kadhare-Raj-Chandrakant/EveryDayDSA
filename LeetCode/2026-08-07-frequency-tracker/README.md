# Frequency Tracker

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/frequency-tracker/)
- **Date**: 2026-08-07
- **Language**: java


**The Problem**

The problem asks to create a Frequency Tracker that can add, delete elements, and check the existence of a particular frequency. The solution should have a time complexity of O(1) for all operations.

**Initial Thoughts**

The first thing that popped into my mind was using a HashMap to store the frequency of each element. However, this approach would have a space complexity of O(n), which is not ideal. After some brainstorming, I thought about using a two-dimensional array to store frequency counts. This way, we can efficiently access and update the frequency count of a particular element.

**The Core Trick**

The core trick here is to use a two-dimensional array to store the frequency count of each element. This allows for constant-time lookups and updates. Additionally, we need to keep track of the count of each frequency using another array, which will help us determine if a frequency exists in the tracker.

**Complexity**

The time complexity for `add` and `deleteOne` is O(1), as we only need to update a constant number of elements in the array. The space complexity is O(n) due to the two-dimensional array storing frequency counts. 

**Key Takeaway**

When dealing with problems involving frequency counts, it's crucial to think about the data structure that can efficiently store and update the frequency count of each element. In this case, using a two-dimensional array is a simple yet effective solution.