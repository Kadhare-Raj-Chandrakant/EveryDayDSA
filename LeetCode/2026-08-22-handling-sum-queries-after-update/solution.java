class Solution {
    // Time complexity: O(n log n + q log n)
    // Space complexity: O(n)
    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        int n = nums1.length;
        int q = queries.length;
        long[] res = new long[q];
        int idx = 0;
        LazySegmentTree tree = new LazySegmentTree(n);
        for (int i = 0; i < n; i++) {
            tree.update(i, i, nums1[i]);
        }
        for (int[] query : queries) {
            if (query[0] == 1) {
                tree.flip(query[1], query[2]);
            } else if (query[0] == 2) {
                tree.add(query[1], 0, n - 1);
            } else {
                res[idx++] = tree.query(0, n - 1);
            }
        }
        return res;
    }

    class LazySegmentTree {
        int n;
        long[] tree;
        long[] lazy;

        public LazySegmentTree(int n) {
            this.n = n;
            tree = new long[4 * n];
            lazy = new long[4 * n];
        }

        public void update(int l, int r, int val) {
            update(0, 0, n - 1, l, r, val);
        }

        private void update(int idx, int l, int r, int ql, int qr, int val) {
            if (qr < l || ql > r) return;
            if (ql <= l && qr >= r) {
                tree[idx] += val;
                lazy[idx] += val;
                return;
            }
            int mid = (l + r) / 2;
            propagate(idx, l, mid, mid + 1, r);
            update(2 * idx + 1, l, mid, ql, qr, val);
            update(2 * idx + 2, mid + 1, r, ql, qr, val);
            tree[idx] = tree[2 * idx + 1] + tree[2 * idx + 2];
        }

        public void flip(int l, int r) {
            flip(0, 0, n - 1, l, r);
        }

        private void flip(int idx, int l, int r, int ql, int qr) {
            if (qr < l || ql > r) return;
            if (ql <= l && qr >= r) {
                tree[idx] = (r - l + 1) - tree[idx];
                lazy[idx] = (r - l + 1) - lazy[idx];
                return;
            }
            int mid = (l + r) / 2;
            propagate(idx, l, mid, mid + 1, r);
            flip(2 * idx + 1, l, mid, ql, qr);
            flip(2 * idx + 2, mid + 1, r, ql, qr);
            tree[idx] = tree[2 * idx + 1] + tree[2 * idx + 2];
        }

        public void add(int val) {
            add(0, 0, n - 1, val);
        }

        private void add(int idx, int l, int r, int val) {
            tree[idx] += (r - l + 1) * val;
            lazy[idx] += (r - l + 1) * val;
        }

        public long query(int l, int r) {
            return query(0, 0, n - 1, l, r);
        }

        private long query(int idx, int l, int r, int ql, int qr) {
            if (qr < l || ql > r) return 0;
            if (ql <= l && qr >= r) return tree[idx];
            int mid = (l + r) / 2;
            propagate(idx, l, mid, mid + 1, r);
            return query(2 * idx + 1, l, mid, ql, qr) + query(2 * idx + 2, mid + 1, r, ql, qr);
        }

        private void propagate(int idx, int l1, int r1, int l2, int r2) {
            tree[2 * idx + 1] += (r1 - l1 + 1) * lazy[idx];
            lazy[2 * idx + 1] += (r1 - l1 + 1) * lazy[idx];
            tree[2 * idx + 2] += (r2 - l2 + 1) * lazy[idx];
            lazy[2 * idx + 2] += (r2 - l2 + 1) * lazy[idx];
            lazy[idx] = 0;
        }
    }
}