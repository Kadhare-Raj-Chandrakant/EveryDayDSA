class Solution {
    private static final int MOD = (int) 1e9 + 7;
    private static final int MAX_DIGIT_SUM = 400;

    // Time complexity: O(1) (since n <= 10^4)
    // Space complexity: O(1) (since dp array size is fixed)
    public int count(String num1, String num2, int min_sum, int max_sum) {
        return f(num2, min_sum, max_sum) - f(num1, min_sum, max_sum) + (num1.equals(num2) ? 1 : 0);
    }

    private int f(String num, int min_sum, int max_sum) {
        int n = num.length();
        int[][][] dp = new int[n + 1][MAX_DIGIT_SUM + 1][2];
        dp[0][0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= MAX_DIGIT_SUM; j++) {
                for (int k = 0; k < 2; k++) {
                    for (int digit = 0; digit < 10; digit++) {
                        if (k == 1 && digit > num.charAt(i - 1) - '0') break;
                        if (k == 0 && digit < num.charAt(i - 1) - '0') continue;
                        int newSum = j + digit;
                        if (newSum > MAX_DIGIT_SUM) continue;
                        int newK = k | (digit < num.charAt(i - 1) - '0' ? 1 : 0);
                        dp[i][newSum][newK] = (dp[i][newSum][newK] + dp[i - 1][j][k]) % MOD;
                    }
                }
            }
        }

        int res = 0;
        for (int i = min_sum; i <= max_sum; i++) {
            for (int j = 0; j < 2; j++) {
                res = (res + dp[n][i][j]) % MOD;
            }
        }
        return res;
    }
}