class MyLinkedList {

    private class ListNode{
        int val;
        ListNode next;

        public ListNode(int val)
        {
            this.val = val;
        }
    }

        private ListNode head;
        private ListNode tail;
        private int size;

        public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    
    public int get(int index) {
        if(index < 0 || index >= size)
        {
            return -1;
        }
        ListNode curr = head;
        for(int i=0; i< index; i++)
        {
            curr = curr.next;
        }
        return curr.val;
    }
    
    public void addAtHead(int val) {

        ListNode newNode = new ListNode(val);
        if(head == null)
        {
            head = tail = newNode;
        }else{
        newNode.next = head;
        head = newNode;
        }
        size++;
    }
    
    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);

        if(head == null)
        {
            head = tail = newNode;
        }
        else{
        tail.next = newNode;
        tail = newNode;
        }
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        
        if(index < 0 || index > size) return;
        if(index == 0)
        {
            addAtHead(val);
            return;
        }

         if (index == size) {
            addAtTail(val);
            return;
        }

        ListNode newNode = new ListNode(val);
        ListNode temp = head;
        int i= 0;
        while(i < index-1)
        {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        
        if(index < 0 || index >= size)
        {
            return;
        }

        if(index == 0)
        {
            head = head.next;
            if(size == 1)
            {
                tail = null;
            }
        }else{
                ListNode curr = head;
        
                for(int i=0; i< index-1; i++)
                {
                    curr = curr.next;
                }
                curr.next = curr.next.next;
                if (index == size - 1)
                { 
                    tail = curr;
                }
        }
         size--;
    }  
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */