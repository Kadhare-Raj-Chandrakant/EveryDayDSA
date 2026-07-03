# Encrypt and Decrypt Strings

- **Difficulty**: Hard
- **Source**: [Leetcode](https://leetcode.com/problems/encrypt-and-decrypt-strings/)
- **Date**: 2026-07-03
- **Language**: cpp


**The Problem**

Encrypt and decrypt strings, creating a mapping between characters and their encodings,
and then using a dictionary to decrypt the encoded strings.

**Initial Thoughts**

Initially, I thought of using a brute-force approach to create the character-encoding map. But it wouldn't work because the keys were repeated in the dictionary. I also considered using a hash map to map strings to integers, but it wouldn't help since we need to map integers back to strings.

**The Core Trick**

The core trick was to use a combination of two hash maps: one for mapping characters to their encodings, and another for mapping encodings back to integers. This way, we can easily map and unmap back encodings without worrying about the original characters.

**Complexity**

Time complexity: O(n) for both encryption and decryption. Space complexity: O(min(n, m)) where n is the length of the dictionary, and m is the length of the input string.

**Key Takeaway**

To solve problems like this, think about using hash maps and consider creating two separate maps for different operations.