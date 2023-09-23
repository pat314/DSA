import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Cách 1: Ta sẽ xử lý chuỗi, cứ bắt gặp cặp ngoặc nào hợp lệ thì ta loại nó ra khỏi string, nếu string cuối cùng vẫn còn ngoặc chứng tỏ string đó có cặp ngoặc không hợp lệ
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
    /*Cach 2: Ta dùng stack để xử lí: ta sẽ bỏ hết những ngoặc mở vào stack, khi gặp ngoặc đóng thì t kiểm tra xem stack trên cùng có ngoặc mở tương ứng không, nếu có thì ta đẩy ngoặc mở đó ra khỏi stack, không thì return false (tức là noặc không hợp lệ) luôn. Sau khi duyệt hết chuỗi ngoặc, nếu stack rỗng thì chứng tỏ string là hợp lệ, ngược lại thì không.
     */
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
