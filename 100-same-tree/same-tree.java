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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q== null)
        {
            return true; //if both are null
        }

        if(p == null || q== null)
        {
            return false; //if only one null
        }
        if(p.val != q.val)
        {
            return false; // if values are not same
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right); //left and right are recursively call
    }
}