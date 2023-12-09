import java.nio.DoubleBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {

    //phần tử trong pq của ta sẽ có cấu trúc (phần tử, độ ưu tiên)
    class IndexMinPQ {
        int maxN;
        int n;
        //cây heap, mảng chứa phần tử tương ứng với vị trí trên cây heap: pq[vị trí trên cây heap] = phần tử
        int[] pq;
        //mảng chứa vị trí các phần tử tương ứng trong pq trên heap: qp[phần t] = v trí trên cây heap
        int[] qp;
        //mảng chứa thứ tự ưu tiên trong heap của các phần tử tương ứng: key[phần tử] = độ ưu tiên
        double[] key;

        public IndexMinPQ(int size) {
            maxN = size;
            n = 0;
            //mảng bắt đầu từ 1
            pq = new int[size + 1];
            qp = new int[size + 1];
            key = new double[size + 1];
            //Khởi tạo vị trí các phần tử trên cây heap là -1 (tức là không tồn tại trên cây heap)
            for (int i = 0; i < qp.length; i++) qp[i] = -1;
        }

        /**
         * IndexMinPQ cần phải API sau
         * 1. insert
         * 2. deleteMin
         * 3. decreaseKey
         * 4. contains
         * 5. isEmpty
         */
        public void insert(int element, double priority) {
            n++;
            qp[element] = n;
            pq[n] = element;
            key[element] = priority;
            swim(n);
        }

        public int deleteMin() {
            int min = pq[1];
            //đưa phần tử cuối heap lên đầu
            exch(1, n);
            //giảm kích cỡ của heap
            n--;
            //xây lại heap
            sink(1);
            //đánh dấu phần tử min không còn tồn tại trên heap
            qp[min] = -1;
            return min;
        }

        public void decreaseKey(int element, double newKey) {
            //newKey phải đảm bảo nhỏ hơn key cũ
            key[element] = newKey;
            swim(qp[element]);
        }

        public boolean contains(int element) {
            return qp[element] != -1;
        }

        public boolean isEmpty() {return n == 0;}

        /*các hàm hỗ trợ thông thường*/

        //so sánh 2 phần tử ta 2 vị trí trên heap
        private boolean greater(int m, int n) {
            if (key[pq[m]] < key[pq[n]]) return false;
            return true;
        }

        //đổi chỗ 2 phần tử tại 2 vị trí trên heap
        public void exch(int m, int n) {
            //đổi giá trị
            int tmp = pq[m];
            pq[m] = pq[n];
            pq[n] = tmp;
            //cập nhật vị trí
            qp[pq[m]] = m;
            qp[pq[n]] = n;
        }

        /*các hàm hỗ trợ của heap*/
        public void swim(int k) {
            while (k > 1 && greater(k / 2, k)) {
                exch(k, k / 2);
                k = k / 2;
            }
        }

        public void sink(int k) {
            while (2 * k <= n) {
                int j = 2 * k;
                if (j < n && greater(j, j + 1)) j = j + 1;
                if (greater(j, k)) break;
                exch(k, j);
                k = j;
            }
        }
    }

    class Edge implements Comparable<Edge> {
        int from, to;
        double weight;

        public Edge(int from, int to, double weight) {
            this.from = from; this.to = to; this.weight = weight;
        }

        @Override
        public int compareTo(Edge that) {
            if(this.weight < that.weight) return -1;
            if (this.weight > that.weight) return 1;
            return 0;
        }
    }

    private Edge[] edgeTo;
    private double[] distTo;
    IndexMinPQ pq;

    public Dijkstra(List<List<Integer>> edges, int V, int s) {
        //tạo danh sách kề từ danh sách cạnh
        List<Edge>[] adj = (List<Edge>[]) new List[V];
        for (List<Integer> edge : edges) {
            int from = edge.get(0);
            Edge e = new Edge(from, edge.get(1), edge.get(2));
            adj[from].add(e);
        }

        //khởi tạo mảng truy vết edgeTo[], mảng độ dài đường đi distTo[],
        //priority queue chứa các đỉnh với thứu tự ưu tiên là độ dài đường đi tới chúng
        edgeTo = new Edge[V];
        distTo = new double[V];
        Arrays.fill(distTo, Double.POSITIVE_INFINITY);
        pq = new IndexMinPQ(V);

        //Thêm đỉnh nguồn vào pq, cập nhật đường đi tơới đỉnh nguồn
        distTo[s] = 0.0;
        pq.insert(s, distTo[s]);

        //chừng nào mà pq không rỗng, ta lặp lại thủ tục: bỏ đỉnh có đường đi tới nó nhỏ nhất (đặt là đỉnh v)
        // và relax(e) với e là các cạnh liên thuộc với v
        // relax(e): cập nhật đường đi tới các đỉnh kề với đỉnh kề với v nếu có đường đi nhỏ hơn và bỏ nó vào pq
        while (!pq.isEmpty()) {
            int v = pq.deleteMin();
            for (Edge e : adj[v]) {
                relax(e);
            }
        }
    }

    private void relax(Edge e) {
        int from = e.from, to = e.to;
        if (distTo[to] > distTo[from] + e.weight) {
            distTo[to] = distTo[from] + e.weight;
            edgeTo[to] = e;

            //update PQ
            if (pq.contains(to)) pq.decreaseKey(to, distTo[to]);
            else                 pq.insert(to, distTo[to]);
        }
    }
}