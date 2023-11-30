//NOT AC!

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class DirectedEdge {
    private final int v, w;
    private final double weight;
    
    public DirectedEdge(int v, int w , double weight) {
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

class Dijkstra {
    private double[] distTo;
    private PriorityQueue<Pair> pq;
    
    public Dijkstra(List<DirectedEdge>[] adj, int s) {
        distTo = new double[adj.length];
        pq = new PriorityQueue<Pair>(adj.length);
        
        for (int v = 0; v < adj.length; v++) distTo[v] = Double.POSITIVE_INFINITY;
        
        distTo[s] = 0.0;
        pq.add(new Pair(distTo[s], s));
        
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int v = p.second;
            for(DirectedEdge e : adj[v]) {
                relax(e, v);
            }
        }
    }
    
    private void relax(DirectedEdge e, int v) {
        int  w = e.other(v);
        if (distTo[w] > distTo[v] + e.weight()) {
            distTo[w] = distTo[v] + e.weight();
            pq.add(new Pair(distTo[w], w));
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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int tItr = 0; tItr < t; tItr++) {

            int n = sc.nextInt();
                       
            List<DirectedEdge>[] adj = (List<DirectedEdge>[]) new List[n + 1];
            for (int v = 0; v < adj.length; v++) adj[v] = new ArrayList<>();

            int m = sc.nextInt();

            for (int i = 0; i < m; i++) {               
                DirectedEdge e = new DirectedEdge(sc.nextInt(), sc.nextInt(), sc.nextInt());
                int ve = e.either();
                int we = e.other(ve);
                adj[ve].add(e);
                adj[we].add(e);

            }

            int s = sc.nextInt();

            Dijkstra d = new Dijkstra(adj, s);
            d.getDistTo();
            
            System.out.println();
        }
    }
}
