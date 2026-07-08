# Find the Degree of Each Vertex

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/find-the-degree-of-each-vertex/)
- **Date**: 2026-07-08
- **Language**: java


**The Problem**

Given an undirected graph represented by an adjacency matrix, write a function to return an array of degree of each vertex. The degree of a vertex is the number of edges connected to that vertex.

**Initial Thoughts**

I initially thought I could use a simple brute-force approach by iterating through the entire graph and counting the number of edges connected to each vertex. However, this would have a time complexity of O(n^2), which is not efficient for large graphs. I wanted to find a more optimized solution.

**The Core Trick**

The key to solving this problem is to use a single pass through the graph, counting the number of edges connected to each vertex as we traverse it. This way, we can efficiently update the degree array without iterating through the entire graph again.

**Complexity**

The time complexity of this solution is O(n + m), where n is the number of vertices and m is the number of edges. This is because we traverse the graph only once, and the time spent on counting edges is proportional to the number of edges. The space complexity is also O(n) since we are storing the degree of each vertex in an array.

**Key Takeaway**

This problem teaches us the importance of optimizing our time and space complexity to efficiently solve graph problems. By using a single pass through the graph, we can reduce the time complexity from O(n^2) to O(n + m). This technique can be applied to other graph problems as well.