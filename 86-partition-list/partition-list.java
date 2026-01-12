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
    public ListNode partition(ListNode head, int x) {
        
        // Two pointer- O(n)
        ListNode small = new ListNode(0);
        ListNode smallP = small;

        ListNode large = new ListNode(0);
        ListNode largeP = large;

        while(head != null)
        {
            if(head.val < x)
            {
                smallP.next = head;
                smallP = smallP.next;
            }
            else
            {
                largeP.next = head;
                largeP = largeP.next;
            }
            head = head.next;
        }
        smallP.next = large.next;
        largeP.next = null;
        return small.next;
    }
}