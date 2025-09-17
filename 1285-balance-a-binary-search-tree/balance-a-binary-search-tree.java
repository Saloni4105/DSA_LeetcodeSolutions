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
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        inOrder(root, res);

        // sorted inOrder - balanced bst
        root = createBST(res, 0, res.size()-1);
        {
            return root;
        }
    }
    void inOrder(TreeNode root, ArrayList<Integer> res)
    {
        if(root == null)
        {
            return;
        }
        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);
    }

    public TreeNode createBST(ArrayList<Integer> res, int st, int end)
    {
        if(st > end)
        {
            return null;
        }
        int mid = st + (end - st)/2;
        TreeNode root = new TreeNode(res.get(mid));
        root.left = createBST(res, st, mid-1);
        root.right = createBST(res, mid+1, end);
        return root;
    }
}