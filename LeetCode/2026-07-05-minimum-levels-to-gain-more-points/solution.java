class Solution {
    // Time complexity: O(n), Space complexity: O(1)
    public int minimumLevels(int[] possible) {
        int n = possible.length;
        int alice = 0, bob = 0;
        for (int i = 0; i < n; i++) {
            if (possible[i] == 0) possible[i] = -1;
            alice += possible[i];
            bob += possible[n - i - 1];
            if (alice > bob) return i + 1;
            bob -= possible[n - i - 1];
        }
        return -1;
    }
}