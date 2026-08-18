class Solution {
    // Time complexity: O(n log n) due to sorting
    // Space complexity: O(n) for storing character frequencies
    public int minDeletions(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        int[] uniqueFreq = new int[100001];
        int deletions = 0;
        
        for (int f : freq) {
            if (f > 0) {
                while (f > 0 && uniqueFreq[f] > 0) {
                    deletions++;
                    f--;
                }
                uniqueFreq[f]++;
            }
        }
        
        return deletions;
    }
}