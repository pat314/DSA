import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
    // Write your code here
    String result = "";
    char array[] = s.toCharArray();
    if (s.charAt(8) == 'A')
    {
        if (s.charAt(0) == '1' && s.charAt(1) == '2')
        {
            array[0] = '0';
            array[1] = '0';
            for (int i = 0; i <8; i++) result += array[i];
        }
        else for (int i = 0; i <8; i++) result += array[i];
    }
    else if (s.charAt(8) == 'P')
    {
        if (s.charAt(0) == '0' && s.charAt(1) < '8')
        {
            array[0] = '1';
            array[1] += 2;
            for (int i = 0; i <8; i++) result += array[i];
        }
        else if (s.charAt(0) == '0' && s.charAt(1) == '8')
        {
            array[0] = '2';
            array[1] = '0';
            for (int i = 0; i <8; i++) result += array[i];
        }
        else if (s.charAt(0) == '0' && s.charAt(1) == '9')
        {
            array[0] = '2';
            array[1] = '1';
            for (int i = 0; i <8; i++) result += array[i];
        }
        else if (s.charAt(0) == '1' && s.charAt(1) <= '1')
        {
            array[0] += 1;
            array[1] += 2;
            for (int i = 0; i <8; i++) result += array[i];
        }
        else if (s.charAt(0) == '1' && s.charAt(1) == '2')
        {
            for (int i = 0; i <8; i++) result += array[i];
        }
    }
    return result;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
