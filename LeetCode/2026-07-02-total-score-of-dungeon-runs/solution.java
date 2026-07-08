class Solution {
    // Time complexity: O(n log n)
    // Space complexity: O(n)
    public long totalScore(int hp, int[] damage, int[] requirement) {
        int n = damage.length;
        long[] pref = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            pref[i] = pref[i - 1] + damage[i - 1];
        }
        
        long total = (long) n * (n + 1) / 2;
        for (int j = 0; j < n; j++) {
            int target = requirement[j] - hp + pref[j + 1];
            int i = binarySearch(pref, target);
            total -= i;
        }
        
        return total;
    }
    
    private int binarySearch(long[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}