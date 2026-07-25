# Find the K-Sum of an Array

- **Difficulty**: Hard
- **Source**: [Leetcode](https://leetcode.com/problems/find-the-k-sum-of-an-array/)
- **Date**: 2026-07-25
- **Language**: java


Problem: Given an array of integers `nums` and a target integer `k`, find all unique `k`-sum combinations that add up to the target. The combinations should be sorted lexicographically.

My solution code:

```java
class Solution {
    // Time complexity: O(n * k * log(k)) where n is the length of nums
    // Space complexity: O(k)
    public List<List<Long>> kSum(int[] nums, int k) {
        List<List<Long>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, k, 0, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, int k, int start, long sum, List<Long> curr, List<List<Long>> res) {
        if (sum == 0) res.add(new ArrayList<>(curr));
        if (sum < 0 || start >= nums.length) return;

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue; // avoid duplicates
            curr.add(nums[i]);
            dfs(nums, k, i + 1, sum - nums[i], curr, res);
            curr.remove(curr.size() - 1); // backtracking
        }
    }
}
```

**Key Takeaway:** This problem is a classic example of a backtracking algorithm. We sort the array to ensure uniqueness and then start a recursive call with a helper method. The helper method keeps tracking the current combination, its sum, and the position of the next candidate. If the sum is zero, it means we've found a valid combination, so we add it to the result list and backtrack by removing the last element from the current combination.

The complexity analysis is straightforward: time complexity is `O(n * k * log(k))` because we have `n` possible starting positions, `k` possible candidates for each position, and `log(k)` to sort candidates when we add them to the current combination (to avoid duplicates). Space complexity is also `O(k)` because we keep track of the current combination and its size.