
public class QueueLinkedList {
    private Node first, last;

    private class Node {
        int item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(int item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldlast.next = last;
    }

    public int dequeue() {
        int item = first.item;
        first = first.next;

        if (isEmpty()) last = null;
        return item;
    }
}
