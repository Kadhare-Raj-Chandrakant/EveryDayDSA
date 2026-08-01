class Solution {
    // Time complexity: O(n log n) due to sorting and binary operations
    // Space complexity: O(n) for storing the frequency map
    public long countExcellentPairs(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(Integer.bitCount(num), freq.getOrDefault(Integer.bitCount(num), 0) + 1);
        }
        
        long res = 0;
        for (int i = 0; i <= 30; i++) {
            for (int j = 0; j <= 30; j++) {
                if (i + j >= k) {
                    res += (long) freq.getOrDefault(i, 0) * freq.getOrDefault(j, 0);
                }
            }
        }
        return res;
    }
}