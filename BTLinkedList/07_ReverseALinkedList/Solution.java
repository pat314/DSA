//iteration
    public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
    
        SinglyLinkedListNode before = llist;
        SinglyLinkedListNode center = llist.next;
        SinglyLinkedListNode after = center.next;
        while (center.next != null) {
            center.next = before;
            before = center;
            center = after;
            after = after.next;
        }
        
        center.next = before;
        
        llist.next = null;
        return center;

    }

//recursion
public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
    //if linked list is null or linked list has only one element
    //so the reverse of linked list is the original linked list
    if (llist == null || llist.next == null) return llist;
    
    //we create a node that hold the head of the linked list
    //after every recursion
    SinglyLinkedListNode newHeadNode = reverse(llist.next);
    //in each recursion, we reverse the connection of each elements
    llist.next.next = llist;
    llist.next = null;
    //return the head (the latter node) of the linked list after 
    //every recursion
    return newHeadNode;
}

