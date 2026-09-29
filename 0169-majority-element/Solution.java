// LeetCode 169: Majority Element
// https://leetcode.com/problems/majority-element/description/?envType=problem-list-v2&envId=divide-and-conquer

class Solution {
    public int majorityElement(int[] nums) {
        return majorityElementRec(nums,0,nums.length-1);
    }

    private int majorityElementRec(int[] nums, int left, int right) {

        // base case
        if(left == right) return nums[left];

        //divide
        int middle = left+(right-left)/2;

        // conquer
        int leftMajority = majorityElementRec(nums, left, middle);
        int rightMajority = majorityElementRec(nums, middle+1, right);

        if(leftMajority == rightMajority) return leftMajority;


        int leftCount = repeatCount(nums,leftMajority,left,right);
        int rightCount = repeatCount(nums,rightMajority,left,right);

        return (leftCount > rightCount) ? leftMajority : rightMajority;
    }

    // Helper: count how many times target appears in range
    private int repeatCount(int[] nums, int target, int left, int right) {
        int count = 0;
        for(int i=left;i<=right;i++) {
            if(nums[i]==target) {
                count++;
            }
        }

        return count;
    }
}