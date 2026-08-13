class Solution {
    // Time complexity: O(n^2) where n is the length of the string
    // Space complexity: O(n) for the reversed string
    public boolean isSubstringPresent(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        for (int i = 0; i < s.length() - 1; i++) {
            String substring = s.substring(i, i + 2);
            if (reversed.contains(substring)) {
                return true;
            }
        }
        return false;
    }
}