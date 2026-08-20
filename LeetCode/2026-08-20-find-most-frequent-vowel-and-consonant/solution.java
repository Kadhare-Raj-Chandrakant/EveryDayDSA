// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public int maxFreqSum(String s) {
        int[] vowelCount = new int[5];
        int[] consonantCount = new int[26];
        int maxVowel = 0, maxConsonant = 0;
        
        for (char c : s.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                int index = "aeiou".indexOf(c);
                vowelCount[index]++;
                maxVowel = Math.max(maxVowel, vowelCount[index]);
            } else {
                consonantCount[c - 'a']++;
                maxConsonant = Math.max(maxConsonant, consonantCount[c - 'a']);
            }
        }
        
        return maxVowel + maxConsonant;
    }
}