import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'runningMedian' function below.
     *
     * The function is expected to return a DOUBLE_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static List<Double> runningMedian(List<Integer> a) {
        List<Double> result = new ArrayList<>();
        Queue<Integer> maxQueue = new PriorityQueue<Integer>(a.size()/2 + 1, Collections.reverseOrder());
        Queue<Integer> minQueue = new PriorityQueue<>();
        int index = 0;

        for (int x : a) {
            if (index % 2 == 0) {
                maxQueue.add(x);
            } else {
                minQueue.add(x);
            }

            
            if (!minQueue.isEmpty() && minQueue.peek() < maxQueue.peek()) {
                int min = minQueue.remove();
                int max = maxQueue.remove();
                minQueue.add(max);
                maxQueue.add(min);
            }

            
            if (index % 2 == 0) {
                result.add(maxQueue.peek()*1.0);
                
            }
            else {
                result.add((minQueue.peek()*1.0 + maxQueue.peek()*1.0) / 2.0);
            } 
            index++;
        }
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < aCount; i++) {
            int aItem = Integer.parseInt(bufferedReader.readLine().trim());
            a.add(aItem);
        }

        List<Double> result = Result.runningMedian(a);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
