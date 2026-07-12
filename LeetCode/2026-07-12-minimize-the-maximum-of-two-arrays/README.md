# Minimize the Maximum of Two Arrays

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/minimize-the-maximum-of-two-arrays/)
- **Date**: 2026-07-12
- **Language**: java


**The Problem**

Given two arrays `divisor1` and `divisor2` with the same size, and two integer variables `uniqueCnt1` and `uniqueCnt2`, find the maximum value `max` such that the number of unique elements in `divisor1` is greater than or equal to `uniqueCnt1`, the number of unique elements in `divisor2` is greater than or equal to `uniqueCnt2`, and the total number of unique elements in both arrays is equal to the sum of `uniqueCnt1` and `uniqueCnt2`.

**Initial Thoughts**

At first, I thought about brute-forcing all possible combinations and checking if they satisfy the constraints. However, this would be too inefficient due to the large number of possible combinations.

**The Core Trick**

I realized that if I could find the maximum value of `divisor1` or `divisor2` that would be smaller than the LCM of both arrays, I could make the maximum value of the combined arrays smaller, without affecting the constraints. I could then adjust the maximum value of `divisor1` and `divisor2` to make the combined arrays as small as possible to meet the constraints.

**Complexity**

Time complexity: O(log n) due to the binary search algorithm. Space complexity: O(1) as we are not storing any extra arrays or variables.

**Key Takeaway**

This problem required a creative approach to leverage the constraints and find a clever solution. Even though the problem was medium-difficulty, it was still challenging as it required some advanced mathematical concepts to solve.

This problem taught me the importance of thinking creatively and using advanced mathematical concepts when solving problems. It also emphasized the importance of understanding the constraints and their impact on the solution.