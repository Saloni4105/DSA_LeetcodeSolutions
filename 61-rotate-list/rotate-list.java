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
    public ListNode rotateRight(ListNode head, int k) {

        if(head == null || head.next == null || k==0)
        {
            return head;
        }
        int length = 1;
        ListNode temp = head;

        // find length
        while(temp.next != null)
        {
            temp = temp.next;
            length++;
        }    
        // make a circular list
        temp.next = head;

        k = k % length;

        // new tail find
        int stepsToNewTail = length-k;
        ListNode newTail = head;

        for(int i=1; i< stepsToNewTail; i++)
        {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}