public class QueueArray {
    int SIZE = 5;
    int[] items = new int [SIZE];

    int front, rear;

    public QueueArray() {
        front = -1;
        rear = -1;
    }

    public boolean isFull() {
        return (front == 0) && (rear == SIZE - 1);
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public void enqueue(int element) {
        if (front == -1) front = 0;
        items[++rear] = element;
    }

    public int dequeue() {
        int element;
        if (isEmpty()) return -1;
        else element = items[front];
        if (front >= rear) front = rear = -1;
        else front++;
        return element;
    }
}
