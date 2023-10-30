public class PriorityQueue {
    private int[] pq;
    private int N;

    public PriorityQueue(int capacity) {
        pq = new int[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(int x) {
        pq[N++] = x;
    }

    public int delMax() {
        int max = 0;
        for (int i = 1; i < N; i++) {
            if (pq[max] < pq[i]) {
                max = i;
            }
        }
        exchange (pq, max, N-1);
        return pq[--N];
    }

    private void exchange(int[] a, int i, int j) {
        a[i] += a[j];
        a[j] = a[i] - a[j];
        a[j] = a[i] - a[j];
    }

}
