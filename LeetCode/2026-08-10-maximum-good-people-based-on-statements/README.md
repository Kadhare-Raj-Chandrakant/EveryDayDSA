# Maximum Good People Based on Statements

- **Difficulty**: Hard
- **Source**: [Alt-Leetcode](https://leetcode.com/problems/maximum-good-people-based-on-statements/)
- **Date**: 2026-08-10
- **Language**: java


**The Problem**

Given an array of statements where statements[i][j] represents a relationship between people i and j. 
Your task is to find the maximum number of people who have no conflicting statements based on the given statements.

**Initial Thoughts**

Well, this problem seems hard to tackle. I thought about using backtracking but it would be too slow. I decided to use a brute force approach and check all possible combinations.

**The Core Trick**

The core trick here is that we only need to consider people who are included in the mask. We can exclude people who are not included in the mask because their statements are not relevant to the current combination.

**Complexity**

This solution has a time complexity of O(n * 2^n) and a space complexity of O(n). The time complexity comes from checking all possible combinations of people in the mask, and the space complexity comes from storing the current combination of people.

**Key Takeaway**

This problem teaches us that sometimes, brute force approach can work if we are careful about what we are checking. In this case, we need to carefully select which people we are considering based on the mask.