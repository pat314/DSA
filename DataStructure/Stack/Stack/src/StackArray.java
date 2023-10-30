public class StackArray {
    private int[] a;
    int N = 0;

    public StackArray() {
        a = new int[4];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(int item) {
        //grow array: when array is full, double the array
        if (N == a.length) resize(2 * a.length);
        a[N++] = item;
    }

    public int pop() {
        if (!isEmpty()) {
            int item = a[--N];

            //shrinking array: halve size of array when array is one - quarter full
            if (N > 0 && N == toString().length() / 4) resize(a.length / 2);
            return item;
        }
        return -1;
    }

    private void resize(int capacity) {
        int[] copy = new int[capacity];
        for (int i = 0; i < N; i++) {
            copy[i] = a[i];
        }
        a = copy;
    }


}
