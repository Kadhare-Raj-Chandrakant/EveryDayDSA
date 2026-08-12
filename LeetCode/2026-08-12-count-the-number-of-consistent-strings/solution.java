class Solution {
    // Time complexity: O(n*m) where n is the number of words and m is the maximum length of a word
    // Space complexity: O(1) as the space used does not grow with the size of the input
    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        for (String word : words) {
            boolean isConsistent = true;
            for (char c : word.toCharArray()) {
                if (allowed.indexOf(c) == -1) {
                    isConsistent = false;
                    break;
                }
            }
            if (isConsistent) {
                count++;
            }
        }
        return count;
    }
}