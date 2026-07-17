class Solution {
    // Time complexity: O(E + V log V), where E is the number of edges and V is the number of vertices
    // Space complexity: O(V + E)
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        List<int[]>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(new int[] {edge[1], edge[2]});
            graph[edge[1]].add(new int[] {edge[0], edge[2]});
        }
        int[] result = new int[n];
        Arrays.fill(result, -1);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] {0, 0});
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            if (node[1] < disappear[node[0]]) {
                result[node[0]] = node[1];
                for (int[] neighbor : graph[node[0]]) {
                    if (result[neighbor[0]] == -1) {
                        pq.offer(new int[] {neighbor[0], node[1] + neighbor[1]});
                    }
                }
            }
        }
        return result;
    }
}