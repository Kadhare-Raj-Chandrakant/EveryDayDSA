class Solution {
    // Time complexity: O(n)
    // Space complexity: O(n)
    public boolean uniqueOccurrences(int[] arr) {
        int n = arr.length;
        int[] count = new int[2001]; // considering -1000 <= arr[i] <= 1000
        
        // Count occurrences of each number
        for (int i = 0; i < n; i++) {
            count[arr[i] + 1000]++;
        }
        
        boolean[] seen = new boolean[1001]; // max possible count is n
        
        // Check if counts are unique
        for (int i = 0; i < 2001; i++) {
            if (count[i] > 0) {
                if (seen[count[i]]) {
                    return false;
                }
                seen[count[i]] = true;
            }
        }
        
        return true;
    }
}