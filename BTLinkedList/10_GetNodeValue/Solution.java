//Iteration
    public static int getNode(SinglyLinkedListNode llist, int positionFromTail) {
    // Write your code here
        SinglyLinkedListNode tmp = llist;
        int length = 0;
        while (tmp != null) {
            tmp = tmp.next;
            length++;
        }
        
        
        
        int positionFromHead = length - positionFromTail - 1;
        int value;
        while (positionFromHead > 0) {
            llist = llist.next;
            positionFromHead--;
        }
        value = llist.data;
        return value;
    }

//Recursion
    public static int getNode(SinglyLinkedListNode llist, int positionFromTail) {
    // Write your code here
        int result = 0;
        SinglyLinkedListNode tmp = llist;
        int length = 0;
        while (tmp != null) {
            tmp = tmp.next;
            length++;
        }
        if (length - positionFromTail - 1 > 0) result = getNode(llist.next, positionFromTail);
        if (length - positionFromTail - 1 == 0) result = llist.data;
        return result;
    }