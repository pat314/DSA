//Iteration
static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
            SinglyLinkedListNode tmp = new SinglyLinkedListNode(data);
            SinglyLinkedListNode itr = head;
            if (itr == null) return tmp;
            while (itr.next != null) {
                itr = itr.next;
            }
            itr.next = tmp;
            return head;

    }

//Recursion
    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
            if (head == null) {
                SinglyLinkedListNode tmp = new SinglyLinkedListNode(data);
                return tmp;
            }
            if (head.next != null) insertNodeAtTail(head.next, data);
            if (head.next == null) {
                 SinglyLinkedListNode tmp = new SinglyLinkedListNode(data);
                 head.next = tmp;
            }
            return head;

    }