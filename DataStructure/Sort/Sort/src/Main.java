import static java.util.Arrays.sort;

public class Main {
    public static void main(String[] args) {
        int[] a = {5, 3, 4, 2, 5, 1, 8, 5, 7, 6, 11, 5, 18, 97, 38, 55, 43, 76, 34, 76,99, 345, 5547, 225, 577, 255, 66, 23, 41, 62, 88};
        long time = System.nanoTime();
        InsertionSort.sort(a);
        System.out.println("Time execution: " + (System.nanoTime() - time) +"ns");
        for (int x : a) System.out.println(x);
    }
}
//Mergesort:                Time execution: 1725900ns
//Mergesort Improvement:    Time execution: 2576600ns
//Insertion Sort:           Time execution: 1610300ns