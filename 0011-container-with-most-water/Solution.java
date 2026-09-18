// LeetCode 11: Container With Most Water 
// https://leetcode.com/problems/container-with-most-water/description/

class Solution {

    public int maxArea(int[] height) {
        // Pointers at both ends of the array
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while(left < right) {
            // Find the limiting shorter line
            int smallEdge = (height[left] <= height[right]) ? height[left] : height[right];

            // Update maximum water area found so far
            if( (right-left)*smallEdge > maxArea) {
                maxArea = (right-left)*smallEdge;
            }

            // Skip lines that are smaller or equal to the current short line
            if(height[left] < height[right]) {
                while(left<right && height[left] <= smallEdge) left++;
                
            }
            else {
                while(left<right && height[right] <= smallEdge) right--;
            }
        }

        return maxArea;
    }


    public static void main(String[] args) {

        int[] height = {1,8,6,2,5,4,8,3,7};
        Solution object = new Solution();
        System.out.println(object.maxArea(height));

    }
}