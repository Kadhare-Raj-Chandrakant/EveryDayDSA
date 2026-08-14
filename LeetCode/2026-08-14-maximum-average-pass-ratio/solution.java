class Solution {
    // Time complexity: O(n log n + m log n), where n is the number of classes and m is the number of extra students
    // Space complexity: O(n)
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Double.compare(getRatio(b), getRatio(a)));
        
        for (int[] c : classes) {
            pq.offer(c);
        }
        
        while (extraStudents-- > 0) {
            int[] top = pq.poll();
            pq.offer(new int[] {top[0] + 1, top[1] + 1});
        }
        
        double sum = 0;
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            sum += (double) top[0] / top[1];
        }
        
        return sum / classes.length;
    }
    
    private double getRatio(int[] c) {
        double before = (double) c[0] / c[1];
        double after = (double) (c[0] + 1) / (c[1] + 1);
        return before - after;
    }
}