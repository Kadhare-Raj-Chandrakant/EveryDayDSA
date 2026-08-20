class Solution {
    // Time complexity: O(m*n), where m is the number of rows and n is the number of columns in the image.
    // Space complexity: O(m*n), where m is the number of rows and n is the number of columns in the image.
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] smoothedImg = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                int count = 0;
                
                for (int x = Math.max(0, i - 1); x <= Math.min(m - 1, i + 1); x++) {
                    for (int y = Math.max(0, j - 1); y <= Math.min(n - 1, j + 1); y++) {
                        sum += img[x][y];
                        count++;
                    }
                }
                
                smoothedImg[i][j] = sum / count;
            }
        }
        
        return smoothedImg;
    }
}