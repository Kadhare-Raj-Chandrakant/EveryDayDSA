class Solution {
    // Time complexity: O(m * n)
    // Space complexity: O(m * n)
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int count = 0;

        // Mark all land cells connected to the boundary as visited
        for (int i = 0; i < m; i++) {
            dfs(grid, i, 0, directions);
            dfs(grid, i, n - 1, directions);
        }
        for (int j = 0; j < n; j++) {
            dfs(grid, 0, j, directions);
            dfs(grid, m - 1, j, directions);
        }

        // Count all unvisited land cells
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int[][] grid, int i, int j, int[][] directions) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0; // Mark as visited
        for (int[] direction : directions) {
            dfs(grid, i + direction[0], j + direction[1], directions);
        }
    }
}