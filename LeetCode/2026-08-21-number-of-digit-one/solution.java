class Solution {
    // Time complexity: O(log n)
    // Space complexity: O(1)
    public int countDigitOne(int n) {
        int count = 0;
        long i = 1;
        while (i <= n) {
            long divider = i * 10;
            count += (n / divider) * i + Math.min(Math.max(n % divider - i + 1, 0), i);
            i *= 10;
        }
        return count;
    }
}