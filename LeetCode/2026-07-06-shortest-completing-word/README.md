# Shortest Completing Word

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/shortest-completing-word/)
- **Date**: 2026-07-06
- **Language**: java


**The Problem**

Given a list of words and a license plate, find the shortest completing word among the given words. A completing word should be a word that forms a valid license plate when appended to the license plate.

**Initial Thoughts**

This problem seems straightforward: iterate through the words, check if each word forms a valid license plate with the given one, and return the shortest one. However, the time complexity of checking if a word forms a valid license plate seems to be O(m*n) where m is the length of the word and n is the length of the license plate. This is not acceptable as it will lead to a TLE.

**The Core Trick**

To optimize the time complexity, we can first compute the frequency of characters in the license plate and then iterate through the words to check if each word forms a valid license plate. If a word forms a valid license plate, we check if the length of the word is shorter than the minimum length found so far. This will significantly reduce the time complexity to O(n*m).

**Complexity**

Time complexity: O(n*m) where n is the number of words and m is the maximum length of a word. We are iterating through the words and the license plate once.
Space complexity: O(m) for storing the frequency of characters in the license plate.

**Key Takeaway**

Even though this problem seems simple at first, it can be optimized using the core trick mentioned above. Always consider optimizing the time complexity when dealing with such problems to avoid TLE.