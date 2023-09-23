import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        List<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            int tmp = scanner.nextInt();
            arr.add(tmp);
        }
        int queries = scanner.nextInt();
        for (int i = 0; i < queries; i++) {
            String s = scanner.next();
            if (s.equals("Insert")) {
                int pos = scanner.nextInt();
                int data = scanner.nextInt();
                arr.add(pos, data);
            }
            else if (s.equals("Delete")) {
                arr.remove(scanner.nextInt());
            }
        }
        for (int i= 0; i < arr.size(); i++) System.out.print(arr.get(i) + " ");
    }
}