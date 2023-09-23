import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        ArrayList<ArrayList> arr = new ArrayList();
        int N = scanner.nextInt();
        
        for (int i = 0; i < N; i++) {
            ArrayList<Integer> subarr = new ArrayList<>();
            int n = scanner.nextInt();
            for (int j = 0; j < n; j++) {
                subarr.add(scanner.nextInt());
            }
            arr.add(subarr);
        }
        
        int queries = scanner.nextInt();
        for (int i= 0; i < queries; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            
            try {
                System.out.println(arr.get(x-1).get(y-1));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("ERROR!");
            }
        }
        
        scanner.close();
    }
}