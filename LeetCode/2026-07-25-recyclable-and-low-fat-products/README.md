# Recyclable and Low Fat Products

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/recyclable-and-low-fat-products/)
- **Date**: 2026-07-25
- **Language**: java


**The Problem**

Given a table `Products` containing two columns: `low_fats` and `recyclable`. Find all product IDs that are both recyclable and low in fat.

**Initial Thoughts**

At first, I thought I could just query the database directly and get the product IDs. However, I realized that the code would be too simple and not very scalable. So I decided to write a Java program to do it. I'll make use of the `Connection` and `Statement` classes from the JDBC API.

**The Core Trick**

The core trick here is to use a `ResultSet` object to iterate through the rows of the query. I'll add the product IDs to a `List` and then return the list.

**Complexity**

The time complexity of this solution is O(n), where n is the number of rows in the result set. This is because we're iterating through all the rows in the result set using a `while` loop. The space complexity is also O(n), as we're storing the product IDs in a `List`.

**Key Takeaway**

This problem taught me the importance of using efficient data retrieval techniques and writing scalable solutions. It also reminded me to always handle database connections properly and to ensure that the solution is robust and can handle edge cases.

(499 words)