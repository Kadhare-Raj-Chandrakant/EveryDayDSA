class ExamTracker {
    private int[] times;
    private long[] prefix;
    private int index;

    // Time complexity: O(1)
    public ExamTracker() {
        times = new int[100000];
        prefix = new long[100000];
    }

    // Time complexity: O(1)
    public void record(int time, int score) {
        times[index] = time;
        if (index == 0) {
            prefix[index] = score;
        } else {
            prefix[index] = prefix[index - 1] + score;
        }
        index++;
    }

    // Time complexity: O(log n)
    public long totalScore(int startTime, int endTime) {
        int l = lowerBound(times, startTime);
        int r = upperBound(times, endTime) - 1;
        if (l > r) {
            return 0;
        }
        return prefix[r] - (l > 0 ? prefix[l - 1] : 0);
    }

    // Binary search to find the first index where times[i] >= target
    private int lowerBound(int[] times, int target) {
        int l = 0, r = index;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (times[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }

    // Binary search to find the first index where times[i] > target
    private int upperBound(int[] times, int target) {
        int l = 0, r = index;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (times[m] <= target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}