public class Mergesort {

    //private final static int CUTOFF = 7;
    private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            aux[i] = a[i];
        }

        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)           a[k] = aux[j++];
            else if (j > hi)            a[k] = aux[i++];
            else if (aux[j] < aux[i])   a[k] = aux[j++];
            else                        a[k] = aux[i++];
        }
    }

    private static void sort(int[] a, int[] aux, int lo, int hi) {
        //cải tiến 1: nếu mảng có số lượng phần tử nhỏ hơn 1 lượng nào đó thì ta sẽ sử dụng insertion sort
        // thay cho merge sort vì nếu dùng mergesort sẽ tốn thời gian hơn khi n nhỏ.
        // Và chọn insertion sort mà không phải selection sort vì insertion sort và merge sort là stable sort.
        if (hi <= lo /*+ CUTOFF - 1*/) {
            //InsertionSort.sort(a);
            return;
        }

        int mid = lo + (hi - lo)/2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        //Cải tiến 2: Nếu 2 nửa dãy đã đúng vị trí thì là không cần thực hiện merge nữa
        //if (a[mid+1] >= a[mid]) return;
        merge(a, aux, lo, mid, hi);
    }

    public static void sort(int[] a) {
        int[] aux = new int[a.length];
        sort(a, aux, 0, a.length - 1);
    }
}
