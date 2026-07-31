class Solution {
    // Time complexity: O(log n * k * 64)
    // Space complexity: O(log n * k)
    public long popcountDepth(long n, int k) {
        int[] depth = new int[64];
        for (int i = 0; i < 64; i++) {
            depth[i] = getDepth(i);
        }

        int len = Long.toBinaryString(n).length();
        long[][][] dp = new long[len + 1][64][2];
        dp[0][0][1] = 1;

        for (int i = 0; i < len; i++) {
            for (int ones = 0; ones < 64; ones++) {
                for (int tight = 0; tight < 2; tight++) {
                    for (int bit = 0; bit < 2; bit++) {
                        if (tight == 1 && bit > (n & 1)) {
                            break;
                        }
                        int newOnes = ones + bit;
                        int newTight = tight & (bit == (n & 1) ? 1 : 0);
                        dp[i + 1][newOnes][newTight] += dp[i][ones][tight];
                    }
                }
            }
            n >>= 1;
        }

        long res = 0;
        for (int ones = 0; ones < 64; ones++) {
            if (depth[ones] == k) {
                for (int tight = 0; tight < 2; tight++) {
                    res += dp[len][ones][tight];
                }
            }
        }
        return res;
    }

    private int getDepth(int x) {
        if (x == 1) {
            return 0;
        }
        return 1 + getDepth(Integer.bitCount(x));
    }
}