// Time complexity: O(n log n) for sorting, O(n) for string concatenation
// Space complexity: O(n) for storing the sorted string
class Solution {
    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            String min = s;
            for (int i = 0; i < s.length(); i++) {
                String newStr = s.substring(1) + s.charAt(0);
                if (newStr.compareTo(min) < 0) {
                    min = newStr;
                }
                s = newStr;
            }
            return min;
        } else {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
    }
}