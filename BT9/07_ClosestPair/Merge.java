import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'closestNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> closestNumbers(List<Integer> arr) {
        // Write your code here
        int min_diff = 32767; //INT MAX
        int[] aux = new int[arr.size()];
        sort(arr, aux, 0, arr.size() - 1);

        List <Integer> result = new ArrayList<Integer>();
        for (int i = 1; i < arr.size(); i++)
        {
            if (arr.get(i) - arr.get(i-1) < min_diff) {
                min_diff = arr.get(i) - arr.get(i-1);
            }
        }

        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) - arr.get(i-1) == min_diff)
            {
                result.add(arr.get(i-1));
                result.add(arr.get(i));
            }
        }
        return result;
    }

    private static void merge(List<Integer> a, int[] aux, int lo, int mid, int hi) {
        //copying
        for (int i = lo; i <= hi ; i++) aux[i] = a.get(i);

        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if      (i > mid)                   a.set(k, aux[j++]);
            else if (j > hi)                    a.set(k, aux[i++]);
            else if (aux[j] < aux[i])           a.set(k, aux[j++]);
            else                                a.set(k, aux[i++]);
        }
    }

    private static void sort(List<Integer> a, int[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        //sort first - half array
        if (lo < mid) sort(a, aux, lo, mid);
        //sort latter-half array
        sort(a, aux, mid + 1, hi);
        //merge two sorted array
        merge(a, aux, lo, mid, hi);
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        List<Integer> result = Result.closestNumbers(arr);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
