import java.util.*;

public class Client {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //Read in the number of objects N from standard input
        int N = scan.nextInt();
        System.out.println("Creating " + N + " objects...");
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
        //Repeat:
        while (scan.hasNext()) {
            //Read in a pair of integers from standard input
            int p = scan.nextInt();
            int q = scan.nextInt();
            //if they are not yet connected, connect them and print out pair
            if (!uf.conncected(p, q)) {
                System.out.println(p + " and " + q + " are not connected. Do you want to connect them? Y/N");
                String answer = scan.next();
                if (answer.equals("Y")) {
                    System.out.println("connecting: " + p + " " + q);
                    uf.union(p, q);
                }
            } else {
                System.out.println(p + " and " + q + " are connected.");
            }
        }
    }
}
