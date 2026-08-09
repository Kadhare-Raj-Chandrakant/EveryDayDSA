# Bulls and Cows

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/bulls-and-cows/)
- **Date**: 2026-08-09
- **Language**: java


**The Problem**

Bulls and Cows is a code game where you're given a secret word and must guess it by revealing a guess word. For each guess, you get to know the number of bulls and cows. A bull is a letter in the guess that is in the correct position in the secret word, while a cow is a letter in the guess that is in the correct position in the secret word but not in the correct position in the guess. For example, if the secret word is "madam" and your guess is "madam", you get 4 bulls (all the letters match) and 0 cows.

**Initial Thoughts**

This problem seemed straightforward at first, but I struggled to come up with a solution that could handle all possible inputs and edge cases. I tried using a brute-force approach, where I compared each character in the secret word with each character in the guess, but that approach had a time complexity of O(n^2), which was too slow for large inputs.

**The Core Trick**

I eventually realized that the key to solving this problem efficiently was to count the occurrences of each letter in both the secret and guess strings. This allowed me to quickly determine which letters were bulls (where both the letter and its position matched) and which letters were cows (where the letter was in the correct position but not in the correct position in the guess).

**Complexity**

This solution has a time complexity of O(n), where n is the length of the secret word, because we are iterating through the secret string only once. The space complexity is O(1), as we are using a constant amount of space to store the counts of each letter in both the secret and guess strings.

**Key Takeaway**

One key takeaway from this problem is the importance of careful analysis and thinking through edge cases. Programming problems can often seem simple at first glance, but there are often unexpected complexities that can arise when you start to consider all possible inputs. By taking the time to carefully analyze and think through the problem, you can often find more efficient and elegant solutions.

---

I hope this dev journal entry helps to shed some light on how I approached this Bulls and Cows problem. Let me know if you have any questions or feedback!