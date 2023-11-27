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
}

class Result {

    /*
     * Complete the 'prims' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY edges
     *  3. INTEGER start
     */
     
    private static int value = 0;
    
    public static int prims(int n, List<List<Integer>> edges, int start) {
    // Write your code here
    WGraph G = new WGraph(n + 1);
    for (int i = 0; i < edges.size(); i++) {
        G.addEdge(edges.get(i));
    }
    Prim(G, start);
    return value;
    
    }
    
    public static void Prim(WGraph G, int start) {
        boolean[] marked = new boolean[G.V()];
        Queue<Edge> mst = new LinkedList<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        
        visit(G, start, marked, pq);
        
        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.poll();
            int v = e.either(); int w = e.other(v);
            if (marked[v] && marked[w]) continue;
            mst.add(e);
            value += e.getWeight();
            if (!marked[v]) visit(G, v, marked, pq);
            if (!marked[w]) visit(G, w, marked, pq);
        }
    }
    
    private static void visit(WGraph G, int v, boolean[] marked, PriorityQueue<Edge> pq) {
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            if (!marked[e.other(v)])
                pq.add(e);
        }
    }

}