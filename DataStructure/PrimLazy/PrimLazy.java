import java.util.*;

public class PrimLazy {
    class Edge implements Comparable<Edge> {
        int v, w;
        double weight;

        public Edge(int v, int w, double weight) {
            this.v = v; this.w = w; this.weight = weight;
        }

        @Override
        public int compareTo(Edge that) {
            if (this.weight < that.weight) return -1;
            if(this.weight > that.weight) return 1;
            return 0;
        }
    }

    public Iterable<Edge> Prim(List<List<Integer>> edges, int V) {
        List<Edge>[] adj = (List<Edge>[]) new List[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        Queue<Edge> mst = new LinkedList<>();
        boolean[] marked = new boolean[V];
        PriorityQueue<Edge> pq= new PriorityQueue<>();

        //thêm cạnh vào pq
        for (List<Integer> edge : edges) {
            int v = edge.get(0), w = edge.get(1);
            Edge e = new Edge(v, w, edge.get(2));
            pq.add(e);
            adj[v].add(e);
            adj[w].add(e);
        }

        visit(adj, 0, marked, pq);
        while (!pq.isEmpty() && mst.size() < V - 1) {
            Edge e = pq.poll();
            int v = e.v, w = e.w;
            if (marked[v] && marked[w]) continue;
            mst.add(e);
            if (!marked[v]) visit(adj, v, marked, pq);
            if (!marked[w]) visit(adj, w, marked, pq);
        }
        return mst;
    }

    public void visit(List<Edge>[] adj, int v, boolean[] marked, PriorityQueue<Edge> pq) {
        marked[v] = true;
        for (Edge e : adj[v]) {
            if (!marked[e.v] || !marked[e.w]) pq.add(e);
        }
    }
}
