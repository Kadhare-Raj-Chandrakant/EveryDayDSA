class Solution {
    // Time complexity: O(n * 2^n)
    // Space complexity: O(n)
    public int maximumGood(int[][] statements) {
        int n = statements.length;
        int maxGood = 0;
        
        for (int mask = 0; mask < (1 << n); mask++) {
            boolean isValid = true;
            int goodCount = 0;
            
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    goodCount++;
                    
                    for (int j = 0; j < n; j++) {
                        if (statements[i][j] == 0 && (mask & (1 << j)) != 0) {
                            isValid = false;
                            break;
                        }
                        if (statements[i][j] == 1 && (mask & (1 << j)) == 0) {
                            isValid = false;
                            break;
                        }
                    }
                }
            }
            
            if (isValid) {
                maxGood = Math.max(maxGood, goodCount);
            }
        }
        
        return maxGood;
    }
}