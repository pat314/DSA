public class WeightedQuickUnionUFwithPathCompression {

    private int[] id;
    //int array to save the size (number of objects) on the tree from every root
    private int[] sz;
    /**
     * Constructor initializes an union-find data structure.
     * @param N number of objects
     */
    public WeightedQuickUnionUFwithPathCompression(int N) {
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    private int root(int i) {
        while (i != id[i]) {
            //path compression upgrade
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    /**
     * Add connection between p and q.
     * @param p the pth object
     * @param q the qth object
     */
    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        //gắn p vào q
        if (sz[i] <= sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            //gắn q vào p
            id[j] = i;
            sz[i] += sz[j];
        }
    }

    /**
     * Check whether p and q are in the same component
     * @param p the pth object
     * @param q th qth object
     * @return return true if they are connected, false otherwise
     */
    public boolean conncected(int p, int q) {
        return root(p) == root(q);
    }
}
