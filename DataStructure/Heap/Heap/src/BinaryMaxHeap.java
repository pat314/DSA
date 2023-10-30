public class BinaryMaxHeap {
    private int[] maxPQ;
    private int N;
    public BinaryMaxHeap(int capacity) {
        maxPQ = new int[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }


    //insert
    private void swim(int k) {
        while (k > 1 && maxPQ[k] > maxPQ[k/2]) {
            exchange(maxPQ, k, k/2);
            k /= 2;
        }
    }

    public void insert(int x) {
        maxPQ[++N] = x;
        swim(N);
    }

    private void exchange(int[] a, int i, int j) {
        a[i] += a[j];
        a[j] = a[i] - a[j];
        a[i] = a[i] - a[j];
    }

    //delete
    public void sink(int k) {
        while (2 * k <= N) {
            int j = k;
            if (2*j < N && maxPQ[j] < maxPQ[j+1]) j++;
            if (maxPQ[k] > maxPQ[j]) break;
            exchange(maxPQ, k, j);
            k = j;
        }
    }

    public void delete(int x) {
        int i;
        for (i = 1; i <= N; i++) {
            if (maxPQ[i] == x) break;
        }
        exchange(maxPQ, i, N--);
        sink(i);
    }

    public int peek() {
        return maxPQ[1];
    }
}
