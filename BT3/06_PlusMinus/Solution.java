import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        int N = arr.size();
        int p = 0, n = 0, z = 0;
        for (int i = 0; i < arr.size(); i++)
        {
            if (arr.get(i) > 0) p++;
            else if (arr.get(i) < 0) n ++;
            else z++;
        }
        System.out.printf("%.6f\n", (p*1.0)/N);
        System.out.printf("%.6f\n", (n*1.0)/N);
        System.out.printf("%.6f\n", (z*1.0)/N);
    // Write your code here

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

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
