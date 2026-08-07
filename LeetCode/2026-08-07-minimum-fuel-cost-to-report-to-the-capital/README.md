# Minimum Fuel Cost to Report to the Capital

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/minimum-fuel-cost-to-report-to-the-capital/)
- **Date**: 2026-08-07
- **Language**: java


Problem: Minimum Fuel Cost to Report to the Capital

Initial Thoughts: This problem seems like a variation of the all-pairs shortest path problem with some constraints. I want to find the minimum fuel cost to reach all the cities from the capital, but I can only seat a certain number of people in each city. My first instinct is to use Dijkstra's algorithm to find the shortest path for each city and then add up the fuel costs for all the cities. However, that won't work because I can't seat a large number of people in each city, so I need to consider the number of people I can seat and adjust the fuel cost accordingly.

The Core Trick: I realized that I could use a depth-first search (DFS) algorithm to find the subtree size for each city and then calculate the fuel cost based on the number of people I can seat in each city. I also need to consider the parent node when calculating the fuel cost, as it affects the number of people I can seat in its subtree.

Complexity: The time complexity of this algorithm is O(n^2), where n is the number of cities. This is because for each city, I need to perform a DFS and calculate the subtree size for all the cities. The space complexity is also O(n), as I need to store the graph and the subtree size array.

Key Takeaway: This problem requires careful consideration of the constraints and the problem statement. I need to think about how the number of people I can seat in each city affects the fuel cost and how the parent node affects the subtree size. I also need to be careful with the time and space complexity of the algorithm, as the problem asks for a solution with a time complexity of O(n).