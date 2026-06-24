class Solution {
public:
    // Time complexity: O(m * n * log(m * n))
    // Space complexity: O(m * n)
    int minOperations(vector<vector<int>>& grid, int x) {
        int m = grid.size(), n = grid[0].size();
        vector<int> nums;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums.push_back(grid[i][j]);
            }
        }
        sort(nums.begin(), nums.end());
        int median = nums[m * n / 2];
        int res = 0;
        for (int num : nums) {
            if (abs(num - median) % x != 0) return -1;
            res += abs(num - median) / x;
        }
        return res;
    }
};