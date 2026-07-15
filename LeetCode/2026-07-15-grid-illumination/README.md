# Grid Illumination

- **Difficulty**: Hard
- **Source**: [Leetcode](https://leetcode.com/problems/grid-illumination/)
- **Date**: 2026-07-15
- **Language**: java


I spent the day working on a problem that asked me to calculate the number of lamps turned on based on user queries of a grid. It was a challenging problem because it involved time and space complexity, which I had to be careful with.

The problem statement was simple enough, but writing the code was a bit more tricky. I had to create a map for each row and column to keep track of the number of lamps in that direction. I also needed to keep track of diagonal counts for each row and column to handle the queries effectively.

The key trick I used was to create a set of lamps to keep track of which lamps had already been processed. This helped me avoid duplicate calculations and ensured that each lamp was only processed once.

In terms of complexity, I used time complexity of O(m + q * 9) where m is the number of lamps and q is the number of queries. This was achieved by iterating through the lamps array and the queries array once. The space complexity was O(m) which I achieved by using maps to keep track of the row, column, diagonal1, and diagonal2 counts.

Overall, this problem was quite interesting and challenging, but I'm glad I was able to solve it. I also learned some new techniques for handling time and space complexity in coding problems.