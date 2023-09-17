//iteration    
    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        while (head1 != null && head2 != null) {
            if (head1.data != head2.data) return false;
            head1 = head1.next;
            head2 = head2.next;
        }
        if (head1 != null || head2 != null) return false;
        return true;
    }

//recursion
    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if (head1 != null && head2 != null){
            if (head1.data != head2.data) return false;
            
        }
        
        if ((head1 != null && head2 == null) || (head1 == null && head2 != null)) 
        return false;
        if (head1 == null && head2 == null) return true; 
        boolean result = compareLists(head1.next, head2.next);
        return result;
    }
