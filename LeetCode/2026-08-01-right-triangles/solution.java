class Solution {
    // Time complexity: O(m * n)
    // Space complexity: O(m + n)
    public long numberOfRightTriangles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        
        // Count the number of 1s in each row and column
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }
        
        long res = 0;
        // For each cell with value 1, calculate the number of right triangles it can form
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res += (long) (row[i] - 1) * (col[j] - 1);
                }
            }
        }
        
        return res;
    }
}