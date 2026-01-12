/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        // base case
        if(head == null)
        {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();

        Node curr = head;// traverse original list
        Node newHead = null; //head of copied list
        Node prev = null; //previous nodw in copied list

        // copy all nodes and next pointer
        while(curr != null)
        {
            Node copy = new Node(curr.val);
            map.put(curr, copy);

            if(newHead == null)
            {
                newHead = copy;
                prev= copy;
            }
            else{
                prev.next = copy;
                prev = copy;
            }

            curr = curr.next;
        }

        // copy random pointer
        curr = head;
        Node newCurr = newHead;

        while(curr != null)
        {
            if(curr.random == null)
            {
                newCurr.random = null;
            }
            else
            {
                newCurr.random = map.get(curr.random);
            }
            curr = curr.next;
            newCurr = newCurr.next;
        }
        return newHead;
    }
}