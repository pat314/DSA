import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'insertionSort2' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort2(int n, List<Integer> arr) {
    // Write your code here
        int [] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = arr.get(i);
        }
        for (int i = 1; i < n; i++) {
            int box = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > box) {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = box;
            for (int x : a) System.out.print(x + " ");
            System.out.println();
        }

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        Result.insertionSort2(n, arr);

        bufferedReader.close();
    }
}
