class Solution {
    // Time complexity: O(1) since the lengths of a and b are fixed
    // Space complexity: O(1) since no extra space is used
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}