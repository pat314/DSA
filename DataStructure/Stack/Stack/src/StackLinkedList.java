public class StackLinkedList {
    private Node first = null;

    private static class Node {
        int item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(int item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    public int pop() {
        if (!isEmpty()) {
            int item = first.item;
            first = first.next;
            return item;
        }
        return -1;
    }
}
