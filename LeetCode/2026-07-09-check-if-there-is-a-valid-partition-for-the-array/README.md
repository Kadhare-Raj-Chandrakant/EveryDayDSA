# Check if There is a Valid Partition For The Array

- **Difficulty**: Medium
- **Source**: [Alt-Leetcode](https://leetcode.com/problems/check-if-there-is-a-valid-partition-for-the-array/)
- **Date**: 2026-07-09
- **Language**: java


The problem I solved today was to check if there is a valid partition for an array, where valid means each element occurs at most once and there is no element missing. I came across this problem on LeetCode. Here's my solution code in Java:

```java
public boolean validPartition(int[] nums) {
    int n = nums.length;
    boolean[] dp = new boolean[n + 1];
    dp[0] = true;
    for (int i = 1; i <= n; i++) {
        if (i >= 2 && nums[i - 1] == nums[i - 2]) {
            dp[i] = dp[i] || dp[i - 2];
        }
        if (i >= 3 && nums[i - 1] == nums[i - 2] && nums[i - 2] == nums[i - 3]) {
            dp[i] = dp[i] || dp[i - 3];
        }
        if (i >= 3 && nums[i - 1] - nums[i - 2] == 1 && nums[i - 2] - nums[i - 3] == 1) {
            dp[i] = dp[i] || dp[i - 3];
        }
    }
    return dp[n];
}
```

Initial Thoughts: This problem seemed challenging at first because it required me to think about a valid partition, which I wasn't sure how to define. I tried a brute-force approach by checking all possible partitions and verifying if each element occurred at most once. However, this approach would be extremely time-consuming and inefficient when dealing with large arrays.

The Core Trick: The key observation here is that a valid partition can be constructed by repeatedly removing the longest consecutive sequence of equal elements that is still a valid partition. This means that if we can check if an array has a valid partition, we can also check if it has a longest consecutive sequence of equal elements.

Complexity: The time complexity of this solution is O(n), as we only iterate through the array once. The space complexity is also O(n), as we use a boolean array dp with size n + 1 to store our results.

Key Takeaway: This problem taught me the importance of thinking carefully about the problem definition and finding the core trick or insight that enables a more efficient solution.