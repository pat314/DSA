import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int Q = scanner.nextInt();
        String text = "";
        //Ý tưởng bài toán: ta sẽ dùng một stack chứa những string text. Trước mỗi lần thay đổi text (thêm, xóa) thì ta sẽ push text đó vào stack trước như 1 bản sao của version cũ. Khi ta undo hành động của ta thì ta chỉ cần pop ra thì ta sẽ thu được text ngay trước khi sửa.
        Stack <String> oldVersion = new Stack<>();
        //Stack <Integer> request = new Stack<>();
        
        for (int i = 0; i < Q; i++) {
            int request = scanner.nextInt();
            
            switch (request) {
                //append
                case 1:
                {
                    //save the last version of the text before append
                    oldVersion.push(text);
                    
                    //append the string using operator +=
                    String append = scanner.next();
                    text += append;
                    break;
                }
                
                //delete
                case 2:
                {
                    //save the last version of the text before delete
                    oldVersion.push(text);
                    
                    //input the number of charater we want to delete
                    int k = scanner.nextInt();
                    
                    //create a new string and save the remaining of the old string after delete
                    if (k == text.length()) text = "";
                    else {
                        int len = text.length();
                        String newText = text.substring(0, len - k);
                        text = newText;
                    }
                    break;
                }
                
                //print
                case 3:
                {
                    //input the order number character we want to print
                    int k = scanner.nextInt();
                    System.out.println(text.charAt(k - 1));
                    break;
                }
                
                //undo
                case 4:
                {
                    if (!oldVersion.isEmpty()) {
                        String oldText = oldVersion.pop();
                        text = oldText;
                    }
                    break;
                }
            }
        }
        scanner.close();
    }
}
