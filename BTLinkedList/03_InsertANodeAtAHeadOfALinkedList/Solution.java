static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode head, int data) {
            SinglyLinkedListNode llist = new SinglyLinkedListNode(data);
            llist.next = head;
            return llist;

    }
