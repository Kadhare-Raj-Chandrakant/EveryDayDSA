# Stone Game V

- **Difficulty**: Hard
- **Source**: [Leetcode](https://leetcode.com/problems/stone-game-v/)
- **Date**: 2026-07-12
- **Language**: java


The problem I solved today was the "Stone Game V" challenge on LeetCode, which requires finding the maximum sum of stones that can be removed from a row of the game board. This problem was quite challenging because of its dynamic programming nature and the need to consider all possible combinations of pairs of stones.

My initial thoughts were to try a brute-force approach, where I would iterate through all possible pairs of stones and calculate the sum of the remaining stones after removing both from the row. However, this approach would have a time complexity of O(n^2), which is too slow for large inputs.

The core trick to solving this problem is to use dynamic programming to store the maximum sum of stones that can be removed from a given subarray of the game board. At each step, I would consider all possible pairs of stones and calculate the sum of the remaining stones after removing both from the row. If the sum is greater than the current maximum sum, I would update the maximum sum accordingly.

The complexity of this approach is O(n^2), which is acceptable for large inputs. The space complexity is also O(n^2), since we are storing the results of all subarrays of the game board.

In conclusion, understanding the core trick of using dynamic programming to solve this problem was key to completing it efficiently. This approach allowed me to find the maximum sum of stones that can be removed from a row of the game board, providing a solution to the problem.