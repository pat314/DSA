//Iterator
public static void reversePrint(SinglyLinkedListNode llist) {
    // Write your code here
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
        while (center != null) {
            System.out.println(center.data);
            center = center.next;
        }

    }

//Recursion
    public static void reversePrint(SinglyLinkedListNode llist) {
    // Write your code here
        if (llist.next != null) reversePrint(llist.next);
        System.out.println(llist.data);

    }