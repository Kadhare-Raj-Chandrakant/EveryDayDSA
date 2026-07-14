class Solution {
    // Time complexity: O(n log n) due to the binary representation of integers up to n
    // Space complexity: O(1) as we only use a constant amount of space
    public boolean queryString(String s, int n) {
        for (int i = 1; i <= n; i++) {
            if (!s.contains(Integer.toBinaryString(i))) {
                return false;
            }
        }
        return true;
    }
}