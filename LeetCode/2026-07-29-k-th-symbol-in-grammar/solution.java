// Time complexity: O(log k)
// Space complexity: O(1)
class Solution {
    public int kthGrammar(int n, int k) {
        k--;
        int result = 0;
        while (k > 0) {
            result ^= k & 1;
            k >>= 1;
        }
        return result;
    }
}