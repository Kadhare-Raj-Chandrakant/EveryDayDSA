# K-th Smallest Remaining Even Integer in Subarray Queries

- **Difficulty**: Hard
- **Source**: [Leetcode](https://leetcode.com/problems/k-th-smallest-remaining-even-integer-in-subarray-queries/)
- **Date**: 2026-08-15
- **Language**: java


The problem I solved today was "K-th Smallest Remaining Even Integer in Subarray Queries," a relatively challenging exercise from LeetCode. It required finding the K-th smallest even integer among the remaining even integers within a given subarray in each query.

My initial thoughts on this problem were that I might need to sort the even integers in each subarray and then select the K-th element from the sorted array. However, this approach would have a time complexity of O(n^2 * log(max_value)) due to the sorting step, which would be too slow for large inputs.

The core trick that made this problem interesting was to notice that we could efficiently count the number of remaining even integers in each subarray using a binary search-like approach without actually sorting the elements. This allowed me to reduce the time complexity to O(n * q * log(max_value)), which is still quite efficient for large inputs and queries.

The complexity analysis for my solution is as follows: for each query, we need to perform a binary search-like operation to count the number of remaining even integers in the subarray. Since we perform this operation for all n subarrays and q queries, the overall time complexity is O(n * q * log(max_value)). The space complexity is O(1), excluding the space required for the output array.

A key takeaway from this problem is the importance of analyzing the problem structure and identifying patterns that can lead to more efficient solutions. By thinking creatively and leveraging the problem constraints, I was able to solve this challenging question in a reasonable amount of time.