# Word Search II

- **Difficulty**: Hard
- **Source**: [Leetcode](https://leetcode.com/problems/word-search-ii/)
- **Date**: 2026-07-31
- **Language**: java


Word Search II is a classic problem in LeetCode, but it's not the first time I've faced it. I remember struggling with the brute-force solution because it was too slow. This time, I approached it with a more clever algorithm.

Initial Thoughts: After reading the problem, I thought of using a Trie data structure to efficiently check if a word exists in the grid. However, I wasn't sure how to traverse the grid while using Trie.

The Core Trick: I decided to use Depth-First Search (DFS) to traverse the grid and check the Trie at the same time. I also added a '#' character to the grid to mark visited cells and prevent backtracking into the same cell.

Complexity: In the worst case, I need to check every word in the Trie and every cell in the grid. So, the time complexity is O(m * n * 4^L + N), where m is the number of rows, n is the number of columns, L is the maximum length of a word, and N is the total number of words. The space complexity is also O(N), because I store every word in the result list.

Key Takeaway: Designing clever algorithms is crucial to solving hard problems efficiently. In this case, DFS helped me find an optimal solution to Word Search II.