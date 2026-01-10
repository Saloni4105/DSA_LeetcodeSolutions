/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // hashMap approach time- O(n+m) Space -O(n)
        if(headA == null || headB == null)
        {
            return null;
        }

        HashMap<ListNode, Integer> map = new HashMap<>();

        ListNode temp = headA;
        while(temp != null)
        {
            map.put(temp, 1);
            temp = temp.next;
        }

        temp = headB;
        while(temp != null)
        {
            if(map.containsKey(temp))
            {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}