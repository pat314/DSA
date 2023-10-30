public class QuickUnionUFpathCompression {

    private int[] id;
    /**
     * Constructor initializes an union-find data structure.
     * @param N number of objects
     */
    public QuickUnionUFpathCompression(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) id[i] = i;
    }

    private int root(int i) {
        //make every other node in path point to its grandparent
        while (i != id[i]) {
            id[i] = id[id[i]];  // <-- an extra code
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
        id[i] = j;
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
