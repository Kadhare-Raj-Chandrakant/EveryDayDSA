// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public int captureForts(int[] forts) {
        int result = 0;
        int lastMyFort = -1;
        int lastEmpty = -1;
        
        for (int i = 0; i < forts.length; i++) {
            if (forts[i] == 1) {
                if (lastEmpty != -1) {
                    int count = 0;
                    for (int j = lastEmpty + 1; j < i; j++) {
                        if (forts[j] == 0) count++;
                    }
                    result = Math.max(result, count);
                }
                lastMyFort = i;
            } else if (forts[i] == -1) {
                if (lastMyFort != -1) {
                    int count = 0;
                    for (int j = lastMyFort + 1; j < i; j++) {
                        if (forts[j] == 0) count++;
                    }
                    result = Math.max(result, count);
                }
                lastEmpty = i;
            }
        }
        
        return result;
    }
}