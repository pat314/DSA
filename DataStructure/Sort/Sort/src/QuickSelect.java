public class QuickSelect {
    public static int select(int[] a, int k) { // k là vị trí của số 1 lấy
        int lo = 0;
        int hi = a.length - 1;

        while (hi > lo) {
            int j = partition(a, lo, hi);
            if (j < k) lo = j + 1;
            else if (j > k) hi = j - 1;
            else return a[k];
        }
        return a[k];
    }

    private static int partition(int[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        while (true) {
            while (a[++i] < a[lo]) {
                if (i == hi) break;
            }
            while (a[--j] > a[lo]) {
                if (j == lo) break;
            }
            if (i >= j) break;
            exchange(a, i, j);
        }
        exchange(a, lo, j);
        return j;
    }

    private static void exchange(int[] a, int i, int j) {
        a[i] += a[j];
        a[j] = a[i] - a[j];
        a[i] = a[i] - a[j];
    }
}
