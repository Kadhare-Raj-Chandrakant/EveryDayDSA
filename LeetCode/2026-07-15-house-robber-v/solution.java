class Solution {
    // Time complexity: O(n)
    // Space complexity: O(n)
    public long rob(int[] nums, int[] colors) {
        int n = nums.length;
        long[] dp = new long[n];
        
        dp[0] = nums[0];
        if (n == 1) return dp[0];
        
        dp[1] = Math.max(nums[0], nums[1]);
        if (n == 2) return dp[1];
        
        for (int i = 2; i < n; i++) {
            if (colors[i] != colors[i - 1]) {
                dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 1]);
            }
            dp[i] = Math.max(dp[i], nums[i] + dp[i - 2]);
        }
        
        return dp[n - 1];
    }
}