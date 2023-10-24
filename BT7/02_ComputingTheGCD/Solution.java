import java.io.*;
import java.util.*;

public class Solution {
    
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a%b);
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int a, b;
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        b = scanner.nextInt();
        int gc = gcd(a, b);
        System.out.println(Math.abs(gc));
    }
}
