class Solution {
    // Time complexity: O(m * n * log(m * n)) where m is the number of rows and n is the number of columns
    // Space complexity: O(m * n)
    public int latestDayToCross(int row, int col, int[][] cells) {
        int low = 1, high = cells.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canCross(row, col, cells, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    private boolean canCross(int row, int col, int[][] cells, int day) {
        boolean[][] grid = new boolean[row][col];
        for (int i = 0; i < day; i++) {
            grid[cells[i][0] - 1][cells[i][1] - 1] = true;
        }
        for (int j = 0; j < col; j++) {
            if (dfs(grid, 0, j, row, col)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(boolean[][] grid, int i, int j, int row, int col) {
        if (i == row - 1) {
            return true;
        }
        if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j]) {
            return false;
        }
        grid[i][j] = true;
        return dfs(grid, i - 1, j, row, col) || dfs(grid, i + 1, j, row, col) || dfs(grid, i, j - 1, row, col) || dfs(grid, i, j + 1, row, col);
    }
}