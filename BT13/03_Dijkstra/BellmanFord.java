//AC!

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Edge {
    private final int v, w;
    private final double weight;
    
    public Edge(int v, int w , double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }
    
    public int either() {return v;}
    public int other(int vertex) {
        if (vertex == v) return w;
        return v;
    }
    public double weight() {return weight;}
}

class Pair implements Comparable<Pair> {
    double first;
    int second;
    
    public Pair(double first, int second) {
        this.first = first;
        this.second = second;
    }
    
    @Override
    public int compareTo(Pair other) {
        if (first < other.first) return -1;
        if (first > other.first) return 1;
        if (second < other.second) return -1;
        if (second > other.second) return 1;
        
        return 0;
    }
}

class BellmanFord {

    private double[] distTo;
    private boolean[] onQueue;
    private Queue<Integer> queue;
    private int cost;


    public BellmanFord(List<Edge>[] adj, int s) {
        distTo  = new double[adj.length];
        onQueue = new boolean[adj.length];
        for (int v = 0; v < adj.length; v++)
            distTo[v] = Double.POSITIVE_INFINITY;
        distTo[s] = 0.0;

        // Bellman-Ford algorithm
        queue = new LinkedList<Integer>();
        queue.add(s);
        onQueue[s] = true;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            onQueue[v] = false;
            for (Edge e : adj[v]) {
                int w = e.other(v);
                if (distTo[w] > distTo[v] + e.weight()) {
                    distTo[w] = distTo[v] + e.weight();
                    if (!onQueue[w]) {
                        queue.add(w);
                        onQueue[w] = true;
                    }
                }
            }
        }
    }

    public void getDistTo() {       
        for (int i = 1; i < distTo.length; i++) {
            if (distTo[i] != 0) {
                if (distTo[i] == Double.POSITIVE_INFINITY) System.out.print("-1 ");
                else System.out.print((int)distTo[i] + " ");;
            }
        }
    }
}


public class Solution {
    
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            if (st == null || !st.hasMoreElements ()) {
                do {
                    try {
                        st = new StringTokenizer (br.readLine ());
                    } catch (IOException e) {
                        e.printStackTrace ();
                    }
                } while (st == null || !st.hasMoreElements ());
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
    
    public static void main(String[] args) {
        FastReader sc = new FastReader();

        int t = sc.nextInt();

        for (int tItr = 0; tItr < t; tItr++) {

            int n = sc.nextInt();
                       
            List<Edge>[] adj = (List<Edge>[]) new List[n + 1];
            for (int v = 0; v < adj.length; v++) adj[v] = new ArrayList<>();

            int m = sc.nextInt();

            for (int i = 0; i < m; i++) {               
                Edge e = new Edge(sc.nextInt(), sc.nextInt(), sc.nextLong());
                int ve = e.either();
                int we = e.other(ve);
                adj[ve].add(e);
                adj[we].add(e);
            }

            int s = sc.nextInt();

            BellmanFord d = new BellmanFord(adj, s);
            d.getDistTo();
            
            System.out.println();
        }
    }
}