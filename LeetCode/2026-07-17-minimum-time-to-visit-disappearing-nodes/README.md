# Minimum Time to Visit Disappearing Nodes

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/minimum-time-to-visit-disappearing-nodes/)
- **Date**: 2026-07-17
- **Language**: java


Today, I tackled a medium-difficulty problem on LeetCode, Minimum Time to Visit Disappearing Nodes. This problem involves finding the shortest time required to visit all vertices, considering that some edges might disappear over time. My solution was based on a graph traversal algorithm with a priority queue for efficient edge processing. Here's a brief overview of the problem, my initial thoughts, the core trick, complexity analysis, and key takeaways.

**The Problem**
Given the number of vertices `n`, an array of edges `edges`, and an array of disappearing nodes `disappear`, find the minimum time required to visit all vertices, considering that some edges might disappear over time. The edges are represented as `[source, destination, time]`, and the disappearing nodes are represented by the `disappear` array.

**Initial Thoughts**
At first, I tried a simple brute-force approach, iterating through all possible edge combinations and calculating the shortest time required to visit all vertices. However, this approach had a time complexity of O(n^3 * e), which is too high for large inputs. I then tried a depth-first search (DFS) approach, but it failed because of timeouts for large inputs.

**The Core Trick**
The core trick in this problem is to use a priority queue to efficiently process edges that might disappear over time. By prioritizing edges with shorter times, we can ensure that the shortest edge is processed first, even if it might disappear later. This way, we can avoid revisiting vertices unnecessarily.

**Complexity**
The time complexity of this solution is O(E + V log V), where E is the number of edges and V is the number of vertices. This is because we use a priority queue to process edges, and the time complexity of building a priority queue from an array is O(V log V). The space complexity of this solution is O(V + E), where V is the number of vertices and E is the number of edges. This is because we need to store the graph, the priority queue, and the result array.

**Key Takeaway**
When dealing with disappearing nodes or time-based constraints, it's crucial to use a priority queue to efficiently process edges. Prioritizing edges with shorter times ensures that the shortest edge is processed first, even if it might disappear later. This approach can significantly reduce the time complexity of the problem, making it a viable solution for large inputs.

In conclusion, solving this problem helped me understand the importance of using priority queues to efficiently process time-based constraints and how it can impact the time complexity of a graph traversal algorithm.