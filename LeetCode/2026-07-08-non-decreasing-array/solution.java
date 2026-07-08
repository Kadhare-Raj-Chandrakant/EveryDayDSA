class Solution {
    // Time complexity: O(n), Space complexity: O(1)
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
                if (count > 1) return false;
                if (i > 0 && i < nums.length - 2) {
                    if (nums[i - 1] > nums[i + 1] && nums[i] > nums[i + 2]) return false;
                }
            }
        }
        return true;
    }
}