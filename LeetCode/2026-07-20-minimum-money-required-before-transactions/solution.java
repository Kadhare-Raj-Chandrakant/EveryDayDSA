class Solution {
    // Time complexity: O(n log n) due to sorting
    // Space complexity: O(n) for sorting in place
    public long minimumMoney(int[][] transactions) {
        long minMoney = 0;
        long debt = 0;
        
        // Split transactions into two arrays
        int[][] earn = new int[transactions.length][2];
        int[][] debtTransactions = new int[transactions.length][2];
        int earnIndex = 0, debtIndex = 0;
        
        for (int[] transaction : transactions) {
            if (transaction[1] >= transaction[0]) {
                earn[earnIndex++] = transaction;
            } else {
                debt += transaction[0] - transaction[1];
                debtTransactions[debtIndex++] = transaction;
            }
        }
        
        // Sort earn transactions by cost in descending order
        Arrays.sort(earn, 0, earnIndex, (a, b) -> Integer.compare(b[0], a[0]));
        
        // Sort debt transactions by cashback in ascending order
        Arrays.sort(debtTransactions, 0, debtIndex, (a, b) -> Integer.compare(a[1], b[1]));
        
        // Calculate minimum money required
        for (int i = 0; i < earnIndex; i++) {
            minMoney = Math.max(minMoney, earn[i][0] - i);
        }
        
        for (int i = 0; i < debtIndex; i++) {
            minMoney = Math.max(minMoney, debtTransactions[i][0] - debtTransactions[i][1] + debt - i);
        }
        
        return minMoney;
    }
}