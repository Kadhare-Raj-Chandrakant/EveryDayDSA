# Sqrt(x)

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/sqrtx/)
- **Date**: 2026-07-03
- **Language**: java


**The Problem**

The problem asks to find the integer square root of a given number x. It's an easy problem in LeetCode, but I find it interesting because it requires finding the right balance between accuracy and efficiency.

**Initial Thoughts**

At first, I thought about using binary search, but I knew it wouldn't be efficient enough for large inputs. Then, I remembered that integer square roots can be calculated by repeatedly squaring the square root and subtracting it from the number until the result is less than the number. This approach is similar to Newton's method for finding square roots, but it's more straightforward to implement and has a better time complexity.

**The Core Trick**

In this problem, the key is to figure out how to accurately calculate the square root without taking the square root of the number itself. The approach I mentioned earlier is one way to do this. We start by initializing a variable `left` to 1 and `right` to `x` / 2. Then, we iterate until `left` is less than or equal to `right`. In each iteration, we find the midpoint between `left` and `right`, square it, and compare it to `x`. If it's equal, we return the midpoint as the square root. If it's less, we update `left` to be equal to the midpoint plus one. Otherwise, we update `right` to be equal to the midpoint minus one.

**Complexity**

The time complexity of this solution is O(log n), which is the best we can achieve for a general algorithm to calculate the square root of a number. The space complexity is O(1), as we only use a constant amount of extra space for the variables `left` and `right`.

**Key Takeaway**

This problem teaches me two things: first, the importance of understanding the difference between the square and the square root of a number, and second, how to implement a binary search-like algorithm efficiently for finding the square root of a number.