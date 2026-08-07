class Solution {
    // Time complexity: O(n), where n is the number of cities
    // Space complexity: O(n), where n is the number of cities
    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] road : roads) {
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
        }
        long res = 0;
        int[] subtreeSize = new int[n];
        dfs(graph, 0, -1, seats, subtreeSize, res);
        return res;
    }

    private int dfs(List<Integer>[] graph, int node, int parent, int seats, int[] subtreeSize, long res) {
        subtreeSize[node] = 1;
        for (int child : graph[node]) {
            if (child != parent) {
                subtreeSize[node] += dfs(graph, child, node, seats, subtreeSize, res);
            }
        }
        if (node != 0) {
            res += (subtreeSize[node] + seats - 1) / seats;
        }
        return subtreeSize[node];
    }
}