class Solution {
    // Time complexity: O(n*m) where n is the length of nums and m is the length of pattern
    // Space complexity: O(1)
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int count = 0;
        for (int i = 0; i <= nums.length - pattern.length - 1; i++) {
            boolean match = true;
            for (int j = 0; j < pattern.length; j++) {
                if (pattern[j] == 1 && nums[i + j] >= nums[i + j + 1]) {
                    match = false;
                    break;
                } else if (pattern[j] == 0 && nums[i + j] != nums[i + j + 1]) {
                    match = false;
                    break;
                } else if (pattern[j] == -1 && nums[i + j] <= nums[i + j + 1]) {
                    match = false;
                    break;
                }
            }
            if (match) {
                count++;
            }
        }
        return count;
    }
}