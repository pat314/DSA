//Union-find API
public class QuickFindUF {

    private int[] id;
    /**
     * Constructor initializes an union-find data structure.
     * @param N number of objects
     */
    public QuickFindUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    /**
     * Add connection between p and q.
     * @param p the pth object
     * @param q the qth object
     */
    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
    }

    /**
     * Check whether p and q are in the same component
     * @param p the pth object
     * @param q th qth object
     * @return return true if they are connected, false otherwise
     */
    public boolean conncected(int p, int q) {
        return id[p] == id[q];
    }

    /*
    /**
     * component identifier for p.
     * @param p the pth object
     * @return the id of the component p is in
     */
    /*
    public int find(int p) {
        //TODO
    }

    /**
     * count the components we have.
     * @return the number of components
     */
    /*
    public int count() {
        //TODO
    }
    */
}
