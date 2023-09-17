//iteration
public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {
    // Write your code here
        
        //xoa dau
        if (position == 0)
        {
            SinglyLinkedListNode tmphead = llist;
        llist = llist.next;
        tmphead = null;
        return llist;
        }
        
        //xoa giua - cuoi
        SinglyLinkedListNode head = llist;
        int count = 1;
        while (count < position) {
            llist = llist.next;
            count++;
        }
        SinglyLinkedListNode tmp = llist.next;
        llist.next = tmp.next;
        tmp = null;
        return head;

    }

//recursion
    public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {
    // Write your code here
        
        //xoa dau
        if (position == 0)
        {
            SinglyLinkedListNode tmphead = llist;
        llist = llist.next;
        tmphead = null;
        return llist;
        }
        
        //xoa giua - cuoi
        if (position > 1) deleteNode(llist.next, position-1);
        if (position == 1) {
            SinglyLinkedListNode tmp = llist.next;
            llist.next = tmp.next;
            tmp = null;
        }
                
        return llist;

    }