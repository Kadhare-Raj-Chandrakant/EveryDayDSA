class Solution {
    // Time complexity: O(m + q * 9) where m is the number of lamps and q is the number of queries
    // Space complexity: O(m)
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        Set<String> lampSet = new HashSet<>();
        Map<Integer, Integer> rowMap = new HashMap<>();
        Map<Integer, Integer> colMap = new HashMap<>();
        Map<Integer, Integer> diagonal1Map = new HashMap<>();
        Map<Integer, Integer> diagonal2Map = new HashMap<>();

        for (int[] lamp : lamps) {
            int row = lamp[0];
            int col = lamp[1];
            String key = row + "," + col;
            if (lampSet.contains(key)) continue;
            lampSet.add(key);
            rowMap.put(row, rowMap.getOrDefault(row, 0) + 1);
            colMap.put(col, colMap.getOrDefault(col, 0) + 1);
            diagonal1Map.put(row + col, diagonal1Map.getOrDefault(row + col, 0) + 1);
            diagonal2Map.put(row - col, diagonal2Map.getOrDefault(row - col, 0) + 1);
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int row = queries[i][0];
            int col = queries[i][1];
            if (rowMap.containsKey(row) || colMap.containsKey(col) || diagonal1Map.containsKey(row + col) || diagonal2Map.containsKey(row - col)) {
                result[i] = 1;
            }
            for (int r = Math.max(0, row - 1); r <= Math.min(n - 1, row + 1); r++) {
                for (int c = Math.max(0, col - 1); c <= Math.min(n - 1, col + 1); c++) {
                    String key = r + "," + c;
                    if (!lampSet.contains(key)) continue;
                    lampSet.remove(key);
                    rowMap.put(r, rowMap.get(r) - 1);
                    if (rowMap.get(r) == 0) rowMap.remove(r);
                    colMap.put(c, colMap.get(c) - 1);
                    if (colMap.get(c) == 0) colMap.remove(c);
                    diagonal1Map.put(r + c, diagonal1Map.get(r + c) - 1);
                    if (diagonal1Map.get(r + c) == 0) diagonal1Map.remove(r + c);
                    diagonal2Map.put(r - c, diagonal2Map.get(r - c) - 1);
                    if (diagonal2Map.get(r - c) == 0) diagonal2Map.remove(r - c);
                }
            }
        }
        return result;
    }
}