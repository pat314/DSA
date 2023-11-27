import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Graph {
    private final int V;
    private List<Integer>[] adj;
    
    public Graph(int V) {
        this.V = V;
        adj = (List<Integer>[]) new List[V];
        
        for (int v = 0; v < V; v++)
            adj[v] = new ArrayList<>();
    }
    
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }
    
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}

class Result {

    /*
     * Complete the 'bfs' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     *  3. 2D_INTEGER_ARRAY edges
     *  4. INTEGER s
     */
     


    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
    // Write your code here
        List<Integer> result = new ArrayList<>();
        int[] distTo = new int[n + 1];
        for (int i = 0; i <= n; i++) distTo[i] = -1;
        boolean[] marked = new boolean[n + 1];
        
        Graph G = new Graph(n + 1);
        
        for (int i = 0; i < edges.size(); i++) {
            G.addEdge(edges.get(i).get(0), edges.get(i).get(1));
        }
        
        bfs(distTo, marked, G, s);
        
        for (int i = 1; i <= n; i++) {
            if (distTo[i] != 0) {
                result.add(distTo[i]);
            }
        }
        
        return result;
    }
    
    public static void bfs(int[] distTo, boolean[] marked, Graph G, int s) {
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(s);
        distTo[s] = 0;
        marked[s] = true;
        
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    queue.add(w);
                    marked[w] = true;
                    distTo[w] = distTo[v] + 6;
                }
            }
        }
    }
}

//Class for testing from console
public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();

        for (int qItr = 0; qItr < q; qItr++) {

            int n = sc.nextInt();

            int m = sc.nextInt();

            List<List<Integer>> edges = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                List<Integer> edgesRowItems = new ArrayList<>();

                for (int j = 0; j < 2; j++) {
                    int edgesItem = sc.nextInt();
                    edgesRowItems.add(edgesItem);
                }

                edges.add(edgesRowItems);
            }

            int s = sc.nextInt();

            List<Integer> result = Result.bfs(n, m, edges, s);

            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i) + " ");
            }

        }
    }
}
