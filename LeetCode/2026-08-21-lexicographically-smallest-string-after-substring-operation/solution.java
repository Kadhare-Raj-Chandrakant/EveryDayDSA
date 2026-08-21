class Solution {
    // Time complexity: O(n)
    // Space complexity: O(n)
    public String smallestString(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        while (left < chars.length) {
            if (chars[left] == 'a') {
                left++;
            } else {
                break;
            }
        }
        if (left < chars.length) {
            for (int i = 0; i <= left; i++) {
                if (chars[i] == 'a') {
                    continue;
                }
                chars[i]--;
            }
        }
        return new String(chars);
    }
}