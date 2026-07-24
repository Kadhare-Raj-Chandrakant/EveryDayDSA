class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        // Time complexity: O(n)
        // Space complexity: O(1)
        
        int MOD = (int)1e9 + 7;
        int n = arr.length;
        
        // Calculate the sum of the array
        long sum = 0;
        for (int num : arr) {
            sum += num;
        }
        
        // Calculate the maximum subarray sum for k=1 using Kadane's algorithm
        int kadaneMaxSum = kadane(arr);
        
        // If k is 1, return the maximum subarray sum
        if (k == 1) {
            return kadaneMaxSum;
        }
        
        // Calculate the maximum suffix sum and maximum prefix sum
        int maxSuffixSum = maxSuffixSum(arr);
        int maxPrefixSum = maxPrefixSum(arr);
        
        // Calculate the maximum subarray sum for k>1
        long maxSum = Math.max(kadaneMaxSum, Math.max(maxSuffixSum + maxPrefixSum + (k - 2) * sum, sum * k));
        
        // Return the maximum subarray sum modulo MOD
        return (int)(maxSum % MOD);
    }
    
    // Function to calculate the maximum subarray sum using Kadane's algorithm
    private int kadane(int[] arr) {
        int maxSum = arr[0];
        int currentSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
    
    // Function to calculate the maximum suffix sum
    private int maxSuffixSum(int[] arr) {
        int maxSum = arr[arr.length - 1];
        int currentSum = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
    
    // Function to calculate the maximum prefix sum
    private int maxPrefixSum(int[] arr) {
        int maxSum = arr[0];
        int currentSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}