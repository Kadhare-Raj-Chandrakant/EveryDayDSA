class Solution {
public:
    // Time complexity: O(n log n) due to sorting
    // Space complexity: O(1) excluding input space
    int minNumber(vector<int>& nums1, vector<int>& nums2) {
        sort(nums1.begin(), nums1.end());
        sort(nums2.begin(), nums2.end());
        
        int i = 0, j = 0;
        while (i < nums1.size() && j < nums2.size()) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                return nums1[i];
            }
        }
        
        if (i < nums1.size()) {
            return nums1[i] * 10 + nums2[0];
        } else {
            return nums1[0] * 10 + nums2[j];
        }
    }
};