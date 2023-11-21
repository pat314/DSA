//Find component graph by UF data structure
/**
 * Build class UF with methods:
 * Constructor
 * findingRoot: find the root of each vertex
 * union: union two sets
 * countVertexInEachCC: count the vertex in each CC
 * getMaxCC: get the max number of vertex in CCs
 * getMinCC: get the min number of vertex in CCs
 */
class UF {
    private int count;
    private int[] rank;
    private int[] parent;
    private int[] frequency;

    public UF(int n) {
        count = n + 1;
        rank = new int[n + 1];
        parent = new int[n + 1];
        frequency = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            rank[i] = 0;
            parent[i] = i;
            frequency[i] = 0;
        }
    }

    public int findingRoot(int p) {
        while (p != parent[p]) {
            //path compression: after finding the root of the p node, attach node p to the root
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int rootP = findingRoot(p);
        int rootQ = findingRoot(q);

        if (rootP == rootQ) return;
        //attach the lower tree to the higher one
        if      (rank[rootP] < rank[rootQ]) parent[rootP] = rootQ;
        else if (rank[rootP] > rank[rootQ]) parent[rootQ] = rootP;
            //if 2 trees is equal, merge the latter tree to the forward tree, and then increase rank of the first tree
        else {
            parent[rootQ] = rootP;
            rank[rootP] ++;
        }
        //after one union, the CC decreases
        count--;
    }

    public void countVertexInEachCC() {
        for (int i = 0; i < parent.length; i++) {
            frequency[findingRoot(i)]++;;
        }
    }

    public int getMaxCC() {

        int max = frequency[0];
        for (int j : frequency) {
            if (max < j) max = j;
        }
        return max;
    }

    public int getMinCC() {
        int min = Integer.MAX_VALUE;
        for (int j : frequency) {
            if (j > 1 && j < min) min = j;
        }
        return min;
    }
}

class Result {

    public static List<Integer> componentsInGraph(List<List<Integer>> gb) {
        // Write your code here
        int E = gb.size();

        UF uf = new UF(2 * E);
        for (int i = 0; i < E; i++) {
            uf.union(gb.get(i).get(0), gb.get(i).get(1));
        }

        uf.countVertexInEachCC();

        List<Integer> result = new ArrayList<>();
        result.add(uf.getMinCC());
        result.add(uf.getMaxCC());
        return result;
    }
}