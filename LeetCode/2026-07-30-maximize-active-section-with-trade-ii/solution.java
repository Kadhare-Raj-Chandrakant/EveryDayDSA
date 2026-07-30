// Time complexity: O(n + q log n), where n is the length of s and q is the number of queries
// Space complexity: O(n)
class Solution {
    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        int n = s.length();
        int[] ones = new int[n + 2];
        int[] zeros = new int[n + 2];
        int[] maxZeros = new int[n + 2];

        int id = 1;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) == '1') {
                ones[id] = ones[id - 1] + 1;
                zeros[id] = zeros[id - 1];
            } else {
                ones[id] = ones[id - 1];
                zeros[id] = zeros[id - 1] + 1;
            }
            if (s.charAt(i - 1) == '0' && s.charAt(i - 2) == '1') {
                maxZeros[id] = zeros[id - 1];
            } else {
                maxZeros[id] = maxZeros[id - 1];
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int[] query : queries) {
            int left = query[0] + 1;
            int right = query[1] + 1;
            int max = Math.max(maxZeros[right] - maxZeros[left - 1], ones[right] - ones[left - 1]);
            if (s.charAt(query[0] - 1) == '1' && s.charAt(query[1] - 1) == '1') {
                max = Math.max(max, ones[right] - ones[left - 1] + zeros[right] - zeros[left - 1]);
            }
            result.add(max);
        }
        return result;
    }
}