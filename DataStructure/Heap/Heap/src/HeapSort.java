public class HeapSort {
    public static void sort(int[] a) {
        int N = a.length;
        //tạo ta 1 heap từ 1 array
        for (int k = N/2; k >= 1; k--) {
            sink(a, k, N);
        }
        while (N > 1) {
            exchange(a, 1, N);
            sink(a, 1, --N);
        }
    }

    public static void sink(int[] a, int k, int N) {
        while (2 * k <= N) {
            int j = k;
            if (2 * j < N && a[j] < a[j+1]) {
                j++;
            }
            if (a[j] < a[k]) break;
            exchange(a, j, k);
            k = j;
        }
    }

    public static void exchange(int[] a, int i, int j) {
        a[i] += a[j];
        a[j] = a[i] - a[j];
        a[i] = a[i] - a[j];
    }
}
