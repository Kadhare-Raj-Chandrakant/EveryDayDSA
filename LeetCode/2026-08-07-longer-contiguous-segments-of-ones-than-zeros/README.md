# Longer Contiguous Segments of Ones than Zeros

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/longer-contiguous-segments-of-ones-than-zeros/)
- **Date**: 2026-08-07
- **Language**: java


**The Problem**

Given a binary string `s`, find the length of the longest non-empty contiguous sequence of '1's, and the length of the longest non-empty contiguous sequence of '0's. Return `true` if there are more '1's than '0's in the string, and `false` otherwise.

**Initial Thoughts**

I first thought about using a sliding window approach, but that would require tracking both '1's and '0's in every window, which seems redundant. I also considered using a stack to keep track of the longest non-empty sequence of '1's, but that would only work for strings with equal number of '1's and '0's.

**The Core Trick**

The key insight here is to keep track of the maximum length of '1's and '0's separately. We can do this by initializing two variables `maxOnes` and `maxZeros`, which will keep track of the longest non-empty contiguous sequences of '1's and '0's, respectively. We then iterate through the string and update these variables whenever we encounter a '1' or a '0'. In the end, we compare `maxOnes` and `maxZeros` to determine whether there are more '1's than '0's in the string.

**Complexity**

The time complexity of this solution is O(n), where n is the length of the string, as we iterate through the string exactly once. The space complexity is O(1), as we only use a constant amount of space to store the variables `maxOnes` and `maxZeros`.

**Key Takeaway**

This problem highlights the importance of keeping track of different types of data when dealing with sequences in programming challenges. It also emphasizes the value of initializing variables to reasonable values based on the problem statement.

In conclusion, this problem was relatively easy to solve, given the opportunity to think about it for a bit and consider different approaches.