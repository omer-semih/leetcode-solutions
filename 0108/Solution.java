// LeetCode 108: Convert Sorted Array to Binary Search Tree
// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return recursiveConvert(nums,0,nums.length-1);
    }

    private TreeNode recursiveConvert(int[] nums, int left, int right) {
        if(left > right) {
            return null;
        }

        // Divide
        int mid = left + (right-left)/2;

        // Recursively Conquer
        TreeNode leftRoot = recursiveConvert(nums,left,mid-1);
        TreeNode rightRoot = recursiveConvert(nums,mid+1,right);

        // Combine
        TreeNode root = new TreeNode(nums[mid],leftRoot,rightRoot);
        return root;
    }
}