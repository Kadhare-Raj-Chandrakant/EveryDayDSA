class Solution {
    // Time: O(n^2), Space: O(n)
    public String minInteger(String num, int k) {
        int n = num.length();
        int[] digits = new int[n];
        for (int i = 0; i < n; i++) {
            digits[i] = num.charAt(i) - '0';
        }
        
        int[] indices = new int[10];
        for (int i = 0; i < 10; i++) {
            indices[i] = -1;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int digit = -1;
            int idx = -1;
            for (int j = 0; j < 10; j++) {
                if (indices[j] != -1 && (digit == -1 || digits[indices[j]] < digit)) {
                    if (indices[j] - i <= k) {
                        digit = digits[indices[j]];
                        idx = indices[j];
                    }
                }
            }
            sb.append(digit);
            for (int j = 0; j < 10; j++) {
                if (indices[j] < idx) {
                    indices[j]++;
                }
            }
            indices[digit] = -1;
            for (int j = i + 1; j < n; j++) {
                if (indices[digits[j]] == -1) {
                    indices[digits[j]] = j;
                }
            }
            k -= idx - i;
        }
        return sb.toString();
    }
}