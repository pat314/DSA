import java.util.*;

class LazyDijkstra {

    class Pair implements Comparable<Pair> {
        int vertex;
        double dist;
        public Pair(int vertex, double dist) {
            this.vertex = vertex;
            this.dist = dist;
        }

        @Override
        public int compareTo(Pair that) {
            if (this.dist < that.dist) return -1;
            if (this.dist > that.dist) return 1;
            return 0;
        }

    }

    class Edge {
        int v, w;
        double weight;

        public Edge(int v, int w, double weight) {
            this.v = v; this.w = w; this.weight = weight;
        }
    }
    public double distTo[];
    private PriorityQueue<Pair> pq;

    public LazyDijkstra (List<List<Integer>> edges, int V, int s) {
        List<Edge>[] adj = (List<Edge>[]) new List[V];
        for (int v = 0; v < V; v++) adj[v] = new ArrayList<>();

        for (List<Integer> edge : edges) {
            int v = edge.get(0);
            adj[v].add(new Edge(v, edge.get(1), edge.get(2)));
        }

        distTo = new double[V];
        Arrays.fill(distTo, Double.POSITIVE_INFINITY);

        pq = new PriorityQueue<>();

        distTo[s] = 0.0;
        pq.add(new Pair(s, distTo[s]));

        while(!pq.isEmpty()) {
            Pair pair = pq.poll();
            int v = pair.vertex;
            for (Edge e : adj[v]) {
                relax(e);
            }
        }
    }

    private void relax(Edge e) {
        int v = e.v, w = e.w;
        if (distTo[w] > distTo[v] + e.weight) {
            distTo[w] = distTo[v] + e.weight;
            pq.add(new Pair(w, distTo[w]));
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> edges = new ArrayList<>();
        int numEdges = sc.nextInt();
        for (int i = 0; i < numEdges; i++) {
            List<Integer> edge = new ArrayList<>();
            edge.add(sc.nextInt());
            edge.add(sc.nextInt());
            edge.add(sc.nextInt());
            edges.add(edge);
        }

        LazyDijkstra dijkstra = new LazyDijkstra(edges, 7, 0);
        double[] dist = dijkstra.distTo;
        for (double x : dist) System.out.println(x);
    }
}


