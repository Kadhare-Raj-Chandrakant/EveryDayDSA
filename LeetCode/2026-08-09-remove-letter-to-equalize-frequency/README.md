# Remove Letter To Equalize Frequency

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/remove-letter-to-equalize-frequency/)
- **Date**: 2026-08-09
- **Language**: java


The problem I solved today was to remove a letter to equalize the frequency of each character in a given string. Although it sounds simple, I initially thought of brute-force methods that would take O(n^2) time complexity. I then realized that I could iterate through the string with a sliding window and update the frequencies of the characters. This solution had a time complexity of O(n) and space complexity of O(1).

The core trick in this problem is that you need to find a letter that appears more frequently than any other letter in the string. Then, remove that letter and check if the remaining letters have equal frequencies. If they do, the string can be equalized. If not, we need to remove another letter. This process continues until only one letter or one frequency remains.

The key takeaway from this problem is to think creatively about the constraints and constraints within the constraints. In this case, the constraints were that the function should have a time complexity of O(n) and a space complexity of O(1). I also learned that thinking about frequency equalization can be a powerful approach to solving problems, even if they seem simple at first glance.