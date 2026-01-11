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
    public ListNode swapPairs(ListNode head) {

        if(head == null || head.next == null)
        {
            return head;
        }
        ListNode temp = head.next; //B
        head.next = swapPairs(head.next.next); //A ka next
        temp.next = head; // b ke next me A
        return temp;
    }
}