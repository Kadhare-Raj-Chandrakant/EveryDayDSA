class Solution {
    // Time complexity: O(1), Space complexity: O(1)
    public int longestString(int x, int y, int z) {
        int max = Math.max(x, y);
        int min = Math.min(x, y);
        int res = z + 2 * Math.min(max, min + z);
        if (max > min + z) {
            res += 2 * (max - min - z);
        }
        return res;
    }
}