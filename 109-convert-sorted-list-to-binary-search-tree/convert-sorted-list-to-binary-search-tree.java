/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        int size = getSize(head);
        return createBST(head, 0, size-1);
    }

    private int getSize(ListNode head)
    {
        int count =0;
        while(head != null)
        {
            count++;
            head = head.next;
        }
        return count;
    }

    public TreeNode createBST(ListNode head, int si, int ei)
    {
        if(si > ei)
        {
            return null;
        }

        int mid = si + (ei - si) / 2;

        ListNode midNode = head;
        for(int i = si; i < mid; i++)
        {
            midNode = midNode.next;
        }

        TreeNode root = new TreeNode(midNode.val);
        root.left = createBST(head, si, mid-1);
        root.right = createBST(midNode.next, mid+1, ei);
        return root;
    }
}