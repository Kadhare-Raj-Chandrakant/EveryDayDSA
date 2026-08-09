class Solution {
    // Time complexity: O(n), where n is the length of the string
    // Space complexity: O(1), excluding the space needed for the input string
    public int countSegments(String s) {
        int count = 0;
        boolean inSegment = false;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                inSegment = false;
            } else if (!inSegment) {
                count++;
                inSegment = true;
            }
        }
        return count;
    }
}