import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Cach 1:
     */

    public static String isBalanced(String s) {
        while (true) {
            String originalString = s;
            s = s.replace("()", "");
            s = s.replace("{}", "");
            s = s.replace("[]", "");
            
            if (s.length() == originalString.length()) break;
        }
        if (s.length() > 0) return "NO";
        return "YES";
    // Write your code here

    }
    /*Cach 2:
     */((((({{{}}})))))
        public static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        int i;
        for (i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push('(');
            else if (s.charAt(i) == '[') stack.push('[');
            else if (s.charAt(i) == '{') stack.push('{');
            
            else if (stack.isEmpty()) return "NO";
            
            else if (stack.peek().equals('(') && s.charAt(i) == ')') stack.pop();
            else if (stack.peek().equals('[') && s.charAt(i) == ']') stack.pop();
            else if (stack.peek().equals('{') && s.charAt(i) == '}') stack.pop();
            else break;
        }
        if (stack.isEmpty() && i == s.length()) return "YES";
        return "NO";
    // Write your code here

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String s = bufferedReader.readLine();

            String result = Result.isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
