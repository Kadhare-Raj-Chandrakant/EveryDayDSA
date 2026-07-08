class Solution {
    // Time complexity: O(n)
    // Space complexity: O(n)
    public int[] countVisitedNodes(int[] edges) {
        int n = edges.length;
        int[] answer = new int[n];
        boolean[] visited = new boolean[n];
        int[] cycleLengths = new int[n];
        int[] cycleNodeCounts = new int[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int cycleLength = 0;
                int node = i;
                while (!visited[node]) {
                    visited[node] = true;
                    node = edges[node];
                    cycleLength++;
                }
                cycleLengths[i] = cycleLength;
                cycleNodeCounts[i] = cycleLength;
                node = edges[i];
                while (node != i) {
                    cycleNodeCounts[node] = cycleLength;
                    node = edges[node];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (cycleNodeCounts[i] == 0) {
                int node = i;
                int count = 0;
                while (node != -1) {
                    count++;
                    node = edges[node];
                    if (cycleNodeCounts[node] != 0) {
                        count += cycleNodeCounts[node];
                        break;
                    }
                }
                answer[i] = count;
                node = edges[i];
                while (node != -1 && cycleNodeCounts[node] == 0) {
                    answer[node] = count;
                    node = edges[node];
                }
            } else {
                answer[i] = cycleNodeCounts[i];
            }
        }

        return answer;
    }
}