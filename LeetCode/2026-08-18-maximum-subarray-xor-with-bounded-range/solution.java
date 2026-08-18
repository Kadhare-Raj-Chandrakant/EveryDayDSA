class Solution {
    // Time complexity: O(n * log(max_val)), where max_val is the maximum value in nums
    // Space complexity: O(n * log(max_val))
    public int maxXor(int[] nums, int k) {
        int n = nums.length;
        int[] pref = new int[n + 1];
        pref[0] = 0;
        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] ^ nums[i];
        }

        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }
        int maxBits = 0;
        while (maxVal > 0) {
            maxVal >>= 1;
            maxBits++;
        }

        Trie trie = new Trie(maxBits);
        trie.insert(0);

        int res = 0;
        int L = 0;
        for (int R = 0; R < n; R++) {
            while (L <= R && nums[R] - nums[L] > k) {
                trie.remove(pref[L]);
                L++;
            }
            res = Math.max(res, trie.query(pref[R + 1]));
            trie.insert(pref[R + 1]);
        }
        return res;
    }

    class Trie {
        int[][] children;
        int[] count;
        int maxBits;

        Trie(int maxBits) {
            this.maxBits = maxBits;
            children = new int[2][(1 << maxBits) + 1];
            count = new int[(1 << maxBits) + 1];
        }

        void insert(int val) {
            int node = 0;
            count[node]++;
            for (int i = maxBits - 1; i >= 0; i--) {
                int bit = (val >> i) & 1;
                if (children[bit][node] == 0) {
                    children[bit][node] = count.length;
                    children[0][count.length] = children[1][count.length] = 0;
                    count = Arrays.copyOf(count, count.length + 1);
                }
                node = children[bit][node];
                count[node]++;
            }
        }

        void remove(int val) {
            int node = 0;
            count[node]--;
            for (int i = maxBits - 1; i >= 0; i--) {
                int bit = (val >> i) & 1;
                node = children[bit][node];
                count[node]--;
            }
        }

        int query(int val) {
            int node = 0;
            int res = 0;
            for (int i = maxBits - 1; i >= 0; i--) {
                int bit = (val >> i) & 1;
                if (count[children[1 - bit][node]] > 0) {
                    res |= (1 << i);
                    node = children[1 - bit][node];
                } else {
                    node = children[bit][node];
                }
            }
            return res;
        }
    }
}