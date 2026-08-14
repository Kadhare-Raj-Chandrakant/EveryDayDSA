# Process String with Special Operations I

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/process-string-with-special-operations-i/)
- **Date**: 2026-08-14
- **Language**: java


**The Problem**

Given a string `s`, write a function to process the string by applying various special operations. The operations are: `*`, `#`, and `%`.

* `*`: Removes the last character from the string.
* `#`: Prepends the current string to itself.
* `%`: Reverses the order of characters in the string.

**Initial Thoughts**

At first, I thought this problem could be solved using a stack or a queue. I thought about using a stack to keep track of characters and their indices, and then removing the last character when encountering a `*` operation. But I realized that using a stack would have a high time complexity of O(n), where n is the length of the string s. I also thought about using a queue to reverse the order of characters, but that would also have a high time complexity of O(n).

**The Core Trick**

After some thinking, I realized that I could solve this problem using a single pass through the string. Instead of keeping track of characters and their indices, I could just iterate through the string once and update the `result` stringbuilder accordingly. This way, I could handle all three operations just by examining the current character and updating the `result` stringbuilder accordingly.

**Complexity**

The time complexity of this solution is O(n), where n is the length of the string s. This is because we iterate through the string only once. The space complexity is also O(n), because we are building a result stringbuilder of length n.

**Key Takeaway**

This problem taught me that sometimes, even though there might be multiple solutions, there might be a simpler and more elegant solution that relies on a single pass through the input. Always think about how you can iterate through the input only once to lower the time complexity.