class Solution {
    // Time complexity: O(n log n) due to sorting
    // Space complexity: O(n) for storing the mapped numbers
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        Integer[] mapped = new Integer[n];
        
        // Map the original numbers to new numbers by the mapping rule
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int mappedNum = 0;
            int pow = 0;
            while (num > 0) {
                int digit = num % 10;
                mappedNum += mapping[digit] * (int) Math.pow(10, pow);
                pow++;
                num /= 10;
            }
            mapped[i] = mappedNum;
        }
        
        // Sort the new numbers, using the index as a tiebreaker
        Arrays.sort(mapped, (a, b) -> {
            if (a.equals(b)) {
                return Integer.compare(nums[Arrays.asList(mapped).indexOf(a)], nums[Arrays.asList(mapped).indexOf(b)]);
            } else {
                return a.compareTo(b);
            }
        });
        
        // Replace the mapped numbers with the original numbers
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = nums[Arrays.asList(mapped).indexOf(mapped[i])];
        }
        return result;
    }
}