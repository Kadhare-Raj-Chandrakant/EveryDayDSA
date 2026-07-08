// Time complexity: O(n^2) where n is the number of vertices
// Space complexity: O(n) where n is the number of vertices
class Solution {
    public int[] findDegrees(int[][] matrix) {
        int n = matrix.length;
        int[] degrees = new int[n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    degrees[i]++;
                }
            }
        }
        
        return degrees;
    }
}