class Solution {
public:
    // Time complexity: O(n log n)
    // Space complexity: O(n)
    int minGroupsForValidAssignment(vector<int>& balls) {
        unordered_map<int, int> freq;
        int min_freq = INT_MAX;
        
        // Calculate the frequency of each number
        for (int ball : balls) {
            freq[ball]++;
            min_freq = min(min_freq, freq[ball]);
        }
        
        int ans = INT_MAX;
        
        // For each x in the range [1, minimum_frequency]
        for (int x = 1; x <= min_freq; x++) {
            int total_groups = 0;
            
            // For each distinct number
            for (auto& pair : freq) {
                int f = pair.second;
                int a = f / (x + 1);
                int b = f % (x + 1);
                
                // Calculate the minimum number of groups needed
                if (b == 0) {
                    total_groups += a;
                } else if (x - b <= a) {
                    total_groups += a + 1;
                } else {
                    break;
                }
            }
            
            // Update the answer
            if (total_groups != 0) {
                ans = min(ans, total_groups);
            }
        }
        
        return ans;
    }
};