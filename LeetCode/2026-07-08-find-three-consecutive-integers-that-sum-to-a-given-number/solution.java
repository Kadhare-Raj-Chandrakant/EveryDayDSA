class Solution {
    // Time complexity: O(1)
    // Space complexity: O(1)
    public long[] sumOfThree(long num) {
        if (num % 3 != 0) {
            return new long[0];
        }
        long x = num / 3;
        if (x - 1 + x + x + 1 != num) {
            return new long[0];
        }
        return new long[]{x - 1, x, x + 1};
    }
}