class Solution {
    // Time complexity: O(n log n) due to sorting and binary search
    // Space complexity: O(n) for storing the sequences
    public int kIncreasing(int[] arr, int k) {
        int n = arr.length;
        int[][] sequences = new int[k][];
        int[] sizes = new int[k];
        
        // Divide the array into k non-overlapping sequences
        for (int i = 0; i < n; i++) {
            int seqIndex = i % k;
            sequences[seqIndex] = Arrays.copyOf(sequences[seqIndex], sizes[seqIndex] + 1);
            sequences[seqIndex][sizes[seqIndex]++] = arr[i];
        }
        
        int operations = 0;
        for (int i = 0; i < k; i++) {
            // Find the longest non-decreasing subsequence in the current sequence
            int[] lis = longestIncreasingSubsequence(sequences[i], sizes[i]);
            operations += sizes[i] - lis.length;
        }
        
        return operations;
    }
    
    // Function to find the longest increasing subsequence using dynamic programming and binary search
    private int[] longestIncreasingSubsequence(int[] sequence, int size) {
        int[] lis = new int[size];
        int len = 0;
        
        for (int i = 0; i < size; i++) {
            int index = binarySearch(lis, len, sequence[i]);
            lis[index] = sequence[i];
            if (index == len) len++;
        }
        
        return Arrays.copyOf(lis, len);
    }
    
    // Function to perform binary search in the longest increasing subsequence
    private int binarySearch(int[] lis, int len, int target) {
        int left = 0, right = len;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (lis[mid] < target) left = mid + 1;
            else right = mid;
        }
        
        return left;
    }
}