class Solution {
    // Time complexity: O(m*n)
    // Space complexity: O(m+n)
    public List<Integer> luckyNumbers(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[] rowMins = new int[m];
        int[] colMaxs = new int[n];
        
        // Initialize rowMins and colMaxs with Integer.MAX_VALUE and Integer.MIN_VALUE respectively
        for (int i = 0; i < m; i++) {
            rowMins[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < n; i++) {
            colMaxs[i] = Integer.MIN_VALUE;
        }
        
        // Find the minimum of each row and maximum of each column
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowMins[i] = Math.min(rowMins[i], matrix[i][j]);
                colMaxs[j] = Math.max(colMaxs[j], matrix[i][j]);
            }
        }
        
        // Find the lucky numbers
        List<Integer> luckyNumbers = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == rowMins[i] && matrix[i][j] == colMaxs[j]) {
                    luckyNumbers.add(matrix[i][j]);
                }
            }
        }
        
        return luckyNumbers;
    }
}