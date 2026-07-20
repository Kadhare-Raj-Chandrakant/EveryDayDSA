class Solution {
    // Time complexity: O(n log n) due to sorting
    // Space complexity: O(1) as we only use a constant amount of space
    public int maximizeExpressionOfThree(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n - 1] + nums[n - 2] - nums[0];
    }
}