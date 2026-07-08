class Solution {
    // Time complexity: O(log n) where n is the input number
    // Space complexity: O(1)
    public int findComplement(int num) {
        int mask = 0;
        int temp = num;
        while (temp != 0) {
            mask = (mask << 1) | 1;
            temp >>= 1;
        }
        return num ^ mask;
    }
}