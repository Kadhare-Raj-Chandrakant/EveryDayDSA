class Solution {
    // Time complexity: O(n), where n is the length of string s
    // Space complexity: O(1), as we only use a constant amount of space
    public int percentageLetter(String s, char letter) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == letter) {
                count++;
            }
        }
        return (int) ((count * 100.0 / s.length()) + 0.5);
    }
}