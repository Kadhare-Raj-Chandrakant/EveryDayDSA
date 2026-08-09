class Solution {
    // Time complexity: O(n^2) where n is the length of the word
    // Space complexity: O(1) as we are using a fixed size array of size 26
    public boolean equalFrequency(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        
        for (int i = 0; i < word.length(); i++) {
            freq[word.charAt(i) - 'a']--;
            if (canEqualize(freq)) {
                return true;
            }
            freq[word.charAt(i) - 'a']++;
        }
        return false;
    }
    
    private boolean canEqualize(int[] freq) {
        int count = 0;
        int expected = -1;
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                if (expected == -1) {
                    expected = freq[i];
                } else if (freq[i] != expected) {
                    return false;
                }
                count++;
            }
        }
        return count == 1 || expected == 1;
    }
}