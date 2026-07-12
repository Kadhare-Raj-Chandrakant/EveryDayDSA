class Solution {
    // Time complexity: O(n^2)
    // Space complexity: O(n^2)
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + stoneValue[i];
        }
        
        int[][] dp = new int[n][n];
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i + length - 1 < n; i++) {
                int j = i + length - 1;
                int sum = prefixSum[j + 1] - prefixSum[i];
                if (length == 2) {
                    dp[i][j] = Math.min(stoneValue[i], stoneValue[j]);
                } else {
                    int lower = i;
                    int upper = j;
                    while (lower + 1 < upper) {
                        int mid = (lower + upper) / 2;
                        int leftSum = prefixSum[mid + 1] - prefixSum[i];
                        int rightSum = sum - leftSum;
                        if (leftSum < rightSum) {
                            lower = mid;
                        } else if (leftSum > rightSum) {
                            upper = mid;
                        } else {
                            dp[i][j] = Math.max(dp[i][mid] + leftSum, dp[mid + 1][j] + leftSum);
                            break;
                        }
                    }
                    if (lower + 1 == upper) {
                        int leftSum = prefixSum[lower + 1] - prefixSum[i];
                        int rightSum = sum - leftSum;
                        if (leftSum < rightSum) {
                            dp[i][j] = dp[i][lower] + leftSum;
                        } else if (leftSum > rightSum) {
                            dp[i][j] = dp[upper][j] + rightSum;
                        } else {
                            dp[i][j] = Math.max(dp[i][lower] + leftSum, dp[upper][j] + rightSum);
                        }
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}