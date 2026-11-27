// LeetCode 66: Plus One
// https://leetcode.com/problems/plus-one/

class Solution {
    public int[] plusOne(int[] digits) {

        // Start from the last digit
        int carry,length = digits.length-1;

        // Keep going left as long as the digit overflows
        do {
        // Adding one overflows only when the digit is 9
        carry = ((digits[length]+1) == 10) ? 1 : 0;

        if(carry == 0) {
            digits[length]++;
            return digits;
        }
        else {
            // The digit turns into 0 and the carry moves one step left
            digits[length] = 0;
        }

        length--;

        } while(length >= 0);

        // Every digit was 9, so the answer is 1 followed by zeros
        int[] output = new int[digits.length + 1];
        output[0] = 1;

        return output;
    }
}