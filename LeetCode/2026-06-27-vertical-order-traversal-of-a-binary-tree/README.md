# Vertical Order Traversal of a Binary Tree

- **Difficulty**: Hard
- **Source**: [Leetcode](https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/)
- **Date**: 2026-06-27
- **Language**: cpp


Today, I tackled a challenging problem: Vertical Order Traversal of a Binary Tree. Given a binary tree, the goal is to print each node's value in order from left to right, row by row, based on the tree's vertical distance from the root. This problem required traversing the tree in a unique way and storing the results in a 2D vector.

Initial Thoughts:
I first tried a depth-first search (DFS) approach using recursion and maintaining a map to store the horizontal distance of each node. However, this approach had a time complexity of O(N^2) due to the repeated traversal of the same nodes. I then moved on to a breadth-first search (BFS) approach using a queue and a map to store the nodes' vertical distance. This approach had a time complexity of O(N log N) due to sorting the nodes based on their vertical distance.

The Core Trick:
The key to solving this problem was to sort the nodes based on their vertical distance and then iterate through the sorted list, printing the values for each row. This allowed me to traverse the tree in a unique way without repeating any nodes.

Complexity:
The time complexity of this solution is O(N log N) due to the sorting operation in the BFS iteration. The space complexity is O(N) for storing the result vector and the map to store the nodes' vertical distance.

Key Takeaway:
When dealing with tree traversal problems, it's important to consider the unique challenges and think creatively to find an efficient solution. In this case, I was able to solve the problem by combining depth-first search and breadth-first search approaches, which ultimately led to an efficient solution with a time complexity of O(N log N).