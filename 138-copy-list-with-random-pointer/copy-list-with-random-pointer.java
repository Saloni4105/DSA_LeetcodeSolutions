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

    //  base case
        if(head == null)
        {
            return null;
        } 

        Node curr = head;

        // Insert copy node b/w orginal list
        while(curr != null)
        {
            Node nextNode = curr.next;//next of original node
            Node copy = new Node(curr.val); //new node
            curr.next = copy;
            copy.next = nextNode;
            curr = nextNode; //move to next original node
        }

        // assign random pointer to copy node

        curr = head;
        while(curr != null)
        {
            if(curr.random != null)
            {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        //  seperate original and copied list
        curr = head;
        Node newHead = head.next;
        Node newCurr = newHead;

        while(curr != null)
        {
            curr.next = curr.next.next;

            if(newCurr.next != null)
            {
                newCurr.next = newCurr.next.next;
            }   
            curr = curr.next;
            newCurr = newCurr.next;
        }
        return newHead;
    }
}