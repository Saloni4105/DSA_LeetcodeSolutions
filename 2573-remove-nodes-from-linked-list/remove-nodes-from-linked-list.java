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

    private ListNode reverseList(ListNode head)
    {
        if(head == null || head.next == null)
        {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        while(curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev= curr;
            curr = next;
        }
        head = prev;
        return head;
    }

    public ListNode removeNodes(ListNode head) {

        head = reverseList(head);

        int maximum = 0;
        ListNode prev = null;
        ListNode current = head;

        while(current != null)
        {
            maximum = Math.max(maximum, current.val);

            if(current.val < maximum)
            {
                if(prev == null)
                {
                    head = current.next;
                    current = head;
                }
                else
                {
                    prev.next = current.next;
                    current = current.next;
                }
            }
            else
            {
                prev = current;
                current = current.next;
            }
        }    
        return reverseList(head);    
    }
}