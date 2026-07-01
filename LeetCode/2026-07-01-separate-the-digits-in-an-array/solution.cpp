class Solution {
public:
    // Time complexity: O(n*m) where n is the number of elements in nums and m is the maximum number of digits in an integer
    // Space complexity: O(n*m) for storing the result
    vector<int> separateDigits(vector<int>& nums) {
        vector<int> result;
        for (int num : nums) {
            string str = to_string(num);
            for (char c : str) {
                result.push_back(c - '0');
            }
        }
        return result;
    }
};