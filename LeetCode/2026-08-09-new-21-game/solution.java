class Solution {
    // Time complexity: O(n)
    // Space complexity: O(n)
    public double new21Game(int n, int k, int maxPts) {
        if (k == 0) return 1;
        double[] dp = new double[n + 1];
        dp[0] = 1;
        double sum = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = sum / maxPts;
            if (i < k) sum += dp[i];
            if (i - maxPts >= 0) sum -= dp[i - maxPts];
        }
        double res = 0;
        for (int i = k; i <= n; i++) res += dp[i];
        return res;
    }
}