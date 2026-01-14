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
    public ListNode[] splitListToParts(ListNode head, int k) {

        int length=0;
        ListNode temp = head;

        while(temp != null)
        {
            temp = temp.next;
            length++;
        }

        int eachPart = length / k;
        int extraNode = length % k;

        ListNode[] res = new ListNode[k];

        ListNode prev = null;
        ListNode curr = head;

        for(int i=0; curr != null && i< k; i++)
        {
            res[i] = curr;
            for(int count =1; count <= eachPart + (extraNode > 0 ? 1: 0); count++)
            {
                prev = curr;
                curr = curr.next;
            }

            if(prev != null)
            {
                prev.next = null;
            }
            extraNode--;
        }
        
        return res;
    }
}