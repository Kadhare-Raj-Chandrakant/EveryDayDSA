class Solution {
    // Time complexity: O(n^3) where n is the length of nums
    // Space complexity: O(1)
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            int sum = 0;
            for (int j = i; j < nums.size(); j++) {
                sum += nums.get(j);
                if (j - i + 1 >= l && j - i + 1 <= r && sum > 0) {
                    minSum = Math.min(minSum, sum);
                }
            }
        }
        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }
}