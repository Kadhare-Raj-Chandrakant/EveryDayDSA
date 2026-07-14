# Matrix Similarity After Cyclic Shifts

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/matrix-similarity-after-cyclic-shifts/)
- **Date**: 2026-07-14
- **Language**: java


**The Problem**

Given a matrix `mat` of integers and an integer `k`, determine whether it can be made similar to another matrix by applying cyclic shifts on the rows of `mat`. Two matrices are considered similar if one can be obtained from the other by permuting the columns and applying row-wise cyclic shifts.

**Initial Thoughts**

At first, I thought about iterating through each row of `mat`, shifting it by `k`, and then comparing it with the original row. This approach would be too slow because it would involve creating a new array for each shift, which would grow linearly with the number of rows.

**The Core Trick**

The key insight here is to realize that we can perform each shift in constant time by using the concept of modular arithmetic. Specifically, we can shift each row by `(i % 2 == 0 ? -k : k) + n` mod `n`, which means that if `i` is even, we shift to the left by `-k`, and if `i` is odd, we shift to the right by `k`. This way, we can perform all the shifts in constant time.

**Complexity**

The time complexity of this solution is O(m * n), where m is the number of rows and n is the number of columns. This is because we iterate through each row once and compare it with the original row. The space complexity is also O(m * n), since we create a new array for each row shift.

**Key Takeaway**

This problem highlights the importance of modular arithmetic in solving algorithmic problems. By using a clever approach that takes advantage of this concept, we can significantly improve the time complexity of the solution.