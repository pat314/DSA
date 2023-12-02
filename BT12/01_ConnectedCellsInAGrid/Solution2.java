import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Pair {
    int x;
    int y;
    
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Result {

    /*
     * Complete the 'connectedCell' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */
     
    
    public static int connectedCell(List<List<Integer>> matrix) {
    // Write your code here
        int tmp = 0, max = 0;
        
        for(int x = 0; x < matrix.size(); x++) {
            for (int y = 0; y < matrix.get(0).size(); y++) {
                tmp = bfs(x, y, matrix);
                if (tmp > max) max = tmp;
            }
        }
        
        return max;   
    }
    
    private static int bfs(int x, int y, List<List<Integer>> matrix) {
        Queue<Pair> q = new LinkedList<>();
        
        if (!validate(x, y, matrix)) return 0;
        //set the current coordinate as visited
        List<Integer> tmp = matrix.get(x);
        tmp.set(y, -1);
        matrix.set(x, tmp);
        
        q.add(new Pair(x, y));
        int count = 1;
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            int xCur = pair.x;
            int yCur = pair.y;

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (!validate(xCur + i, yCur + j, matrix)) continue;
                    count++;
                    //set the current coordinate as visited
                    List<Integer> tmp1 = matrix.get(xCur + i);
                    tmp1.set(yCur + j, -1);
                    matrix.set(xCur + i, tmp1);
                    q.add(new Pair(xCur + i, yCur + j));                    
                }
            }
            
        }
        return count;
    }
    
    private static boolean validate(int x, int y, List<List<Integer>> matrix) {
                if (x < 0 || y < 0 || x > matrix.size() - 1 || y > matrix.get(0).size() - 1   //(x, y) out of bound
                    || matrix.get(x).get(y) < 1) {//matrix[x][y] is visited or it is not a filled cell
                return false;
            }
            return true;
    }

}

public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int m = sc.nextInt();

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> matrixRowItems = new ArrayList<>();

            for (int j = 0; j < m; j++) {
                int matrixItem = sc.nextInt();
                matrixRowItems.add(matrixItem);
            }
            matrix.add(matrixRowItems);
        }

        int result = Result.connectedCell(matrix);

        System.out.println(result);
        sc.close();
    }
}
