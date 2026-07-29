class Solution {
    // Time complexity: O(n * numCarpets * carpetLen)
    // Space complexity: O(n * numCarpets)
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        int n = floor.length();
        int[][] dp = new int[n + 1][numCarpets + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= numCarpets; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            int white = 0;
            for (int j = i - 1; j >= 0 && j >= i - carpetLen; j--) {
                white += floor.charAt(j) - '0';
            }
            for (int j = 0; j <= numCarpets; j++) {
                if (i - carpetLen - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + (floor.charAt(i - 1) - '0'));
                    if (j > 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - carpetLen][j - 1] + white);
                    }
                } else {
                    dp[i][j] = dp[i - 1][j] + (floor.charAt(i - 1) - '0');
                }
            }
        }
        return dp[n][numCarpets];
    }
}