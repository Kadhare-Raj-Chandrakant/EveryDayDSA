class Solution {
    // Time complexity: O(n log k) where n is the number of trains and k is the maximum possible speed
    // Space complexity: O(1)
    public int minSpeedOnTime(int[] dist, double hour) {
        int left = 1, right = Integer.MAX_VALUE;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (!canReachOnTime(dist, hour, mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left == Integer.MAX_VALUE ? -1 : left;
    }

    private boolean canReachOnTime(int[] dist, double hour, int speed) {
        double time = 0;
        for (int i = 0; i < dist.length - 1; i++) {
            time += Math.ceil((double) dist[i] / speed);
        }
        time += (double) dist[dist.length - 1] / speed;
        return time <= hour;
    }
}