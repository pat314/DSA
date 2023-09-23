import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
    // Write your code here
    //ý tưởng bài toán: đầu tiên ta tính tổng chiều cao của từng stack, sau đó kiểm tra chừng nào các stack chưa bằng nhau, thì ta sẽ loại đi 1 phần tử của stack có chiều cao cao nhất (credit: Trần Minh Tuấn)
        int sum1 = 0, sum2 = 0, sum3 = 0;
        for (int x: h1) sum1 += x;
        for (int x: h2) sum2 += x;
        for (int x: h3) sum3 += x;
        int i = 0, j = 0, k = 0;
        
        while (!(sum1 == sum2 && sum2 == sum3)) {
            if (sum1 > sum2 || sum1 > sum3)         sum1 -= h1.get(i++);
            else if (sum2 > sum1 || sum2 > sum3)    sum2 -= h2.get(j++);
            else if (sum3 > sum2 || sum3 > sum1)    sum3 -= h3.get(k++);
        }
        return sum1;

}
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        String[] h1Temp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> h1 = new ArrayList<>();

        for (int i = 0; i < n1; i++) {
            int h1Item = Integer.parseInt(h1Temp[i]);
            h1.add(h1Item);
        }

        String[] h2Temp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> h2 = new ArrayList<>();

        for (int i = 0; i < n2; i++) {
            int h2Item = Integer.parseInt(h2Temp[i]);
            h2.add(h2Item);
        }

        String[] h3Temp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> h3 = new ArrayList<>();

        for (int i = 0; i < n3; i++) {
            int h3Item = Integer.parseInt(h3Temp[i]);
            h3.add(h3Item);
        }

        int result = Result.equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
