class Solution {
    // Time complexity: O(n * 2^n) where n is the length of nums
    // Space complexity: O(n)
    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length, max = 0, count = 0;
        for (int i = 1; i < (1 << n); i++) {
            int or = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    or |= nums[j];
                }
            }
            if (or > max) {
                max = or;
                count = 1;
            } else if (or == max) {
                count++;
            }
        }
        return count;
    }
}