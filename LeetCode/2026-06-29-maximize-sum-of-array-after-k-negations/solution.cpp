class Solution {
public:
    // Time complexity: O(n log n) due to sorting
    // Space complexity: O(1) excluding input space
    int largestSumAfterKNegations(vector<int>& nums, int k) {
        // Sort the array in ascending order
        sort(nums.begin(), nums.end());
        
        // Negate the smallest k elements
        for (int i = 0; i < k; i++) {
            nums[i] = -nums[i];
        }
        
        // If k is odd, negate the smallest element again to maximize the sum
        if (k % 2 != 0) {
            nums[0] = -nums[0];
        }
        
        // Calculate the sum of the array
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        return sum;
    }
};