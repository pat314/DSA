import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Pair implements Comparable<Pair> {
    int first, second;
    
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
    
    @Override
    public int compareTo(Pair other) {
        if (first < other.first) return -1;
        if (first > other.first) return 1;
        if (second < other.second) return -1;
        if (second > other.second) return 1;
        
        return 0;
    }
}

class Result {

    /*
     * Complete the 'largestRectangle' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY h as parameter.
     */

    public static long largestRectangle(List<Integer> h) {
    // Write your code here
        long result = -1;
        
        int N = h.size();
        Pair[] pairs = new Pair[N];
        
        for (int i = 0; i < N; i++) {
            pairs[i] = new Pair(h.get(i), i);
        }   
        
        Arrays.sort(pairs);
        
        TreeSet<Integer> bst = new TreeSet<>();
        bst.add(-1);
        bst.add(N);
        
        for (Pair pair: pairs) {
            Integer left = bst.lower(pair.second);
            Integer right = bst.higher(pair.second);
            result = Math.max(result, pair.first * (right - left - 1));
            bst.add(pair.second);
        }
        
        return result;
    }

}