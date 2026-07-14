class Solution {
    // Time complexity: O(m * n)
    // Space complexity: O(m * n)
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        k %= n;
        
        for (int i = 0; i < m; i++) {
            int[] row = mat[i];
            int[] shiftedRow = new int[n];
            for (int j = 0; j < n; j++) {
                shiftedRow[(j + (i % 2 == 0 ? -k : k) + n) % n] = row[j];
            }
            for (int j = 0; j < n; j++) {
                if (row[j] != shiftedRow[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}