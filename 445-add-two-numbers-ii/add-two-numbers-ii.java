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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // reverse both list
        l1 = reverseLL(l1);
        l2 = reverseLL(l2);

        int sum =0, carry = 0;
        ListNode ans = new ListNode(); //dummy node for result

        // add digit from both lists
        while(l1 != null || l2 != null)
        {
            if(l1 != null)
            {
                sum += l1.val;
                l1 = l1.next;
            }

            if(l2 != null)
            {
                sum += l2.val;
                l2 = l2.next;
            }

            ans.val = sum % 10;
            carry = sum / 10;

            // create new node for carry and attach it in front
            ListNode newNode = new ListNode(carry);
            newNode.next = ans;
            ans = newNode;

            sum = carry;
        }

        // return res
        return carry == 0 ? ans.next : ans;

    }

    public ListNode reverseLL(ListNode head)
    {
        if(head == null || head.next == null)
        {
            return head;
        }

        ListNode last = reverseLL(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}