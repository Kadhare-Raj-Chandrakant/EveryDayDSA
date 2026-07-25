class Solution {
    // Time complexity: O(n * log(m)), where n is the number of elements in nums and m is the maximum value in nums
    // Space complexity: O(1)
    public int differenceOfSum(int[] nums) {
        int elementSum = 0;
        int digitSum = 0;
        
        for (int num : nums) {
            elementSum += num;
            while (num > 0) {
                digitSum += num % 10;
                num /= 10;
            }
        }
        
        return Math.abs(elementSum - digitSum);
    }
}