    // Iteration
    static void printLinkedList(SinglyLinkedListNode head) {
        while (head != null)
        {
            System.out.println(head.data);
            head = head.next;
        }
    }

    //Recursion
    static void printLinkedList(SinglyLinkedListNode head) {
        if (head == null) return;
        System.out.println(head.data);
        printLinkedList(head.next);
    }


