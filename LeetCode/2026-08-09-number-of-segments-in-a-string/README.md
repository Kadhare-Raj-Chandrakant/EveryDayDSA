# Number of Segments in a String

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/number-of-segments-in-a-string/)
- **Date**: 2026-08-09
- **Language**: java


**The Problem**

Given a string `s`, find the number of segments in the string. A segment is defined as a maximal consecutive sequence of non-space characters.

**Initial Thoughts**

The first thing that came to mind was to iterate over the string and use a boolean variable to keep track of whether we're currently in a segment or not. Whenever we encounter a space, we reset the boolean variable to `false`, which means we're leaving the current segment and starting a new one. I've used this approach in my code.

**The Core Trick**

The key to solving this problem is to keep track of whether we're currently in a segment or not. This allows us to accurately count the number of segments in the string.

**Complexity**

Time complexity: O(n), where n is the length of the string. This is because we iterate over the string only once.

Space complexity: O(1), excluding the space needed for the input string. We don't use any extra space other than the input string itself.

**Key Takeaway**

The key to solving this problem was to identify the pattern of spaces and non-spaces in the string, and then use that pattern to count the number of segments. The time and space complexity analysis confirms that our solution is efficient and correct.