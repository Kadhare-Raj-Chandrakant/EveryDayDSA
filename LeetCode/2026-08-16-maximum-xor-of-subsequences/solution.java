class Solution {
    // Time complexity: O(n log n) where n is the number of elements in nums
    // Space complexity: O(n)
    public int maxXorSubsequences(int[] nums) {
        int n = nums.length;
        int[] basis = new int[30];
        int max = 0;
        
        for (int num : nums) {
            int curr = 0;
            for (int i = 29; i >= 0; i--) {
                if ((num & (1 << i)) != 0) {
                    if (basis[i] == 0) {
                        basis[i] = num;
                        break;
                    } else {
                        curr = Math.max(curr, curr ^ basis[i]);
                    }
                }
            }
            max = Math.max(max, curr);
        }
        
        return max;
    }
}