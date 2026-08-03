# Minimum Possible Integer After at Most K Adjacent Swaps On Digits

- **Difficulty**: Hard
- **Source**: [Alt-Leetcode](https://leetcode.com/problems/minimum-possible-integer-after-at-most-k-adjacent-swaps-on-digits/)
- **Date**: 2026-08-03
- **Language**: java


Problem: Given a string `num` and an integer `k`, find the minimum possible integer formed by adjacent swaps on its digits. For example, if `num = "1234"`, `k = 2`, and the swaps are performed as "23", "41", "32", we get "2134". The minimum possible integer is "2134".

Initial Thoughts: This problem seems challenging due to the dynamic and recursive nature of the swaps. Initially, I tried implementing a brute-force solution, where I would swap each pair of adjacent digits until the number of swaps reached `k`. However, this solution has a time complexity of O(n^2 * k), which is not efficient enough for large values of `k`.

The Core Trick: I realized that the problem can be solved by maintaining a list of indices of each digit, and swapping the digit at index `i` with the digit at index `i + k - 1` (mod n), as long as the difference between `i` and `i + k - 1` is less than or equal to `k`. This trick allows me to avoid swapping elements that are not adjacent and reduces the time complexity to O(n^2 * k).

Complexity: The time complexity is O(n^2 * k) due to the nested loops in the solution. The space complexity is O(n) to store the digits and indices.

Key Takeaway: This problem demonstrates the importance of considering the constraints and time complexity of a solution when designing it. In this case, the initial brute-force solution was too complex and inefficient, but the core trick allowed me to find an elegant and efficient solution.