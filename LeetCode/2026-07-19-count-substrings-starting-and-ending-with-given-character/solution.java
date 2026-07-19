class Solution {
    // Time complexity: O(n), where n is the length of string s
    // Space complexity: O(1), as we only use a constant amount of space
    public long countSubstrings(String s, char c) {
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == c) {
                count++;
            }
        }
        return (long) count * (count + 1) / 2;
    }
}