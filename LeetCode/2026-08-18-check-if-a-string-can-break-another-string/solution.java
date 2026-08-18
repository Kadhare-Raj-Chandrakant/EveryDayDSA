class Solution {
    // Time complexity: O(n log n) due to sorting
    // Space complexity: O(n) for sorting in-place
    public boolean checkIfCanBreak(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        
        Arrays.sort(c1);
        Arrays.sort(c2);
        
        boolean canBreak1 = true;
        boolean canBreak2 = true;
        
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] > c2[i]) canBreak1 = false;
            if (c2[i] > c1[i]) canBreak2 = false;
        }
        
        return canBreak1 || canBreak2;
    }
}