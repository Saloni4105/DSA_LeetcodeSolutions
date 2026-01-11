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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        // base case
        if(head == null || left == right)
        {
            return head;
        }

        // dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // prev - just before left
        ListNode prev = dummy;
        for(int i=1; i < left; i++)
        {
            prev = prev.next;
        }
        
        ListNode prevNode = null;
        ListNode curr= prev.next;
        ListNode next;

        for(int i=left; i<=right; i++)
        {
            next = curr.next;
            curr.next = prevNode;
            prevNode = curr;
            curr = next;
        }

        prev.next.next = curr; //add with right list
        prev.next = prevNode; // add with left list

        return dummy.next;
    }
}