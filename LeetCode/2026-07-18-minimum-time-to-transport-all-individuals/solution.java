class Solution {
    public double minTime(int n, int k, int m, int[] time, double[] mul) {
        // Time complexity: O(n * 2^n * m * k log(n * 2^n * m * k))
        // Space complexity: O(n * 2^n * m)
        int[][][] dp = new int[n + 1][1 << n][m];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < 1 << n; j++) {
                for (int l = 0; l < m; l++) {
                    dp[i][j][l] = Integer.MAX_VALUE;
                }
            }
        }
        dp[0][0][0] = 0;
        int[][][] pq = new int[n * (1 << n) * m][3];
        int pqSize = 0;
        pq[pqSize][0] = 0;
        pq[pqSize][1] = 0;
        pq[pqSize][2] = 0;
        pqSize++;
        while (pqSize > 0) {
            int[] top = pq[--pqSize];
            int people = top[0];
            int mask = top[1];
            int stage = top[2];
            if (pqSize > 0) {
                int[] next = pq[pqSize - 1];
                if (next[0] == top[0] && next[1] == top[1] && next[2] == top[2]) {
                    continue;
                }
            }
            for (int i = 1; i <= Math.min(people, k); i++) {
                int newMask = mask;
                int maxTime = 0;
                for (int j = 0; j < n; j++) {
                    if ((newMask & (1 << j)) > 0) {
                        maxTime = Math.max(maxTime, time[j]);
                        newMask ^= (1 << j);
                    }
                }
                int newStage = (stage + (int) (Math.floor(maxTime * mul[stage]) % m)) % m;
                if (dp[people - i][newMask][newStage] > dp[people][mask][stage] + (int) (Math.floor(maxTime * mul[stage]))) {
                    dp[people - i][newMask][newStage] = dp[people][mask][stage] + (int) (Math.floor(maxTime * mul[stage]));
                    pq[pqSize][0] = people - i;
                    pq[pqSize][1] = newMask;
                    pq[pqSize][2] = newStage;
                    pqSize++;
                }
                if (people - i > 0) {
                    int returnTime = time[(int) (Math.log(mask ^ newMask) / Math.log(2))];
                    int newStage2 = (stage + (int) (Math.floor(returnTime * mul[stage]) % m)) % m;
                    if (dp[people - i][mask][newStage2] > dp[people][mask][stage] + (int) (Math.floor(returnTime * mul[stage]))) {
                        dp[people - i][mask][newStage2] = dp[people][mask][stage] + (int) (Math.floor(returnTime * mul[stage]));
                        pq[pqSize][0] = people - i;
                        pq[pqSize][1] = mask;
                        pq[pqSize][2] = newStage2;
                        pqSize++;
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            ans = Math.min(ans, dp[0][0][i]);
        }
        if (ans == Integer.MAX_VALUE) {
            return -1.0;
        }
        return ans;
    }
}