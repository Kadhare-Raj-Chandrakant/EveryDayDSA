class Solution {
    // Time complexity: O(n * k * log(k)) where n is the length of nums
    // Space complexity: O(k)
    public long kSum(int[] nums, int k) {
        long sum = 0;
        for (int num : nums) sum += Math.max(num, 0);
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(b[0], a[0]));
        pq.offer(new long[]{sum, 0});
        boolean[] seen = new boolean[1 << nums.length];
        seen[0] = true;
        for (int i = 0; i < k - 1; i++) {
            long[] top = pq.poll();
            long s = top[0], idx = top[1];
            for (int j = 0; j < nums.length; j++) {
                if (((idx >> j) & 1) == 0) continue;
                long next = s - Math.max(nums[j], 0);
                int nextIdx = idx ^ (1 << j);
                if (seen[nextIdx]) continue;
                seen[nextIdx] = true;
                pq.offer(new long[]{next, nextIdx});
            }
        }
        return pq.peek()[0];
    }
}