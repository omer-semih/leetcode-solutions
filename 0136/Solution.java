// LeetCode 136: Single Number
// https://leetcode.com/problems/single-number/description/

class Solution {
    public int singleNumber(int[] nums) {
    /*
    * If you XOR two identical numbers, they cancel each other out and yield zero.
    * Since XOR is commutative and associative, element order does not matter.
    * Thus, runningXor will hold the single number after iterating through the array
    */
        int runningXOR = 0;
        for(int i=0;i<nums.length;i++) {
            runningXOR ^= nums[i];
        }

        return runningXOR;
    }
}