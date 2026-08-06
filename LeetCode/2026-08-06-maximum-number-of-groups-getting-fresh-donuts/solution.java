class Solution {
    public int maxHappyGroups(int batchSize, int[] groups) {
        // Time complexity: O(n * batchSize * batchSize)
        // Space complexity: O(batchSize * batchSize)
        int[] freq = new int[batchSize];
        for (int g : groups) {
            freq[g % batchSize]++;
        }
        
        int[][] dp = new int[batchSize][batchSize];
        for (int i = 0; i < batchSize; i++) {
            dp[i][i] = freq[i];
        }
        
        int ans = 0;
        for (int i = 0; i < batchSize; i++) {
            for (int j = 0; j < batchSize; j++) {
                if (freq[j] > 0) {
                    freq[j]--;
                    for (int k = 0; k < batchSize; k++) {
                        dp[i][(i + k) % batchSize] = Math.max(dp[i][(i + k) % batchSize], dp[j][k] + 1);
                    }
                    freq[j]++;
                }
            }
            ans = Math.max(ans, dp[i][0]);
        }
        
        return ans;
    }
}