import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LinearProbingHashST {
    // must be a power of 2
    private static final int INIT_CAPACITY = 4;

    private int n;           // number of key-value pairs in the symbol table
    private int m;           // size of linear probing table
    private String[] strings;      // the keys
    private Integer[] vals;    // the values

    public LinearProbingHashST() {
        this(INIT_CAPACITY);
    }

    public LinearProbingHashST(int capacity) {
        m = capacity;
        n = 0;
        strings = (String[])   new Object[m];
        vals = (Integer[]) new Object[m];
    }

    public int size() {return n;}

    public boolean isEmpty() {return size() == 0;}

    public boolean contains(String string) {return get(string) != null;}

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

    // resizes the hash table to the given capacity by re-hashing all of the keys
    private void resize(int capacity) {
        LinearProbingHashST temp = new LinearProbingHashST(capacity);
        for (int i = 0; i < m; i++) {
            if (strings[i] != null) {
                temp.put(strings[i], vals[i]);
            }
        }
        strings = temp.strings;
        vals = temp.vals;
        m    = temp.m;
    }

    public void put(String string, Integer val) {
        if (val == null) {
            delete(string);
            return;
        }

        // double table size if 50% full
        if (n >= m/2) resize(2*m);

        int i;
        for (i = hash(string); strings[i] != null; i = (i + 1) % m) {
            if (strings[i].equals(string)) {
                vals[i] = val;
                return;
            }
        }
        strings[i] = string;
        vals[i] = val;
        n++;
    }

    public Integer get(String string) {
        for (int i = hash(string); strings[i] != null; i = (i + 1) % m)
            if (strings[i].equals(string))
                return vals[i];
        return null;
    }

    public void delete(String string) {
        if (string == null) throw new IllegalArgumentException("argument to delete() is null");
        if (!contains(string)) return;

        // find position i of key
        int i = hash(string);
        while (!string.equals(strings[i])) {
            i = (i + 1) % m;
        }

        // delete key and associated value
        strings[i] = null;
        vals[i] = null;

        // rehash all keys in same cluster
        i = (i + 1) % m;
        while (strings[i] != null) {
            // delete keys[i] and vals[i] and reinsert
            String stringToRehash = strings[i];
            Integer valToRehash = vals[i];
            strings[i] = null;
            vals[i] = null;
            n--;
            put(stringToRehash, valToRehash);
            i = (i + 1) % m;
        }

        n--;

        // halves size of array if it's 12.5% full or less
        if (n > 0 && n <= m/8) resize(m/2);
    }

    public Iterable<String> keys() {
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < m; i++)
            if (strings[i] != null) queue.add(strings[i]);
        return queue;
    }

    public static void main(String[] args) {
        LinearProbingHashST st = new LinearProbingHashST();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; !scanner.hasNext(); i++) {
            String string = scanner.next();
            st.put(string, i);
        }

        // print keys
        for (String s : st.keys())
            System.out.println(s + " " + st.get(s));
    }
}