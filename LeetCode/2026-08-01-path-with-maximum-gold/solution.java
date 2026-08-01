class Solution {
    // Time complexity: O(4^(m*n)) due to the maximum possible number of paths
    // Space complexity: O(m*n) for the recursion stack
    public int getMaximumGold(int[][] grid) {
        int maxGold = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    maxGold = Math.max(maxGold, dfs(grid, i, j, directions));
                }
            }
        }
        
        return maxGold;
    }
    
    private int dfs(int[][] grid, int i, int j, int[][] directions) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        
        int temp = grid[i][j];
        grid[i][j] = 0;
        
        int maxGold = temp;
        for (int[] direction : directions) {
            maxGold = Math.max(maxGold, temp + dfs(grid, i + direction[0], j + direction[1], directions));
        }
        
        grid[i][j] = temp;
        
        return maxGold;
    }
}