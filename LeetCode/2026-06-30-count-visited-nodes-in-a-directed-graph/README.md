# Count Visited Nodes in a Directed Graph

- **Difficulty**: Hard
- **Source**: [Leetcode](https://leetcode.com/problems/count-visited-nodes-in-a-directed-graph/)
- **Date**: 2026-06-30
- **Language**: java


Problem: Count Visited Nodes in a Directed Graph

Difficulty: Hard

Source: https://leetcode.com/problems/count-visited-nodes-in-a-directed-graph/

Initial Thoughts: This problem seems like a classic graph traversal problem where we need to count the number of nodes visited in a directed graph. At first glance, I thought of using Depth-First Search (DFS) or Breadth-First Search (BFS) to traverse the graph and keep track of the visited nodes. However, the time complexity of both DFS and BFS is O(V + E), where V is the number of vertices and E is the number of edges. In the worst case, this can lead to a quadratic time complexity if the graph contains a cycle. To avoid this, I decided to use a topological sort approach, which has a linear time complexity.

The Core Trick: In a directed graph, there can be multiple paths between two nodes. However, the number of nodes that a node can reach directly is limited by its in-degree. Therefore, we can use a topological sort approach to count the number of visited nodes in a directed graph. We can do this by iterating through the graph edges and updating the number of nodes that a node can reach directly based on its in-degree.

Complexity: The time complexity of this solution is O(n), where n is the number of vertices. This is because we only iterate through the graph edges once, and the space complexity is O(n) for the arrays used to store the cycle lengths, cycle node counts, and the final answer.

Key Takeaway: When dealing with directed graphs, it's essential to consider the in-degree of each node and use this information to optimize the traversal algorithm. This can lead to linear time complexity solutions, even in the worst case scenarios.