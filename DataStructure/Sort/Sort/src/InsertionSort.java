public class InsertionSort {
    public static void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int box = a[i];
            int j = i - 1;
            while (j >= 0 && box < a[j]) {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = box;
        }
    }
}
