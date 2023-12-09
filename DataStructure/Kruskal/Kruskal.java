import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Kruskal {
    class Edge implements Comparable<Edge> {
        int v, w;
        double weight;

        public Edge(int v, int w, double weight) {
            this.v = v; this.w = w; this.weight = weight;
        }

        @Override
        public int compareTo(Edge that) {
            if (this.weight < that.weight) return -1;
            if (this.weight > that.weight) return 1;
            return 0;
        }
    }

    class UF {
        int count;
        int[] parent;
        int[] rank;

        public UF(int N) {
            count = N;
            parent = new int[N];
            rank = new int[N];

            for (int i = 0; i < N ; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rank[rootP] < rank[rootQ]) parent[rootP] = rootQ;
            else if (rank[rootQ] < rank[rootP]) parent[rootQ] = rootP;
            else {
                parent[rootQ] = rootP;
                rank[rootP]++;
            }
        }
    }

    public Iterable<Edge> Kruskal (List<List<Integer>> edges, int V) {
        Queue<Edge> mst = new LinkedList<>();
        //Thêm tất cả các cạnh vào pq
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (List<Integer> edge : edges) {
            Edge e = new Edge(edge.get(0), edge.get(1), edge.get(2));
            pq.add(e);
        }

        //Khởi tạo cây khung với V đỉnh, 0 cạnh
        UF uf = new UF(V);

        while (!pq.isEmpty() && mst.size() < V - 1) {
            Edge e = pq.poll();
            int v = e.v, w = e.w;
            if (!uf.connected(v, w)) {
                mst.add(e);
                uf.union(v, w);
            }
        }
        return mst;
    }
}
