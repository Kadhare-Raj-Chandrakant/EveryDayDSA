// Time complexity: O(n) for constructor, O(log n) for pickIndex
// Space complexity: O(n)
class Solution {
    private int[] prefixSums;
    private int totalSum;
    private Random random;

    public Solution(int[] w) {
        prefixSums = new int[w.length];
        totalSum = 0;
        random = new Random();

        for (int i = 0; i < w.length; i++) {
            totalSum += w[i];
            prefixSums[i] = totalSum;
        }
    }

    public int pickIndex() {
        int target = random.nextInt(totalSum);
        int left = 0, right = prefixSums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (prefixSums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}