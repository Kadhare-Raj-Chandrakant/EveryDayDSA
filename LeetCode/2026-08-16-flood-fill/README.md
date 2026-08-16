# Flood Fill

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/flood-fill/)
- **Date**: 2026-08-16
- **Language**: java


The problem I solved today was the "Flood Fill" problem from LeetCode. It was an easy problem and asked to modify the image using a given color. This was a great opportunity to practice depth-first search (DFS) and recursion.

My initial thoughts were about using a brute-force approach where I would iterate through all the neighboring cells and check if they have the same old color. If so, I would change their color to the new one. But I quickly realized that this would be too slow and take up a lot of space. I then thought about using a recursive approach where I would keep track of the old color and change it to the new one if it matches. This way, I could avoid checking the same cell multiple times.

The core trick of this problem was to use DFS to traverse the image and change the color of the cells as I went. This allowed me to avoid checking the same cell multiple times and allowed me to efficiently modify the image.

In terms of complexity, my time complexity was O(m * n), where m and n are the dimensions of the image, due to the DFS traversal. The space complexity was also O(m * n) due to the recursive call stack.

After solving the problem, I realized that I had made a mistake in my implementation. I had accidentally passed the new color as an argument to the dfs function instead of the old color. This resulted in an unexpected behavior where some cells were not being modified correctly. But after fixing this, I was able to pass all the test cases.

Key takeaway from this problem was the importance of testing your code thoroughly and verifying that it works correctly. It also highlighted the need to use recursion carefully and to keep track of the base cases and the recursive case.