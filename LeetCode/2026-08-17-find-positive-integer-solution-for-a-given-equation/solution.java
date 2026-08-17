// Time complexity: O(n^2) where n = 1000
// Space complexity: O(n) where n is the number of solutions
class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> result = new ArrayList<>();
        for (int x = 1; x <= 1000; x++) {
            for (int y = 1; y <= 1000; y++) {
                if (customfunction.f(x, y) == z) {
                    result.add(Arrays.asList(x, y));
                } else if (customfunction.f(x, y) > z) {
                    break;
                }
            }
        }
        return result;
    }
}