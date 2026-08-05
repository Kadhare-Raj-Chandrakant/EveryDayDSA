class Solution {
    // Time complexity: O(n)
    // Space complexity: O(1)
    public long incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        int x = 0;
        while (x < n - 1 && nums[x] < nums[x + 1]) x++;
        
        int y = n - 1;
        while (y > 0 && nums[y - 1] < nums[y]) y--;
        
        long res = 0;
        int j = y;
        for (int i = 0; i <= x; i++) {
            while (j < n && (i == 0 || nums[i - 1] >= nums[j])) j++;
            res += n - j + 1;
        }
        return res;
    }
}