class Solution {
    // Time complexity: O(n log n) due to sorting, Space complexity: O(n) for the set
    public int getCommon(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) set.add(num);
        for (int num : nums2) {
            if (set.contains(num)) return num;
        }
        return -1;
    }
}
```

Alternatively, using a two-pointer approach:

```java
class Solution {
    // Time complexity: O(n), Space complexity: O(1)
    public int getCommon(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) return nums1[i];
            else if (nums1[i] < nums2[j]) i++;
            else j++;
        }
        return -1;
    }
}