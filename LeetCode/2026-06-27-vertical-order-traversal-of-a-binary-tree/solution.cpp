class Solution {
public:
    // Time complexity: O(N log N) due to sorting
    // Space complexity: O(N) for storing the result
    vector<vector<int>> verticalTraversal(TreeNode* root) {
        if (!root) return {};

        map<int, map<int, vector<int>>> columnTable;
        int minColumn = 0, maxColumn = 0;
        queue<pair<TreeNode*, int>> q;
        q.push({root, 0});

        while (!q.empty()) {
            int size = q.size();
            map<int, vector<int>> columnToNodes;

            for (int i = 0; i < size; i++) {
                auto node = q.front().first;
                int column = q.front().second;
                q.pop();

                if (node) {
                    columnToNodes[column].push_back(node->val);
                    minColumn = min(minColumn, column);
                    maxColumn = max(maxColumn, column);

                    q.push({node->left, column - 1});
                    q.push({node->right, column + 1});
                }
            }

            for (auto& column : columnToNodes) {
                sort(column.second.begin(), column.second.end());
                for (int node : column.second) {
                    columnTable[column.first][columnTable[column.first].size()].push_back(node);
                }
            }
        }

        vector<vector<int>> result;
        for (int i = minColumn; i <= maxColumn; i++) {
            vector<int> column;
            for (auto& row : columnTable[i]) {
                for (int node : row.second) {
                    column.push_back(node);
                }
            }
            result.push_back(column);
        }

        return result;
    }
};