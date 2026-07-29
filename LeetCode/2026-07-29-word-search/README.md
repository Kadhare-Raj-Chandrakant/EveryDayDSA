# Word Search

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/word-search/)
- **Date**: 2026-07-29
- **Language**: java


Word Search was a medium-difficulty problem that I found quite interesting. The goal was to search for a given string in a 2D board of characters, where the string could be moved in any of the eight directions (up, down, left, right, and the four diagonals).

My initial thoughts were to use a brute-force approach, trying every possible combination of characters in the board and comparing them with the given string. However, I quickly realized that this approach would be too slow for larger boards and strings, as it would have a time complexity of O(N * M * 4^L), where N and M are the number of rows and columns in the board, and L is the length of the string. This was not an acceptable solution for the contest problem, which had a time limit of 2 seconds.

After some brainstorming, I realized that a more efficient approach would be to use a recursive DFS (Depth First Search) algorithm. By keeping track of the current position and the number of matches, I could traverse the board and check if it was a match. If it was, I would mark the cell as visited and return true, otherwise, I would try different directions.

The key takeaway from this problem was learning the power of recursion and how it can be used to solve problems that seem too complex at first. By breaking down the problem into smaller sub-problems and using recursion to solve them, I was able to develop a more efficient solution that passed all test cases.

In terms of complexity, this approach has a time complexity of O(N * M * L), which is much better than the brute-force approach. The space complexity is also O(L), as the recursion stack is used to keep track of the current position and the number of matches.

Overall, this was a great learning experience that taught me the importance of efficient algorithms for solving coding problems. I am excited to continue honing my skills and apply them to more complex problems in the future.