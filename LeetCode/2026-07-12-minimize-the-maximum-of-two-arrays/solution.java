class Solution {
    // Time complexity: O(log n), Space complexity: O(1)
    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        int left = 1, right = (int) 1e9;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isValid(mid, divisor1, divisor2, uniqueCnt1, uniqueCnt2)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean isValid(int max, int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        int cnt1 = count(max, divisor1);
        int cnt2 = count(max, divisor2);
        return cnt1 >= uniqueCnt1 && cnt2 >= uniqueCnt2 && cnt1 + cnt2 - count(max, lcm(divisor1, divisor2)) >= uniqueCnt1 + uniqueCnt2;
    }

    private int count(int max, int divisor) {
        int cnt = max / divisor;
        if (divisor == 1) return 0;
        if (max % divisor != 0) cnt++;
        return cnt;
    }

    private long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    private long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}