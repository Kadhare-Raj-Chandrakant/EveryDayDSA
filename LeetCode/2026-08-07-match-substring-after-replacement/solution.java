// Time complexity: O(n * m * k) where n is the length of s, m is the length of sub, and k is the number of mappings.
// Space complexity: O(k)
class Solution {
    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        int n = s.length(), m = sub.length();
        // Create a map to store the mappings for quick lookup
        boolean[][] map = new boolean[128][128];
        for (char[] mapping : mappings) {
            map[mapping[0]][mapping[1]] = true;
        }
        
        // Enumerate all substrings of s with the same length as sub
        for (int i = 0; i <= n - m; i++) {
            boolean match = true;
            // Compare each substring to sub for equality
            for (int j = 0; j < m; j++) {
                char c1 = s.charAt(i + j), c2 = sub.charAt(j);
                // Check if c1 can result from replacing c2
                if (c1 != c2 && !map[c2][c1]) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return true;
            }
        }
        return false;
    }
}