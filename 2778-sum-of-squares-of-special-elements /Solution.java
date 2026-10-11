// LeetCode 2778: Sum of Squares of Special Elements 
// https://leetcode.com/problems/sum-of-squares-of-special-elements/description/?envType=daily-question&envId=2026-10-11


class Solution {
    public int sumOfSquares(int[] nums) {
        int n = nums.length, sum=0;

        // find all divisors of length=n , and add its square to the sum
        for(int i=1; i<=Math.sqrt(n); i++) {
            if(n%i == 0){
                sum+= Math.pow(nums[i-1],2);
                // preventing double addition if the square of the divisor equals n 
                if(i != n/i) sum+= Math.pow(nums[n/i-1],2);  
            }
        }

        return sum;
    }
}