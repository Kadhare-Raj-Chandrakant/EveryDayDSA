class Solution {
    // Time complexity: O(n), where n is the length of the string
    // Space complexity: O(1), excluding the space required for the input strings
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) return false;
        
        int diffCount = 0;
        int[] diffIndices = new int[2];
        
        boolean hasSameCharTwice = false;
        boolean[] charCount = new boolean[26];
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                diffCount++;
                if (diffCount > 2) return false;
                diffIndices[diffCount - 1] = i;
            }
            if (charCount[s.charAt(i) - 'a']) hasSameCharTwice = true;
            else charCount[s.charAt(i) - 'a'] = true;
        }
        
        if (diffCount == 0) return hasSameCharTwice;
        if (diffCount != 2) return false;
        
        return s.charAt(diffIndices[0]) == goal.charAt(diffIndices[1]) 
               && s.charAt(diffIndices[1]) == goal.charAt(diffIndices[0]);
    }
}