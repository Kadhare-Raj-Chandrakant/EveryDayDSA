# Existence of a Substring in a String and Its Reverse

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/existence-of-a-substring-in-a-string-and-its-reverse/)
- **Date**: 2026-08-13
- **Language**: java


**The Problem**

Given a string `s`, return `true` if it contains any substring which is a palindrome and its reverse, otherwise return `false`. For example, `abba` contains palindromes `abba` and `ba`, but `abc` doesn't.

**Initial Thoughts**

At first, I thought of checking for all possible substrings of length 2 in the string. But that would be too slow. Also, checking for palindromes directly would require scanning the entire string twice. I then remembered a trick that could help me solve this problem efficiently.

**The Core Trick**

Since a palindrome is a string that reads the same forward and backward, its reverse is also a palindrome. If we find a palindrome in `s`, we can check if its reverse exists in `s`. If it does, we've found a substring that matches the problem's requirements.

**Complexity**

This approach has a time complexity of O(n), as we only need to check each character in the string once. The space complexity is also O(n) due to storing the reversed string.

**Key Takeaway**

Every problem can be solved by finding a clever trick or approach. It's important to think through all possibilities and then try to find a more efficient solution. In this case, the core trick allowed me to skip checking for palindromes directly and instead find a palindrome and its reverse in `s`.