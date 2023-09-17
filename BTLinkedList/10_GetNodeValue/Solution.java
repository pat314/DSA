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
