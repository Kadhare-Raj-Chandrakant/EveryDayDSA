class Solution {
    // Time complexity: O(log n)
    // Space complexity: O(log n)
    public int nextGreaterElement(int n) {
        String numStr = String.valueOf(n);
        char[] chars = numStr.toCharArray();
        int len = chars.length;
        
        // Find the first decreasing digit from right to left
        int i = len - 2;
        while (i >= 0 && chars[i] >= chars[i + 1]) {
            i--;
        }
        
        // If no decreasing digit found, return -1
        if (i < 0) {
            return -1;
        }
        
        // Find the smallest digit greater than chars[i] from right to left
        int j = len - 1;
        while (chars[j] <= chars[i]) {
            j--;
        }
        
        // Swap chars[i] and chars[j]
        swap(chars, i, j);
        
        // Reverse the substring to the right of i
        reverse(chars, i + 1, len);
        
        // Convert the char array back to integer
        long result = Long.parseLong(new String(chars));
        
        // If the result is greater than Integer.MAX_VALUE, return -1
        return result > Integer.MAX_VALUE ? -1 : (int) result;
    }
    
    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
    
    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            swap(chars, start, end - 1);
            start++;
            end--;
        }
    }
}