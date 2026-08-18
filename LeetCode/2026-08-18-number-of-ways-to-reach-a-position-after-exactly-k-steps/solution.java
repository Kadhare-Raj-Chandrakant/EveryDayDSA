class Solution {
    // Time complexity: O(1)
    // Space complexity: O(1)
    public int numberOfWays(int startPos, int endPos, int k) {
        int diff = Math.abs(endPos - startPos);
        if (diff > k) return 0;
        if ((k - diff) % 2 != 0) return 0;
        int steps = (k + diff) / 2;
        long res = 1;
        for (int i = 1; i <= steps; i++) {
            res = res * (k - i + 1) / i;
            res %= 1000000007;
        }
        return (int) res;
    }
}