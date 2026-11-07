// LeetCode 217: Contains Duplicate
// https://leetcode.com/problems/contains-duplicate/description/

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        // Memory O(n), Time = O(n)
        for(int i=0;i<nums.length;i++) {
            // add() returns false when the value is already in the set
            if(!numbers.add(nums[i])) {
                return true;
            }
        }

        // Every value was unique
        return false;
    }
}

// Another approach is to sort the array O(nlogn) , then iterate through to check duplicates = O(n).
// Time complexity = O(nlogn) + O(n) = O(nlogn)
// Space complexity would be O(1)