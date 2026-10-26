// LeetCode 191: Number of 1 Bits
// https://leetcode.com/problems/number-of-1-bits/description/?envType=problem-list-v2&envId=divide-and-conquer

class Solution {
    public int hammingWeight(int n) {
        return hammingWeightRecursive(n,0,31);
    }

    private int hammingWeightRecursive(int n, int left, int right) {
        // Base case
        if(left==right) {
            /* 
            *   "left" times bitwise right shift 
            *   to check if the bit in index left is 1 
            */
            return (n >> left) & 1;
        }
        
        // Divide
        int mid = left + (right-left) / 2;
        
        // Conquer
        int weightOfLeft = hammingWeightRecursive(n,left,mid);
        int weightOfRight = hammingWeightRecursive(n, mid+1, right);

        // Combine
        return weightOfLeft + weightOfRight;
    }

}