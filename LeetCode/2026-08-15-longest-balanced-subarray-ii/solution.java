class Solution {
    // Time complexity: O(n log n) due to the segment tree operations
    // Space complexity: O(n) for storing the segment tree and the positions of the numbers
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int[] pos = new int[100001]; // Store the first occurrence of each number
        Arrays.fill(pos, n); // Initialize with n, which is out of bounds

        // Initialize the segment tree with zeros
        SegmentTree st = new SegmentTree(n);

        int ans = 0;
        for (int l = n - 1; l >= 0; l--) {
            int val = nums[l];
            int sign = (val % 2 == 0) ? -1 : 1; // +1 for odd, -1 for even

            // Update the segment tree with the contribution of the current number
            st.update(0, pos[val] - 1, -sign);
            pos[val] = l; // Update the first occurrence of the current number

            // Find the rightmost index r such that the sum of signs from l to r is zero
            int r = st.findZero(l);
            if (r != -1) {
                ans = Math.max(ans, r - l + 1);
            }
        }
        return ans;
    }

    // A simple segment tree implementation
    static class SegmentTree {
        int[] tree;
        int n;

        public SegmentTree(int n) {
            this.n = n;
            tree = new int[4 * n];
        }

        // Update the segment tree with a value at a given range
        public void update(int l, int r, int val) {
            update(0, 0, n - 1, l, r, val);
        }

        private void update(int id, int l, int r, int ql, int qr, int val) {
            if (l > qr || r < ql) return;
            if (l >= ql && r <= qr) {
                tree[id] += val;
                return;
            }
            int mid = (l + r) / 2;
            update(2 * id + 1, l, mid, ql, qr, val);
            update(2 * id + 2, mid + 1, r, ql, qr, val);
        }

        // Find the rightmost index r such that the sum of signs from l to r is zero
        public int findZero(int l) {
            return findZero(0, 0, n - 1, l);
        }

        private int findZero(int id, int l, int r, int ql) {
            if (l > ql || tree[id] != 0) return -1;
            if (l == r) return l;
            int mid = (l + r) / 2;
            int res = findZero(2 * id + 2, mid + 1, r, ql);
            if (res != -1) return res;
            return findZero(2 * id + 1, l, mid, ql);
        }
    }
}