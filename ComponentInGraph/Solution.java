import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

//Component in the graph by DFS
/**
 * Create class Graph include.
 * Constructor with given V vertices.
 * addEdge: add edge to the graph.
 * V: return the number of vertices in the graph.
 * adj(int v): return the list of adjacent vertices to given v vertex.
 */
class Graph {
    private final int V;
    private List<Integer>[] adj;
    
    public Graph(int V) {
        this.V = V;
        adj = (List<Integer>[]) new List[V];
        for (int v = 0; v < V; v++)
            adj[v] = new ArrayList<Integer>();        
    }
    
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }
    
    public int V() {
        return V;
    }
    
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
       
}

class CC {
    private boolean marked[];
    private int count = 0;
    //minCC saves the minimum number of vertices in one connected component (minCC > 1)
    private int minCC = Integer.MAX_VALUE;
    //maxCC saves the maximum number of vertices in one connected component (minCC > 1)
    private int maxCC = 1;
    
    public CC(Graph G) {
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                //initialize the count (count the vertices in one connected component)
                count = 0;
                //run dfs
                dfs(G, v);
                //get the minimum vertices in CC and maximum vertices in CC
                if (minCC > count && count > 1) minCC = count;
                if (maxCC < count) maxCC = count;
            }
        }
    }
    
    private void dfs(Graph G, int v) {
        marked[v] = true;
        count++;
        for (int w: G.adj(v)) {
            if (!marked[w])
                dfs(G, w);
        }
    }
    
    public int getMaxCC() {return maxCC;}
    public int getMinCC() {return minCC;}
}


class Result {

    public static List<Integer> componentsInGraph(List<List<Integer>> gb) {
        int E = gb.size();
        
        Graph G = new Graph(2 * E + 1);
        for (int i = 0; i < E; i++) {
            G.addEdge(gb.get(i).get(0), gb.get(i).get(1));
        }
        
        CC cc = new CC(G);
        List<Integer> result = new ArrayList<>();
        result.add(cc.getMinCC());
        result.add(cc.getMaxCC());
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> gb = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] gbRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> gbRowItems = new ArrayList<>();

            for (int j = 0; j < 2; j++) {
                int gbItem = Integer.parseInt(gbRowTempItems[j]);
                gbRowItems.add(gbItem);
            }

            gb.add(gbRowItems);
        }

        List<Integer> result = Result.componentsInGraph(gb);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
