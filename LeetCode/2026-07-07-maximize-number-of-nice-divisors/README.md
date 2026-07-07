# Maximize Number of Nice Divisors

- **Difficulty**: Hard
- **Source**: [Leetcode](https://leetcode.com/problems/maximize-number-of-nice-divisors/)
- **Date**: 2026-07-07
- **Language**: cpp


The problem I solved today was to maximize the number of nice divisors for a given integer. My solution used a clever trick based on modular arithmetic.

Initial Thoughts: I first tried a brute-force approach, which was too slow for large inputs. I then tried using the Sieve of Eratosthenes to find prime factors, but it was too slow and had a high space complexity.

The Core Trick: I realized that the number of nice divisors depends only on the prime factors of the number. So I could compute the number of nice divisors for each prime factor separately and then combine them using modular arithmetic.

Complexity: The time complexity of this solution is O(primeFactors), which is much faster than the brute-force approach. The space complexity is O(1), as no additional data structures are used.

Key Takeaway: This problem is a good example of how clever modular arithmetic tricks can be used to solve seemingly complex problems. It's important to think about the structure of the problem and how different components interact with each other to get a solution.