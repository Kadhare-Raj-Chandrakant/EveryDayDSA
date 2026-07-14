class Solution {
    // Time complexity: O(n), where n is the length of the input array
    // Space complexity: O(1), as we only use a constant amount of space
    public int minOperations(int[] nums) {
        int operations = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                operations++;
            }
        }
        return operations;
    }
}