class Solution {
    private static final int MOD = 1_000_000_007;

    // Time complexity: O(n)
    // Space complexity: O(n)
    public int numDecodings(String s) {
        int n = s.length();
        long[] dp = new long[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
                if (s.charAt(i - 1) == '*') {
                    dp[i] *= 9;
                }
            }
            if (i > 1) {
                char a = s.charAt(i - 2);
                char b = s.charAt(i - 1);
                if (a == '1' || (a == '2' && b <= '6')) {
                    dp[i] += dp[i - 2];
                    if (a == '*' && b == '*') {
                        dp[i] += 15 * dp[i - 2];
                    } else if (a == '*') {
                        dp[i] += 2 * dp[i - 2];
                    } else if (b == '*') {
                        dp[i] += 9 * dp[i - 2];
                    }
                }
            }
            dp[i] %= MOD;
        }
        return (int) dp[n];
    }
}