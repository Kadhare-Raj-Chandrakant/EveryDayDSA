# Minimum Element After Replacement With Digit Sum

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/minimum-element-after-replacement-with-digit-sum/)
- **Date**: 2026-08-17
- **Language**: java


**The Problem**

Given an array of integers `nums`, replace each number with the sum of its digits. Then find the minimum element in the new array. For example, if `nums = [3, 4, 2]`, the resulting array would be [3, 7, 7], and the minimum element is 7.

**Initial Thoughts**

I started by thinking about how to replace each number with the sum of its digits. I knew I needed a loop to iterate over each element in the array, but I wasn't sure how to calculate the sum of the digits. I thought about using a helper method to do this, but I didn't know how to make it efficient. I also realized that I needed to handle the case where a number has no digits (e.g., 0).

**The Core Trick**

The core trick is to use a while loop that repeatedly divides the number by 10 and adds the remainder to a running total until the number becomes zero. This allows me to calculate the sum of the digits efficiently.

**Complexity**

My solution has a time complexity of O(n * log(m)), where n is the length of `nums` and m is the maximum number in `nums`. This is because each number in `nums` needs to be replaced with its sum of digits, and calculating the sum of digits involves dividing by 10 and adding the remainder. The space complexity is O(1), because I only need a constant amount of extra memory to store the running total.

**Key Takeaway**

This problem taught me that sometimes, the most straightforward solution isn't always the best. In this case, I needed to be creative and think outside the box to come up with an efficient solution to replace the digits of each number. Coming up with the while loop was key to making this problem solvable with a reasonable time complexity.