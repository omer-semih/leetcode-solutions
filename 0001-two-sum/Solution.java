// LeetCode 1: Two Sum
// https://leetcode.com/problems/two-sum/

class Solution {
    public int[] twoSum(int[] nums, int target) {

        // Maps every value seen so far to its index
        HashMap<Integer, Integer> indices = new HashMap<>();

        // Single pass: check for the complement before storing the current value
        for(int i=0;i<nums.length;i++) {
            if(indices.containsKey(target-nums[i])) {
                return new int[] {indices.get(target-nums[i]),i};
            }
            indices.put(nums[i],i);
            
        }

        // No pair sums to target
        return new int[] {};
    }
}