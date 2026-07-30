# Count Number of Maximum Bitwise-OR Subsets

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/)
- **Date**: 2026-07-30
- **Language**: java


**The Problem**

Given an array of integers `nums`, count the number of unique subsets whose elements when bitwise-OR'd together result in the maximum possible value.

**Initial Thoughts**

At first, I thought about using a dynamic programming approach to make a table of all possible combinations of numbers and their bitwise-ORs. However, this solution would have a time complexity of O(n * 2^n), which is too high. I then tried using a brute-force approach but realized it would also take too long. I decided to use a more efficient solution by iterating through all possible subsets and checking if their bitwise-ORs are equal to the maximum possible value.

**The Core Trick**

To find the unique subsets, I used a combination of the `&` operator to find the intersection of two sets (subsets) and the `|` operator to perform bitwise-OR. I also used a variable `max` to keep track of the maximum value found so far, and a variable `count` to keep track of the number of subsets with this maximum value.

**Complexity**

Time complexity: O(n * 2^n), where n is the length of `nums`. This is because we need to check all possible subsets and their bitwise-ORs.

Space complexity: O(n), which is the size of `nums`. This is because we need to store all possible combinations of numbers and their bitwise-ORs.

**Key Takeaway**

This problem taught me the importance of thinking about the time and space complexity of my solutions. I also learned that even if a problem seems difficult, there is usually a clever trick or algorithm that can solve it efficiently. In this case, using the bitwise operators and bit manipulation allowed me to come up with an efficient solution.