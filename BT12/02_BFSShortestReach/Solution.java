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
     
    private static final int LENGTH = 6;
    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
    // Write your code here
    
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            List<Integer> tmp = new ArrayList<>();
            adj.add(tmp);
        }
        for (List<Integer> edge : edges) {
            int v = edge.get(0);
            int w = edge.get(1);
            adj.get(v).add(w);
            adj.get(w).add(v);            
        }

        boolean[] marked = new boolean[n + 1];
        int[] distTo = new int[n + 1];
        Arrays.fill(distTo, -1);

        Queue<Integer> q = new LinkedList<>();

        marked[s] = true;
        distTo[s] = 0;
        q.add(s);
        while (!q.isEmpty()) {
            int v = q.poll();
            for (int w : adj.get(v)) {
                if (!marked[w]) {
                    marked[w] = true;
                    distTo[w] = distTo[v] + LENGTH;
                    q.add(w);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (distTo[i] != 0) result.add(distTo[i]); 
        }   

        return result;
    }
}
