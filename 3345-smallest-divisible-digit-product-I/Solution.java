// LeetCode 3345: Smallest Divisible Digit Product I
// https://leetcode.com/problems/smallest-divisible-digit-product-i/description/

// try every number starting from n until one works

class Solution {
    public int smallestNumber(int n, int t) {

        while(true) {
            int product = 1;
            int temp_n = n;

            // multiply all digits of n
            while(temp_n != 0) {
                product *= temp_n%10;   // last digit
                temp_n /= 10;           // drop last digit
            }

            // digit product divisible by t -> found it
            if(product%t == 0){
                return n;
            }

            n++;   // try the next number
        }

    }
}
