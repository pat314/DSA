import java.io.*;
import java.util.*;


class Edge implements Comparable<Edge> {
    private final int v, w;
    private final double weight;
    
    public Edge(int v, int w, int weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }
    
    public int either() {
        return v;
    }
    
    public int other(int vertex) {
        if (vertex == v) return w;
        return v;
    }
    public double getWeight() { return weight; }
    
    @Override
    public int compareTo(Edge that) {
        if (this.weight < that.weight) return -1;
        if (this.weight > that.weight) return 1;
        return 0;
    }
}

class WGraph {
    private final int V;
    private List<Edge>[] adj;
    
    public WGraph(int V) {
        this.V = V;
        adj =(List<Edge>[]) new List[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<>();
        }
    }
    
    public void addEdge(List<Integer> edge) {
        Edge e = new Edge(edge.get(0), edge.get(1), edge.get(2));
        int v = e.either(); int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
    }
    
    public Iterable<Edge> adj(int v) {
        return adj[v];
    }
    
    public int V() { return V; }
    
        public Iterable<Edge> edges() {
        List<Edge> list = new ArrayList<Edge>();
        for (int v = 0; v < V; v++) {
            for (Edge e : adj(v)) {
                if (e.other(v) > v) {
                    list.add(e);
                }
            }
        }
        return list;
    }
}

class UF {
    int count;
    int[] parent;
    int[] rank;
    
    public UF(int n) {
        count = n;
        parent = new int[n];
        rank = new int[n];
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }
    
    public int find(int p) {
        while (p != parent[p]) {
            //path compression
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
    
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        
        if (rank[rootP] > rank[rootQ]) parent[rootQ] = rootP;
        else if (rank[rootP] < rank[rootQ]) parent[rootP] = rootQ;
        else {
            parent[rootQ] = rootP;
            rank[rootP] ++;
        }
        count--;
    }
    
    public boolean connected(int p, int q) { return find(p) == find(q);}
}

class Result {

    private static int value = 0;
    
        /*
     * Complete the 'kruskals' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts WEIGHTED_INTEGER_GRAPH g as parameter.
     */

    /*
     * For the weighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] and <name>To[i]. The weight of the edge is <name>Weight[i].
     *
     */

    public static int kruskals(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
        
        WGraph G = new WGraph(gNodes + 1);
    for (int i = 0; i < gFrom.size(); i++) {
        List<Integer> item = new ArrayList<>();
        item.add(gFrom.get(i));
        item.add(gTo.get(i));
        item.add(gWeight.get(i));
        
        G.addEdge(item);
    }
    Kruskal(G);
    return value;
    }
       
    public static void Kruskal(WGraph G) {
        Queue<Edge> mst = new LinkedList<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        
        for (Edge e : G.edges()) pq.add(e);
        
        UF uf = new UF(G.V());
        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.poll();
            int v = e.either(); int w = e.other(v);
            if (!uf.connected(v, w)) {
                uf.union(v, w);
                value += e.getWeight();
                mst.add(e);
            }
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int gNodes = sc.nextInt();
        int gEdges = sc.nextInt();

        List<Integer> gFrom = new ArrayList<>();
        List<Integer> gTo = new ArrayList<>();
        List<Integer> gWeight = new ArrayList<>();

        for (int i = 0; i < gEdges; i++) {
            gFrom.add(sc.nextInt());
            gTo.add(sc.nextInt());
            gWeight.add(sc.nextInt());
        }

        int res = Result.kruskals(gNodes, gFrom, gTo, gWeight);

        System.out.println(res);
        sc.close();;
    }
}
