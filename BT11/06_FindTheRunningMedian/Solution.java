import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/*
 * Cài đặt class Pair với cách so sánh tự định nghĩa.
 * Implement class Pair with user-defined comparison method.
 */
class Pair implements Comparable<Pair> {
    int first, second;
    
    public Pair(int first, int second) {
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

public class Solution {
    public static void main (String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int N;
        N = scanner.nextInt();
        
        TreeSet<Pair> bst = new TreeSet<>();
        bst.add(new Pair(Integer.MIN_VALUE, 0));
        bst.add(new Pair(Integer.MAX_VALUE, N + 1));
        
        Pair mid = new Pair(Integer.MIN_VALUE, 0);
        
        /**
         * Giải thích logic:
         * Các phần tử trong treeSet sẽ được sắp xếp **tăng dần**.
         * Đặt con trỏ mid ở vị trí như sau:
         * Nếu dãy có lẻ số thì mid ở chính giữa dãy
         * Nếu dãy có chẵn số, thì mid ở phần tử cuối cùng của nửa trái
         * 
         * TH1: khi dãy đang chẵn số, ta nhập vào 1 số => dãy có lẻ số
         * => Phải đưa mid về số chính giữa
         * 
         * TH1.1: Nếu số đó lớn hơn mid 
         * Vì số đó lớn hơn mid nên khi thêm, số đó sẽ nằm ở nửa phải dãy, 
         * thành ra nửa phải bây giờ đang nhiều hơn nửa trái cũ 1 phần tử
         * (***m ***+*, với + là số vừa được thêm vào, m là mid)
         * Và như vậy ta phải dịch mid sang số bên cạnh phải để lấy đúng số chính giữa dãy.
         * (dùng higher của treesset)
         * => Phải dịch mid sang số bên cạnh phải của nó
         * 
         * TH1.2: Nếu số đó nhỏ hơn mid 
         * Vì số đó nhỏ hơn mid nên khi thêm, số đó sẽ nằm ở nửa trái dãy, 
         * thành ra nửa trái đang nhiều hơn nửa phải cũ 1 phần tử
         * (*+**m **** => *+** m ****, với + là số vừa được thêm vào, m là mid)
         * => mid nằm ở đúng vị trí => không phải dịch mid
         * 
         * 
         * TH2: khi dãy đang lẻ số, ta nhập vào một số => dãy có chẵn số
         * =>Phải đưa mid về số cuối cùng bên nửa trái
         * 
         * TH2.1: Nếu số vừa nhập vào nhỏ hơn mid, tức là số đó được thêm vào nửa trái, 
         * thành ra mid lúc này sẽ là số đầu tiên bên phải 
         * (*+*[* m*]**, với + là số vừa được thêm vào, m là mid)
         * => Phải dịch mid về số bên cạnh trái (dùng lower của treeset)
         * 
         * TH2.2: Nếu số vừa nhập vào lớn hơn mid, tức là số đó được thêm vào nửa phải,
         * thành ra mid lúc này sẽ là số cuối cùng của nửa trái 
         * (***[m *]+**, với + là số vừa được thêm vào, m là mid)
         * => mid đã đúng vị trí, không cần phải dịch
         * 
         */


        /**
         * Logic Explanation: 
         * The elements in treeSet will be sorted **ascending**.
         * Place the mid cursor in the following position:
         * If the sequence has odd numbers, mid is in the middle of the sequence
         * If the sequence has even numbers, then mid is in the last element of the left half
         *
         * Case 1: when the sequence has even numbers, we enter 1 number => the sequence has odd numbers
         * => Bring mid to the middle number
         *
         * Case 1.1: If that number is greater than mid
         * Because that number is larger than mid, when added, that number will be in the right half of the range,
         * So the right half now has 1 more element than the old left half
         * (***m ***+*, where + is the number just added, m is mid)
         * And so we have to shift mid to the number next to the right to get the correct number in the middle of the sequence.
         * (use higher of tree set)
         * => Must shift mid to the number next to its right
         *
         * Case 1.2: If that number is smaller than mid
         * Because that number is smaller than mid, when added, that number will be in the left half of the range,
         * So the left half has 1 more element than the old right half
         * (*+**m **** => *+** m ****, where + is the number just added, m is mid)
         * => mid is in the correct position, no need to shift
         *
         *
         * Case 2: when the sequence has odd numbers, we enter a number => the sequence has even numbers
         * =>Must bring mid to the last number on the left half
         *
         * Case 2.1: If the number just entered is smaller than mid, that means that number is added to the left half,
         * So mid will now be the first number on the right
         * (*+*[* m]***, where + is the number just added, m is mid)
         * => Must shift mid to the number next to the left (use lower of tree set)
         *
         * Case 2.2: If the number just entered is greater than mid, that means that number is added to the right half,
         * so mid will now be the last number of the left half 
         * (***[m *]+**, where + is the newly added number, m is mid)
         * => mid is in the correct position, no need to shift
         */

        for (int i = 1; i <= N; i++) {
            int tmp = scanner.nextInt();
            Pair v = new Pair(tmp, i);
            bst.add(v);
            //Khi tree set có lẻ số 
            //when tree set has odd number of elements
            if (i % 2 == 1) {
                //Nếu số vừa được thêm vào lớn hơn mid thì dịch mid sang phải
                //If the newly added number is larger than mid, shift mid to the right
                if (mid.compareTo(v) < 0) mid = bst.higher(mid);
                //median chính là số mid
                //median is the mid
                System.out.printf("%.1f\n", (double) mid.first);
            //Khi tree set có chẵn số 
            //when tree set has even number of elements
            } else {
                //Nếu số vừa được thêm vào nhỏ hơn mid thì dịch mid sang trái
                //If the newly added number is smaller than mid, shift mid to the left
                if (mid.compareTo(v) > 0) mid = bst.lower(mid);
                //Median chính là trung bình cộng số mid với số bên cạnh phải của mid
                //Median is the average of the number mid with the number to the right of mid
                System.out.printf("%.1f\n", ((double) mid.first 
                + (double) bst.higher(mid).first) / 2);
            }
        }
    }
}
