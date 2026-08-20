# Construct the Longest New String

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/construct-the-longest-new-string/)
- **Date**: 2026-08-20
- **Language**: java


**The Problem**

Given three integers `x`, `y`, and `z`, return the largest integer `res` that can be formed by concatenating the binary representations of `x`, `y`, and `z`.

**Initial Thoughts**

I initially thought the problem was asking to concatenate the binary representations of `x`, `y`, and `z` and return the largest integer formed. However, I realized that the problem was asking to construct the largest new string instead. I spent some time trying to convert the integers to binary and concatenate them, but I couldn't get a correct solution.

**The Core Trick**

The key to solving this problem was to notice that the problem was asking to maximize the number of zeros at the end of the binary representation of `res`. I thought about how I could leverage this idea to construct `res`.

**Complexity**

The time complexity of the solution is O(1), as it does not depend on the input size. The space complexity is also O(1), as only a constant amount of additional space is used to store the result.

**Key Takeaway**

The most important takeaway from this problem is to always look for patterns and exceptions in problem statements. Sometimes, the problem is asking for something that seems counterintuitive or unrelated to what the problem statement initially suggests. By keeping this in mind, I was able to identify the key idea that ultimately led to a correct solution.