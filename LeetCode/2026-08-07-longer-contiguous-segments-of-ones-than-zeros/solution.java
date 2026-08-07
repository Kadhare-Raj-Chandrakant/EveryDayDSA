class Solution {
    // Time complexity: O(n), where n is the length of the string
    // Space complexity: O(1), as we only use a constant amount of space
    public boolean checkZeroOnes(String s) {
        int maxOnes = 0, maxZeros = 0;
        int currentOnes = 0, currentZeros = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '1') {
                currentOnes++;
                currentZeros = 0;
                maxOnes = Math.max(maxOnes, currentOnes);
            } else {
                currentZeros++;
                currentOnes = 0;
                maxZeros = Math.max(maxZeros, currentZeros);
            }
        }
        
        return maxOnes > maxZeros;
    }
}