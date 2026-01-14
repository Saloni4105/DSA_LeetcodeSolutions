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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode temp = head;
        ListNode first = head;
        ListNode second = head;

        int length = 0;

        while(temp != null)
        {
            temp = temp.next;
            length++;
        }

        for(int i=1; i < k; i++)
        {
            first = first.next;
        }

        for(int i=1; i<length-k+1; i++)
        {
            second = second.next;
        }

        int t = first.val;
        first.val = second.val;
        second.val = t; 

        return head;
    }
}