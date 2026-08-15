class Solution {
    // Time complexity: O(n * q * log(max_value)), where n is the length of nums, q is the number of queries, and max_value is the maximum value in nums.
    // Space complexity: O(1), excluding the space required for the output array.
    public int[] kthSmallestEven(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;
        int[] ans = new int[q];

        for (int i = 0; i < q; i++) {
            int li = queries[i][0];
            int ri = queries[i][1];
            int ki = queries[i][2];

            int lo = 2, hi = 1_000_000_000;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                int count = mid / 2;
                int removed = 0;

                for (int j = li; j <= ri; j++) {
                    if (nums[j] % 2 == 0 && nums[j] <= mid) {
                        removed++;
                    }
                }

                if (count - removed < ki) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }

            ans[i] = lo;
        }

        return ans;
    }
}