class Solution {
    // Time complexity: O(n*m) where n is the number of words and m is the maximum length of a word
    // Space complexity: O(26) = O(1) since we only need to store the frequency of 26 lowercase English letters
    public boolean makeEqual(String[] words) {
        int[] freq = new int[26];
        for (String word : words) {
            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] % words.length != 0) {
                return false;
            }
        }
        return true;
    }
}