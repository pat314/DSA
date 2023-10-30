import java.util.*;

public class Client {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //Read in the number of objects N from standard input
        int N = scan.nextInt();
        UF uf = new UF(N);
        //Repeat:
        while (!scan.hasNext()) {
            //Read in pair of integers from standard input
            int p = scan.nextInt();
            int q = scan.nextInt();
            //if they are not yet connected, connect them and print out pair
            if (!uf.conncected(p, q)) {
                uf.union(p, q);
                System.out.println("connecting: " + p + " " + q);
            }
        }
    }
}
