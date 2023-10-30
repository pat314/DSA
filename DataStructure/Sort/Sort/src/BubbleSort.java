public class BubbleSort {
    public void sort(int[] a) {
        for (int i = 0; i < a.length - 1; i ++) {
            boolean swap = false;
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j+1]) {
                    exchange(a, j, j+1);
                    swap = true;
                }
            }
            if (!swap) break;
        }
    }

    private void exchange(int[] a, int i, int j) {
        a[i] += a[j];
        a[j] = a[i] - a[j];
        a[i] = a[i] - a[j];
    }
}
