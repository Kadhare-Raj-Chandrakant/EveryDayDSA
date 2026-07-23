# Next Greater Element III

- **Difficulty**: Medium
- **Source**: [Alt-Leetcode](https://leetcode.com/problems/next-greater-element-iii/)
- **Date**: 2026-07-23
- **Language**: java


Problem: Next Greater Element III

Initial Thoughts: This problem seems like a combination of Next Greater Element II and finding the smallest digit greater than a given digit. I started by converting the integer to a string, finding the first decreasing digit from right to left, and then finding the smallest digit greater than the decreasing digit from right to left. If no decreasing digit was found, I returned -1.

The Core Trick: The key to solving this problem was finding the smallest digit greater than the decreasing digit from right to left. I used a two-pointer approach to find the smallest digit, which helped me reverse the substring to the right of the decreasing digit and get the final result.

Complexity: The time complexity of this solution is O(log n) because I used the binary search algorithm to find the first decreasing digit and the smallest digit greater than the decreasing digit. The space complexity is also O(log n) because I used the same size of the input array for the reversed substring.

Key Takeaway: Always keep in mind the time and space complexity when solving a problem. This will help you write more efficient code and avoid potential issues.

In conclusion, this was a challenging but rewarding problem. I learned a new approach to finding the Next Greater Element and improved my understanding of time and space complexity.