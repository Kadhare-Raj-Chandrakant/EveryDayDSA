class Solution {
    // Time complexity: O(n)
    // Space complexity: O(n)
    public int[] limitOccurrences(int[] nums, int k) {
        int[] result = new int[nums.length];
        int count = 0, index = 0, prev = -1;
        
        for (int num : nums) {
            if (num != prev) {
                count = 1;
                prev = num;
            } else {
                count++;
            }
            
            if (count <= k) {
                result[index++] = num;
            }
        }
        
        // Trim the array to the correct size
        int[] trimmedResult = new int[index];
        System.arraycopy(result, 0, trimmedResult, 0, index);
        
        return trimmedResult;
    }
}