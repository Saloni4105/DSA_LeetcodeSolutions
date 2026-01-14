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

    public ListNode mergeTwoList(ListNode l1, ListNode l2)
    {
        ListNode mergedLL = new ListNode(0);
        ListNode temp = mergedLL;

        while(l1 != null && l2 != null)
        {
            if(l1.val <= l2.val)
            {
                temp.next = l1;
                l1 = l1.next;
                temp = temp.next;
            }
            else
            {
                temp.next = l2;
                l2 = l2.next;
                temp = temp.next;
            }
        }

        while(l1 != null)
        {
            temp.next = l1;
            l1 = l1.next;
            temp = temp.next;
        }

        while(l2 != null)
        {
            temp.next = l2;
            l2 = l2.next;
            temp = temp.next;
        }
        return mergedLL.next;
    }

    private ListNode mergeRange(ListNode[] lists, int left, int right)
    {
        if(left == right)
        {
            return lists[left];
        }
        int mid = left + (right - left) /2;

        ListNode l1 = mergeRange(lists, left, mid);
        ListNode l2 = mergeRange(lists, mid+1, right);

            return mergeTwoList(l1, l2);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        
        // base case
        if(lists == null || lists.length == 0)
        {
            return null;
        }
        return mergeRange(lists, 0, lists.length -1);

    }
}