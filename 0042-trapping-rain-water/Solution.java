// LeetCode 42: Trapping Rain Water
// https://leetcode.com/problems/trapping-rain-water/description/

/*
     * ALGORITHM EXPLANATION (Two Pointers Approach):
     * -------------------------------------------------------------------------
     * 1. The amount of water trapped above any column depends on leftMax and rightMax
     *    Forumula : Water at i = min(leftMax, rightMax) - height[i]
     * 
     * 2. We place two pointers at the ends (l = 0, r = length - 1).
     * 
     * 3. At each step, we compare leftMax and rightMax:
     *    - If leftMax < rightMax, the bottleneck is on the left side. We are 
     *      guaranteed that a wall higher than leftMax exists on the right, so 
     *      the water level at 'l' is purely bounded by leftMax.
     *      Whether or not there is an even higher wall to the right of `right_max` 
     *      is completely irrelevant to the water at the `left` position! This is because, 
     *      in any case, the water will spill over from the shorter side (`left_max`).
     * 
     *    - Otherwise, the bottleneck is on the right side, bounded by rightMax.
     * 
     * 4. By updating the max wall FIRST and then adding (max - currentHeight), 
     *    we dynamically add trapped water if it's a pit, or add 0 if it's a new max wall.
     */

class Solution {
    public static int trap(int[] height) {
        int l = 0, r = height.length-1;
        int leftMax = height[l], rightMax = height[r];
        int totalWater = 0;

        while(l<=r) {
            if(leftMax < rightMax) {
                if(height[l] >= leftMax) leftMax = height[l];
                totalWater += leftMax-height[l]; // becomes 0 if currentHeight becomes the new leftMax
                l++;
            }
            else {
              if(height[r] >= rightMax) rightMax = height[r];
                totalWater += rightMax-height[r]; // becomes 0 if currentHeight becomes the new rightMax
                r--;  
            }
        }

        return totalWater;
    }



    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int expected = 6;

        int actual = trap(height);

        System.out.println("Status   : " + (actual == expected ? "PASSED [OK]" : "FAILED [X]"));
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
    }
}