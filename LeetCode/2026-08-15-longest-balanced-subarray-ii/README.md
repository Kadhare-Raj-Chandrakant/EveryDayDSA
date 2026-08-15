# Longest Balanced Subarray II

- **Difficulty**: Hard
- **Source**: [Leetcode](https://leetcode.com/problems/longest-balanced-subarray-ii/)
- **Date**: 2026-08-15
- **Language**: java


The problem I solved today was "Longest Balanced Subarray II" from LeetCode. The task required finding the longest subarray that has the same number of positive and negative numbers.

My initial thoughts were to try a brute-force approach, checking every possible subarray and computing the number of positive and negative numbers in each one. However, this solution would have a time complexity of O(n^2), which is too slow for large inputs.

After thinking some more, I realized that I could leverage a segment tree to efficiently update the number of positive and negative numbers in a given range. This would allow me to quickly find the rightmost index in the array where the sum of signs from the left to that index is zero, indicating a balanced subarray.

To implement this, I first initialized an array `pos` to store the first occurrence of each number in the array. Then, I created a segment tree with a size equal to the size of the array. I used this segment tree to efficiently update the number of positive and negative numbers in a given range, and to quickly find the rightmost index where the sum of signs from the left to that index is zero.

Finally, I iterated through the array from right to left, updating the segment tree and the `pos` array as I went, and updating the maximum balanced subarray length whenever I found a new one.

The key takeaway from this problem was the importance of thinking creatively when faced with a difficult problem, and leveraging data structures to efficiently solve it. In this case, the segment tree was a key tool that allowed me to efficiently update the number of positive and negative numbers in a given range, and to quickly find the rightmost index where the sum of signs from the left to that index is zero.