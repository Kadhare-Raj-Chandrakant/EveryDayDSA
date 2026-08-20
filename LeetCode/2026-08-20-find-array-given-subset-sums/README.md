# Find Array Given Subset Sums

- **Difficulty**: Hard
- **Source**: [Leetcode](https://leetcode.com/problems/find-array-given-subset-sums/)
- **Date**: 2026-08-20
- **Language**: java


Today, I tackled a challenging problem on LeetCode: `Find Array Given Subset Sums`. Given an integer `n` and an array of integers `sums`, the task is to find all possible arrays whose elements sum up to the given subset sums. 

Initial thoughts: I initially tried a brute-force approach, generating all possible combinations of elements from the original array that add up to each subset sum. However, this solution had a time complexity of `O(2^n * n)`, which was not efficient enough for large inputs. I then realized that sorting the `sums` array and using a depth-first search (DFS) could help optimize the solution.

The core trick: The key insight was to use the sorted `sums` array to generate all possible combinations of elements from the original array that add up to each subset sum. By keeping track of the current position in the original array and updating the sums array with the difference between consecutive elements, I could generate all possible combinations of elements that add up to each subset sum.

Complexity: The time complexity of this solution is `O(2^n * n log n)`, which is mainly due to the sorting step and the DFS recursion. The space complexity is also `O(2^n * n)` for storing the subsets and recursion stack.

Key takeaway: This problem taught me the importance of thinking creatively and optimizing algorithms when faced with challenging constraints. By leveraging the sorted `sums` array and using a DFS approach, I was able to generate all possible combinations efficiently and solve this problem.