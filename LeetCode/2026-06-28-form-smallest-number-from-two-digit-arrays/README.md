# Form Smallest Number From Two Digit Arrays

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/form-smallest-number-from-two-digit-arrays/)
- **Date**: 2026-06-28
- **Language**: cpp


Problem: Form Smallest Number From Two Digit Arrays

The problem asks to form the smallest possible number by concatenating the elements of two sorted arrays, each containing only 1's and 2's. This is an interesting problem because it requires us to consider the order of these elements and how they will be arranged in the final result.

Initial Thoughts:

At first, I thought about brute-forcing all possible combinations of the elements in both arrays. But then I realized that this approach would be too slow. Instead, I decided to sort both arrays and then iterate through them, comparing and concatenating the elements based on their order.

The Core Trick:

The key idea is that if two elements are equal (i.e., they represent the same digit), we need to compare them based on their position in the sorted arrays. For example, if we have [1, 1, 2] and [2, 2, 1], we should consider the first 1 in the first array as smaller than the first 2 in the second array, even though they are both represented as 1.

Complexity:

The time complexity of this solution is O(n log n), where n is the total number of elements in both arrays, because we need to sort both arrays. The space complexity is O(1), excluding the input space, as we are not using any additional data structures for this problem.

Key Takeaway:

When dealing with problems that involve comparing and concatenating elements based on their order, it's essential to consider the order of elements and how they will be arranged in the final result. This problem also highlights the importance of careful implementation details, such as handling equal elements and considering their position in the sorted arrays.