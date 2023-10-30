public class Quicksort {
    public int partition(int[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        while (true) {
            while (a[++i] < a[lo]) {
                if (i == hi) break;
            }

            while (a[++j] > a[lo]) {
                if (j == lo) break;
            }

            if (i >= j) break;
            exchange(a, i, j);
        }
        exchange(a, lo, j);
        return j;
    }

    private void exchange(int[] a, int i, int j) {
        a[i] += a[j];
        a[j] = a[i] - a[j];
        a[i] = a[i] - a[j];
    }

    private void sort(int[] a, int lo, int hi) {
        //điều kiện dừng
        if (hi <= lo) return;

        int mid = partition(a, lo, hi);
        sort(a, lo, mid - 1);
        sort(a, mid + 1, hi);
    }

    public void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }
}
