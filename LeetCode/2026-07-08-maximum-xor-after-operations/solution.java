class Solution {
    // Time complexity: O(n log n)
    // Space complexity: O(n)
    public int maximumXOR(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res |= num;
        }
        return res;
    }
}