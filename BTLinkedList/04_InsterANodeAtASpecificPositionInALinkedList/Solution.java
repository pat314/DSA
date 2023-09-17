//Iteration
    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
    // Write your code here
        SinglyLinkedListNode current = llist;
        SinglyLinkedListNode node = new SinglyLinkedListNode(data);
        int count_pos = 1;
        while (count_pos < position) {
            current = current.next;
            count_pos++;
        }
        SinglyLinkedListNode tmp = current.next;
        current.next = node;
        node.next = tmp;
        return llist;
    }

//Recursion
 public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
    // Write your code here
        if (position > 1) insertNodeAtPosition(llist.next, data, position-1);
        
        if (position == 1) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(data);
            SinglyLinkedListNode tmp = llist.next;
            llist.next = node;
            node.next = tmp;
        }
        return llist;
    }