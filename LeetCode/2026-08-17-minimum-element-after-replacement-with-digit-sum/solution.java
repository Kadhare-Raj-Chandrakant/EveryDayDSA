class Solution {
    // Time complexity: O(n * log(m)), where n is the length of nums and m is the maximum number in nums
    // Space complexity: O(1)
    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            min = Math.min(min, sum);
        }
        return min;
    }
}