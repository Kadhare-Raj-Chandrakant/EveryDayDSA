# Minimum Common Value

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/minimum-common-value/)
- **Date**: 2026-07-19
- **Language**: java


In today's coding session, I tackled the Minimum Common Value problem on LeetCode. Given two sorted arrays with unique elements, find the smallest element that appears in both arrays. This problem seems relatively straightforward, but its complexity can be misleading.

Initially, I tried a brute-force approach, which iterated through both arrays and compared elements until a common one was found. However, this solution has a time complexity of O(n \* m), where n and m are the lengths of the two input arrays. I thought about how to optimize it without resorting to sorting, which would increase the time complexity to O(n log n) due to the sorting operation.

After some thought, I realized that I could use a two-pointer approach. By maintaining two pointers at the beginning of both arrays, I could compare elements and move the pointers accordingly. If the current element in one array is smaller than the current element in the other array, increment the pointer of the smaller array. If they are equal, return the common element. This approach has a time complexity of O(min(n, m)), which is better than the brute-force approach.

Here's the Java code for the optimized solution:

```java
class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) return nums1[i];
            else if (nums1[i] < nums2[j]) i++;
            else j++;
        }
        return -1;
    }
}
```

In conclusion, this problem can be solved with a cleaner and more efficient approach than the first one I attempted. By using two pointers, I was able to optimize the time complexity of the problem to O(min(n, m)). This experience taught me the importance of considering the time complexity of a problem, even if the solution seems simple at first glance.