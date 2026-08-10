// Time complexity: O(n log n) due to sorting
// Space complexity: O(n) for storing the result
class Solution {
    public List<List<Object>> notBoringMovies(List<List<Object>> cinema) {
        List<List<Object>> result = new ArrayList<>();
        for (List<Object> movie : cinema) {
            if ((int) movie.get(0) % 2 != 0 && !movie.get(2).equals("boring")) {
                result.add(movie);
            }
        }
        Collections.sort(result, (a, b) -> Double.compare((double) b.get(3), (double) a.get(3)));
        return result;
    }
}