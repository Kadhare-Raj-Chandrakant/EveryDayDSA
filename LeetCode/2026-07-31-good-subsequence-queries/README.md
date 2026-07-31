# Good Subsequence Queries

- **Difficulty**: Hard
- **Source**: [Alt-Leetcode](https://leetcode.com/problems/good-subsequence-queries/)
- **Date**: 2026-07-31
- **Language**: java


I recently solved a LeetCode problem called "Good Subsequence Queries" which required optimizing the given code. The original solution had a time complexity of O(n * log^2(max(nums))) and a space complexity of O(n * log(max(nums))) due to the use of brute force methods.

My approach was to first find all prime factors of the given numbers. Then, for each query, I updated the prime factors array based on the new number and checked if any subsequence had the required unique prime factors to be considered a "good subsequence."

Here's the key takeaway: Instead of using brute force, I optimized the solution by using a sieve algorithm to find all prime numbers up to the maximum number in the array. The resulting primes array was then used to efficiently find prime factors for each number in the array and to check for "good subsequences" during queries.

This approach significantly improved the time complexity to O(n * log^2(max(nums)) + q * log(max(nums))), and the space complexity to O(n * log(max(nums))), making it much more efficient for large datasets.