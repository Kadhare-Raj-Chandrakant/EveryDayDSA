class Solution {
    // Time complexity: O(n), where n is the length of the string s
    // Space complexity: O(n), where n is the length of the string s
    public String processStr(String s) {
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                if (result.length() > 0) {
                    result.deleteCharAt(result.length() - 1);
                }
            } else if (c == '#') {
                result.append(result.toString());
            } else if (c == '%') {
                result.reverse();
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}