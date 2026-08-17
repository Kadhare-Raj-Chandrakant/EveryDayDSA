class Solution {
    // Time complexity: O(n)
    // Space complexity: O(n)
    public int minSizeSubarray(int[] nums, int target) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int subarraySum = prefixSum[j] - prefixSum[i];
                if (subarraySum == target) {
                    minLen = Math.min(minLen, j - i);
                }
            }
        }
        
        if (minLen == Integer.MAX_VALUE) {
            for (int i = 0; i <= n; i++) {
                int prefixSumMod = (prefixSum[i] % sum + sum) % sum;
                for (int j = i + 1; j <= n; j++) {
                    int suffixSumMod = (prefixSum[n] - prefixSum[j] + sum) % sum;
                    int totalMod = (prefixSumMod + suffixSumMod) % sum;
                    if (totalMod == target % sum) {
                        int totalSum = prefixSum[i] + suffixSumMod + sum;
                        if (totalSum >= target && totalSum - target < sum) {
                            minLen = Math.min(minLen, n + j - i);
                        }
                    }
                }
            }
        }
        
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}