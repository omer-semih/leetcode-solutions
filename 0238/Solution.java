// LeetCode 238: Product of Array Except Self
// https://leetcode.com/problems/product-of-array-except-self/description/

class Solution {
    // Question definitions says : The output array does not count as extra space for space complexity analysis.
    // Memory O(1), Time O(n)+O(n) = O(n)
    public int[] productExceptSelf(int[] nums) {

        int[] answer = new int[nums.length];

        // Left pass: answer[i] = product of everything before i
        int leftProduct = 1;
        for(int i=0;i<nums.length;i++) {
            answer[i] = leftProduct;
            leftProduct*=nums[i];
        }
        
        // Right pass: multiply in the product of everything after i
        int rightProduct = 1;
        for(int i=nums.length-1;i>=0;i--) {
            answer[i] *= rightProduct;
            rightProduct*=nums[i];
        }

        return answer;
    }
}

/*
MY OTHER APPROACH, DO EVERYTHING IN ONE PASS

class Solution {
    public int[] productExceptSelf(int[] nums) {

        int[] answer = new int[nums.length];

        int prefixProd=1;
        int suffixProd=1;
        int length = nums.length;

        for(int i=0;i<length;i++) {
            if(i < length-1-i ) {
                answer[i] = prefixProd;
                answer[length-1-i] = suffixProd;
                prefixProd *= nums[i];
                suffixProd *= nums[length-1-i];
            }
            else if(i == length-1-i ) {
                answer[i] = suffixProd*prefixProd;
                prefixProd *= nums[i];
                suffixProd *= nums[i];
            }
            else {
                answer[i] *= prefixProd;
                answer[length-1-i] *= suffixProd;
                prefixProd *= nums[i];
                suffixProd *= nums[length-1-i];
            }
        }
        
        return answer;
    }
} 
*/