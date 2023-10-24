import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static void LomutoPartitioning(List<Integer> arr, int lo, int hi) {
        int pivot = arr.get(hi);
        int i = lo;
        for (int j = lo; j <= hi - 1; j++) {
            if (arr.get(j) <= pivot) {
                int tmp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, tmp);
                i++;
            }
        }
        int tmp = arr.get(i);
        arr.set(i, arr.get(hi));
        arr.set(hi, tmp);
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}
