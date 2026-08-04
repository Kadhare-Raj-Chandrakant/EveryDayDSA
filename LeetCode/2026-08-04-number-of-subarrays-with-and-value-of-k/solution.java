class Solution {
    // Time complexity: O(n log n)
    // Space complexity: O(n)
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        long[][] sparseTable = new long[n][32];
        for (int i = 0; i < n; i++) {
            sparseTable[i][0] = nums[i];
        }
        for (int j = 1; (1 << j) <= n; j++) {
            for (int i = 0; i + (1 << j) - 1 < n; i++) {
                sparseTable[i][j] = sparseTable[i][j - 1] & sparseTable[i + (1 << (j - 1))][j - 1];
            }
        }
        long count = 0;
        for (int i = 0; i < n; i++) {
            int left = i, right = n - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int andValue = getAndValue(sparseTable, i, mid);
                if (andValue == k) {
                    count += mid - i + 1;
                    break;
                } else if (andValue < k) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return count;
    }

    private int getAndValue(long[][] sparseTable, int left, int right) {
        int j = (int) (Math.log(right - left + 1) / Math.log(2));
        return (int) (sparseTable[left][j] & sparseTable[right - (1 << j) + 1][j]);
    }
}