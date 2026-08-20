class Solution {
    // Time complexity: O(2^n * n log n) due to sorting and recursion
    // Space complexity: O(2^n * n) for recursion stack and storing subsets
    public int[] recoverArray(int n, int[] sums) {
        Arrays.sort(sums);
        int[] ans = new int[n];
        dfs(sums, 0, ans, 0);
        return ans;
    }

    private boolean dfs(int[] sums, int idx, int[] ans, int pos) {
        if (idx == sums.length / 2) {
            System.arraycopy(sums, 0, ans, pos, ans.length - pos);
            return true;
        }
        int max = sums[sums.length - 1 - idx];
        int[] diff = new int[sums.length - 1];
        for (int i = 0; i < sums.length - 1; i++) {
            diff[i] = sums[i + 1] - sums[i];
        }
        Arrays.sort(diff);
        int[] newSums = new int[sums.length - 1];
        for (int i = 0; i < sums.length - 1; i++) {
            newSums[i] = sums[i] + diff[i];
        }
        ans[pos] = max;
        if (dfs(newSums, idx + 1, ans, pos + 1)) return true;
        ans[pos] = -max;
        if (dfs(newSums, idx + 1, ans, pos + 1)) return true;
        return false;
    }
}