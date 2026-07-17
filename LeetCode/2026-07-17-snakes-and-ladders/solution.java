class Solution {
    // Time complexity: O(n^2), Space complexity: O(n^2)
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[][] visited = new boolean[n][n];
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{n - 1, 0, 0});
        visited[n - 1][0] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0], col = curr[1], step = curr[2];
            int label = getLabel(board, row, col, n);
            if (label == n * n) return step;

            for (int i = 1; i <= 6; i++) {
                int nextLabel = Math.min(label + i, n * n);
                int[] next = getCoordinates(board, nextLabel, n);
                if (next[0] == -1) continue;
                int nextRow = next[0], nextCol = next[1];
                if (visited[nextRow][nextCol]) continue;
                visited[nextRow][nextCol] = true;
                if (board[nextRow][nextCol] != -1) {
                    next = getCoordinates(board, board[nextRow][nextCol], n);
                    nextRow = next[0]; nextCol = next[1];
                }
                queue.offer(new int[]{nextRow, nextCol, step + 1});
            }
        }
        return -1;
    }

    private int getLabel(int[][] board, int row, int col, int n) {
        if ((n - row - 1) % 2 == 0) return (n - row - 1) * n + col + 1;
        else return (n - row - 1) * n + (n - col - 1);
    }

    private int[] getCoordinates(int[][] board, int label, int n) {
        int row = n - (label - 1) / n - 1;
        int col = (label - 1) % n;
        if ((n - row - 1) % 2 == 1) col = n - col - 1;
        return new int[]{row, col};
    }
}