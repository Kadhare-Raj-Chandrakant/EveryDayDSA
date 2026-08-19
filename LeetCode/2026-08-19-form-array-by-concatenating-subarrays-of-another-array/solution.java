class Solution {
    // Time complexity: O(n * m * k) where n is the length of groups, m is the average length of groups[i], and k is the length of nums
    // Space complexity: O(m)
    public boolean canChoose(int[][] groups, int[] nums) {
        int n = groups.length, m = nums.length;
        int idx = 0;
        for (int[] group : groups) {
            int len = group.length;
            boolean found = false;
            for (int i = idx; i <= m - len; i++) {
                boolean match = true;
                for (int j = 0; j < len; j++) {
                    if (nums[i + j] != group[j]) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    idx = i + len;
                    found = true;
                    break;
                }
            }
            if (!found) return false;
        }
        return true;
    }
}