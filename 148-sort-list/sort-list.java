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
class Solution {
    public ListNode sortList(ListNode head) {

        // base case
        if(head == null || head.next == null)
        {
            return head;
        }
        // find mid node
        ListNode mid = midNode(head);
        ListNode rightNode = mid.next;
        mid.next = null;

        // Merge sorted list 
        ListNode left = sortList(head);
        ListNode right = sortList(rightNode);

        return merge(left, right);
   }

   public ListNode midNode(ListNode head)
   {
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
   }

   ListNode merge(ListNode left, ListNode right)
   {
        ListNode mergedLL = new ListNode(0);
        ListNode temp = mergedLL;

        while(left != null && right != null)
        {
            if(left.val < right.val)
            {
                temp.next = left;
                temp = temp.next;
                left = left.next;
            }
            else
            {
                temp.next = right;
                temp = temp.next;
                right = right.next;
            }
        }

        while(left != null)
        {
            temp.next = left;
            left = left.next;
            temp = temp.next;
        }

        while(right != null)
        {
            temp.next = right;
            temp = temp.next;
            right = right.next;
        }
        return mergedLL.next;
   }
}