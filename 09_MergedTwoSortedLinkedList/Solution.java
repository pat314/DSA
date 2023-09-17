//iteration
static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode head = null;
        SinglyLinkedListNode itr = null;
        if (head1.data < head2.data) {
            head = head1;
            itr = head1;
            head1 = head1.next;
        } else {
            head = head2;
            itr = head2;
            head2 = head2.next;
        }
        
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                itr.next = head1;
                itr = itr.next;
                head1 = head1.next;
                
            } else {
                itr.next = head2;
                itr = itr.next;
                head2 = head2.next;
            }
        }
        while (head1 != null) {
            itr.next = head1;
            itr = itr.next;
            head1 = head1.next;
        }
        while (head2 != null) {
            itr.next = head2;
            itr = itr.next;
            head2 = head2.next;
        }
        return head;
    }


//recursion
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode head = null;
        if (head1 == null) head = head2;
        if (head2 == null) head = head1;
        
        if (head1 != null && head2 != null)
        {
            if (head1.data < head2.data) {
                head = head1;
                head.next = mergeLists(head1.next, head2);
            }
            else {
                head = head2;
                head.next = mergeLists(head1, head2.next);
            };
        }
        
        return head;
    }