# Maximum Enemy Forts That Can Be Captured

- **Difficulty**: Easy
- **Source**: [Alt-Leetcode](https://leetcode.com/problems/maximum-enemy-forts-that-can-be-captured/)
- **Date**: 2026-07-18
- **Language**: java


**The Problem**

Given an array of forts, calculate the maximum number of forts that can be captured by traversing the array from both ends towards the center. A fort can be captured if it's surrounded by my forts (1s) and there are no enemy forts (-1s) between the fort and my forts.

**Initial Thoughts**

At first, I thought about implementing a sliding window approach to count the number of enemy forts between my forts and then updating the result accordingly. However, I realized that such an approach would have a time complexity of O(n^2), which is not efficient for large arrays.

**The Core Trick**

To optimize the time complexity, I decided to use a two-pointer approach. One pointer starts from 0 and the other from the end of the array. I keep updating the result and the indices of the last my fort and last empty fort based on the fort values encountered during the traversal. This way, I only need to check the forts within my range and avoid unnecessary calculations.

**Complexity**

The time complexity of the solution is O(n), which is much more efficient than the previous approach. The space complexity is O(1), as we only keep track of two indices.

**Key Takeaway**

This problem demonstrates the importance of careful analysis and optimization of time and space complexity in solving coding problems. By understanding the constraints and properties of the data structures used, we can develop efficient solutions that can handle large inputs.