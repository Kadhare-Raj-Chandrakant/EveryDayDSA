class Solution {
    // Time complexity: O(n)
    // Space complexity: O(1)
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int min = 0, max = 0;
        int sum = 0;
        for (int diff : differences) {
            sum += diff;
            min = Math.min(min, sum);
            max = Math.max(max, sum);
        }
        int range = max - min;
        return Math.max(0, upper - lower + 1 - range);
    }
}