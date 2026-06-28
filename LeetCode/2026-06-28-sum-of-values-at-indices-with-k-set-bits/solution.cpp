class Solution {
public:
    // Time complexity: O(n * log n) where n is the length of nums
    // Space complexity: O(1)
    int sumIndicesWithKSetBits(vector<int>& nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            int count = 0;
            int j = i;
            while (j > 0) {
                j &= (j - 1);
                count++;
            }
            if (count == k) {
                sum += nums[i];
            }
        }
        return sum;
    }
};