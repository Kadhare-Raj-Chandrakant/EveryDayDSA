# Lexicographically Smallest String After Substring Operation

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/lexicographically-smallest-string-after-substring-operation/)
- **Date**: 2026-08-21
- **Language**: java


**The Problem**

Given a string `s`, determine the lexicographically smallest string that can be obtained by repeating the operation of changing each character `s[i]` to `s[i]-1` as long as possible.

**Initial Thoughts**

This problem might seem straightforward, but the real challenge lies in understanding the constraints and the operations allowed. I initially thought of using a brute-force approach, where I would iterate through each character and subtract one until no more changes can be made. However, this solution would have a time complexity of O(n^2), which is not acceptable for large inputs.

**The Core Trick**

To optimize the solution, I needed to think about how to efficiently modify each character without iterating through the entire string repeatedly. This led me to the idea of using a sliding window approach. I would start from the leftmost character and keep incrementing it until I find a 'a', as that would be the last character to be modified. Then, I would start over from the leftmost character and repeat this process for as long as possible.

**Complexity**

The time complexity of this solution is O(n), which is more efficient than the brute-force approach. The space complexity is also O(n), as we are storing the characters in the array `chars`.

**Key Takeaway**

This problem taught me the importance of understanding the constraints and operations allowed in coding challenges. Being able to think creatively and optimize a solution based on the problem's requirements can lead to more efficient and elegant solutions. In this case, the sliding window approach allowed me to modify each character without iterating through the entire string repeatedly, leading to a more efficient solution.