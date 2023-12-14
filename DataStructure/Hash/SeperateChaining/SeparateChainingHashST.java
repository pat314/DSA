import edu.princeton.cs.algs4.SequentialSearchST;

import java.util.*;

public class SeparateChainingHashST {

    class Pair {
        String key;
        Integer val;
        public Pair(String key, Integer val)  {
            this.key  = key;
            this.val  = val;
        }
    }

    private static final int INIT_CAPACITY = 4;

    private int n;                                // number of key-value pairs
    private int m;                                // hash table size
    private List<List<Pair>> st;                  // array of linked-list

    public SeparateChainingHashST(int m) {
        this.m = m;
        st = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Pair> tmp = new ArrayList<>();
            st.add(tmp);
        }

    }

    // resize the hash table to have the given number of chains,
    // rehashing all of the keys
    private void resize(int chains) {
        SeparateChainingHashST temp = new SeparateChainingHashST(chains);
        for (int i = 0; i < m; i++) {
            for (Pair pair : st.get(i)) {
                temp.put(pair.key, pair.val);
            }
        }
        this.m  = temp.m;
        this.n  = temp.n;
        this.st = temp.st;
    }

    // hash function for keys - returns value between 0 and m-1
    private int hashTextbook(String string) {
        return (string.hashCode() & 0x7fffffff) % m;
    }

    // hash function for keys - returns value between 0 and m-1 (assumes m is a power of 2)
    // (from Java 7 implementation, protects against poor quality hashCode() implementations)
    private int hash(String string) {
        int h = string.hashCode();
        h ^= (h >>> 20) ^ (h >>> 12) ^ (h >>> 7) ^ (h >>> 4);
        return h & (m-1);
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(String key) {
        return get(key) != null;
    }

    public Integer get(String key) {
        int i = hash(key);
        return find(st.get(i), key);
    }

    private Integer find(List<Pair> arr, String key) {
        for (Pair p : arr) {
            if (p.key.equals(key)) return p.val;
        }
        return null;
    }

    public void put(String key, Integer val) {
        if (val == null) {
            delete(key);
            return;
        }

        // double table size if average length of list >= 10
        if (n >= 10*m) resize(2*m);

        int i = hash(key);
        if (find(st.get(i), key) == null) n++;
        st.get(i).add(new Pair(key, val));
    }

    public void delete(String key) {
        int i = hash(key);
        if (find(st.get(i), key) != null) n--;
        st.get(i).remove(getPair(st.get(i), key));

        // halve table size if average length of list <= 2
        if (m > INIT_CAPACITY && n <= 2*m) resize(m/2);
    }

    private Pair getPair(List<Pair> arr, String key) {
        for (Pair p : arr) {
            if (p.key.equals(key)) return p;
        }
        return null;
    }

    // return keys in symbol table as an Iterable
    public List<String> keys() {
        List<String> list = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (Pair p : st.get(i)) {
                String key = p.key;
                list.add(key);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        SeparateChainingHashST st = new SeparateChainingHashST(num);

        for (int i = 0; !scanner.hasNext(); i++) {
            String string = scanner.next();
            st.put(string, i);
        }

        // print keys
        for (java.lang.String s : st.keys())
            System.out.println(s + " " + st.get(s));
    }
}