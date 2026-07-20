# Minimum Money Required Before Transactions

- **Difficulty**: Hard
- **Source**: [Alt-Leetcode](https://leetcode.com/problems/minimum-money-required-before-transactions/)
- **Date**: 2026-07-20
- **Language**: java


Today, I tackled a challenging problem on LeetCode: "Minimum Money Required Before Transactions." Given a 2D array of transactions where each transaction is represented as [earn, spend], the task was to find the minimum amount of money required before all transactions to ensure there's enough to cover all spending.

My initial thoughts were to sort the transactions first by earn and then by spend, and then iterate through the transactions to calculate the minimum money required for each earn and each spend. However, this approach would have a time complexity of O(n log n) due to sorting.

The core trick was to split the transactions into two arrays: one for earn transactions and another for debt transactions. This allowed me to sort the earn transactions first by cost in descending order, and the debt transactions by cashback in ascending order. This resulted in a time complexity of O(n log n) for sorting and O(n) for iterating through the sorted transactions.

The complexity analysis was straightforward. Time complexity was O(n log n) due to sorting, and space complexity was O(n) for sorting in place. The key takeaway was to think creatively about splitting the transactions into two groups, one with positive earn and one with negative spend. This allowed me to apply two sorting orders, one for earn and one for spend, to calculate the minimum money required in a more efficient way.