class Solution {
    // Time complexity: O(1) since the input size is constant
    // Space complexity: O(1) since the space used does not grow with the input size
    public int minimumMoves(int[][] grid) {
        int a = 0, b = 0;
        for (int[] row : grid) {
            for (int cell : row) {
                if (cell > 1) a++;
                else if (cell == 0) b++;
            }
        }
        int res = 0;
        for (int i = 0; i < b; i++) {
            res += Math.pow(3, a);
        }
        return res;
    }
}