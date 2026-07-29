# Minimum White Tiles After Covering With Carpets

- **Difficulty**: Hard
- **Source**: [Leetcode](https://leetcode.com/problems/minimum-white-tiles-after-covering-with-carpets/)
- **Date**: 2026-07-29
- **Language**: java


Today, I tackled a challenging problem on LeetCode: "Minimum White Tiles After Covering With Carpets" (Medium). The goal is to minimize the number of white tiles on a floor after covering it with carpets of specific lengths.

Initial Thoughts: I first attempted a brute-force solution, iterating through all possible combinations of carpet placement and updating the dp table accordingly. However, this approach had a time complexity of O(n * numCarpets * carpetLen), making it inefficient for large inputs.

The Core Trick: The key insight is that the problem can be solved using dynamic programming with overlapping subproblems. We can iterate through the floor from right to left, keeping track of the number of white tiles in the current segment. By using a dp table with dimensions (floor size + 1) x (numCarpets + 1), we can efficiently compute the minimum number of white tiles for each possible combination of carpet placement and current tile count.

Complexity: The time complexity of this solution is O(n * numCarpets * carpetLen), which is not optimal but still efficient enough for most cases. The space complexity is O(n * numCarpets) due to the dp table.

Key Takeaway: Identifying the structure of the problem and leveraging dynamic programming to solve it is crucial. In this case, it allowed me to efficiently compute the minimum number of white tiles without resorting to a brute-force solution.

(489 words)