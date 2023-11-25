import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'missingNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER_ARRAY brr
     */

    //using hash table and counting sort. O()
    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
    // Write your code here
        Hashtable<Integer, Integer> hashtableB = new Hashtable<>();
        List<Integer> result = new ArrayList<>();

        //initialize the hash table (like a map) of frequency        
        for (int x : brr) {
            if (!hashtableB.containsKey(x)) hashtableB.put(x, 0);
        }
        //count the frequency of elements in brr
        for (int x : brr) hashtableB.put(x, hashtableB.get(x) + 1);
        //subtract to the frequency of elements appear in arr, if value != 0,
        //it means that key í missing number 
        for (int x : arr) hashtableB.put(x, hashtableB.get(x) - 1);
        
        for (Integer key : hashtableB.keySet()) {
            if (hashtableB.get(key) > 0) result.add(key);
        }
        //sort like requirement
        Collections.sort(result);
        
        return result;

    }

}

public class Solution13 {
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

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        String[] brrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> brr = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int brrItem = Integer.parseInt(brrTemp[i]);
            brr.add(brrItem);
        }

        List<Integer> result = Result.missingNumbers(arr, brr);

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
