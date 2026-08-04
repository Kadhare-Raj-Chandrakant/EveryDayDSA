// Time complexity: O(n)
// Space complexity: O(n)
public class Solution {
    public int[] getAverages(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] prefixSum = new int[n + 1];
        
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        
        for (int i = 0; i < n; i++) {
            int left = (i - 1 >= 0) ? prefixSum[i] / i : 0;
            int right = (i + 1 < n) ? (prefixSum[n] - prefixSum[i + 1]) / (n - i - 1) : 0;
            res[i] = left + right;
        }
        
        return res;
    }
}