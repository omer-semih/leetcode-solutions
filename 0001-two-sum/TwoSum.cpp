// LeetCode 1: Two Sum
// https://leetcode.com/problems/two-sum/

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {

        vector<int> result;
        int size = nums.size();

        // Check every pair of elements
        for(int i=0;i<size;i++) {
            bool found=false;
            for(int j=i+1;j<size;j++) {
                // If the two elements sum to target, store their indices
                if(nums[i]+nums[j] == target) {
                    result.push_back(i);
                    result.push_back(j);
                    found = true;
                    break;
                }
            }
            // Stop early once the pair is found
            if(found) break;
        }
        return result;
    }
};