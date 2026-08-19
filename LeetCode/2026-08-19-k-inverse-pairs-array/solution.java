class Solution {
    // Time complexity: O(n * k)
    // Space complexity: O(n * k)
    public int kInversePairs(int n, int k) {
        final int MOD = 1000000007;
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 2; i <= n; i++) {
            int[] sum = new int[k + 1];
            sum[0] = 1;
            for (int j = 1; j <= k; j++) {
                int limit = Math.min(j, i - 1);
                for (int x = 1; x <= limit; x++) {
                    sum[j] = (sum[j] + sum[j - x]) % MOD;
                }
                dp[i][j] = sum[j];
            }
        }
        return dp[n][k];
    }
}