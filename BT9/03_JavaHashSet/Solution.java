import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

 public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String [] pair_left = new String[t];
        String [] pair_right = new String[t];
        
        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }

//Write your code here
Set<String> set = new HashSet<>();
int count  = 0;
for (int i = 0; i < t ; i++) {
    String concat = pair_left[i] + " " + pair_right[i];
    if (!set.contains(concat)) {
        set.add(concat);
        count++;
    }
    System.out.println(count);
    
}
    
    }
}