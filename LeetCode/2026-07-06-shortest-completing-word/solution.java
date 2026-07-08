class Solution {
    // Time complexity: O(n*m) where n is the number of words and m is the maximum length of a word
    // Space complexity: O(m) for storing the frequency of characters in the license plate
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] freq = new int[26];
        for (char c : licensePlate.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                freq[c - 'a']++;
            }
        }
        
        String res = null;
        int minLen = Integer.MAX_VALUE;
        for (String word : words) {
            int[] wordFreq = new int[26];
            for (char c : word.toCharArray()) {
                wordFreq[c - 'a']++;
            }
            
            boolean isCompleting = true;
            for (int i = 0; i < 26; i++) {
                if (wordFreq[i] < freq[i]) {
                    isCompleting = false;
                    break;
                }
            }
            
            if (isCompleting && word.length() < minLen) {
                res = word;
                minLen = word.length();
            }
        }
        
        return res;
    }
}