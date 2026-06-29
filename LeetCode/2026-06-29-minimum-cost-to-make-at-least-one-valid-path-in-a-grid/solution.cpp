class Solution {
public:
    // Time complexity: O(m * n)
    // Space complexity: O(m * n)
    int minCost(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        vector<vector<int>> dp(m, vector<int>(n, INT_MAX));
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        dp[0][0] = 0;
        queue<pair<int, int>> q;
        q.push({0, 0});
        while (!q.empty()) {
            int x = q.front().first;
            int y = q.front().second;
            q.pop();
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int nx = x + directions[i][0];
                int ny = y + directions[i][1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                int cost = (grid[x][y] != i + 1) ? 1 : 0;
                if (dp[x][y] + cost < dp[nx][ny]) {
                    dp[nx][ny] = dp[x][y] + cost;
                    if (!visited[nx][ny]) {
                        q.push({nx, ny});
                    }
                }
            }
        }
        return dp[m - 1][n - 1];
    }
};