class Solution {
    // Time complexity: O(n), where n is the number of elements in the array.
    // Space complexity: O(1), as we only use a constant amount of space.
    public int maximumDifference(int[] nums) {
        int min = nums[0];
        int maxDiff = -1;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > min) {
                maxDiff = Math.max(maxDiff, nums[i] - min);
            } else {
                min = nums[i];
            }
        }
        
        return maxDiff;
    }
}