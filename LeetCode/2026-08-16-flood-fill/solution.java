class Solution {
    // Time complexity: O(m * n) where m and n are the dimensions of the image
    // Space complexity: O(m * n) due to recursive call stack
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image;
        dfs(image, sr, sc, image[sr][sc], color);
        return image;
    }

    private void dfs(int[][] image, int r, int c, int oldColor, int newColor) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != oldColor) {
            return;
        }
        image[r][c] = newColor;
        dfs(image, r - 1, c, oldColor, newColor);
        dfs(image, r + 1, c, oldColor, newColor);
        dfs(image, r, c - 1, oldColor, newColor);
        dfs(image, r, c + 1, oldColor, newColor);
    }
}