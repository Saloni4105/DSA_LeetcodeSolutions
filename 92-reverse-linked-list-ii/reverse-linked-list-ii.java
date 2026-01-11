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
        if(head == null || head.next == null)
        {
            return head;
        }

        // cummy node
        ListNode temp = new ListNode(0);
        temp.next = head;

        // prev - just before left
        ListNode prev = temp;
        for(int i=1; i < left; i++)
        {
            prev = prev.next;
        }
        //  curr points - first node to reverse part
        ListNode curr = prev.next;

        // reverse node b/w left and right
        for(int i=1; i <= right - left; i++)
        {
            // curr first node
            ListNode Ntemp = prev.next;

            // curr = curr.next
            prev.next = curr.next;

            curr.next = curr.next.next;
            prev.next.next = Ntemp;
        }

        return temp.next;
    }
}