# Calculate Special Bonus

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/calculate-special-bonus/)
- **Date**: 2026-08-04
- **Language**: java


**The Problem**

Given an array of integers `nums`, calculate the average bonus of each person in a company. The bonus is defined as the sum of all employees' salaries divided by the number of employees, and it should be calculated for each employee separately.

**Initial Thoughts**

I first tried to solve this problem by calculating the sum of all salaries and then dividing it by the number of employees. However, this approach has a time complexity of O(n^2) because we need to calculate the average bonus for each employee. I realized that this problem could be solved more efficiently by using a prefix sum array to calculate the average bonus for all employees up to a certain index.

**The Core Trick**

In this problem, we need to find the average bonus for each employee by calculating the sum of all salaries and dividing it by the number of employees up to that employee. This can be done efficiently using a prefix sum array. The prefix sum array `prefixSum` stores the sum of salaries from the beginning to each index. To calculate the average bonus for employee `i`, we need to subtract the sum of salaries from index 0 to `i-1` (which is the sum of salaries for employees before `i` minus the salary of employee `i`) and divide it by `i+1` (since the average bonus is calculated for all employees up to `i`).

**Complexity**

Time Complexity: O(n)
Space Complexity: O(n)

**Key Takeaway**

This problem demonstrates the importance of using prefix sum arrays to efficiently calculate averages or sums in problems involving arrays of integers. It also highlights the need to consider time and space complexity when solving problems, as inefficient solutions can lead to timeouts or memory errors.

(498 words)