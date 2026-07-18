class Solution {
    // Time complexity: O(n), where n is the length of the input array
    // Space complexity: O(1), as we only use a constant amount of space
    public int minOperations(int[] nums) {
        int operations = 0;
        int prev = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= prev) {
                operations += prev + 1 - nums[i];
                prev = prev + 1;
            } else {
                prev = nums[i];
            }
        }
        
        return operations;
    }
}