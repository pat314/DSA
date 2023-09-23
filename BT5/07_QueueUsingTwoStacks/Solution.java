import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        //Cach 1: Using Queue Interface in Java
        // Scanner scanner = new Scanner(System.in);
        // Queue<Integer> queue = new LinkedList<>();
        // int Q = scanner.nextInt();
        // for (int i = 0; i < Q; i++) {
        //     int request = scanner.nextInt();
        //     switch (request) {
        //         case 1:
        //         {
        //             int tmp = scanner.nextInt();
        //             queue.add(tmp);
        //             break;
        //         }
                
        //         case 2:
        //         {
        //             queue.poll();
        //             break;
        //         }
        //         case 3:
        //         {
        //             System.out.println(queue.peek());
        //             break;
        //         }
        //     }
        // }
        // scanner.close();

        //Cach 2: Using two stack

        //Ý tưởng: ta sẽ dùng 2 stack: stack1 và stack2, mỗi lần thêm vào queue 1 phần tử thì ta sẽ push vào stack1, sau đó,chỉ khi mà stack2 rỗng, ta mới push từng phần tử pop ra từ stack1 để được 1 stack2 có thứ tự phần tử ngược lại với stack1 (Đảo stack1)
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            int request = scanner.nextInt();
            switch (request) {
                case 1:
                {
                    int tmp = scanner.nextInt();
                    stack1.push(tmp);
                    if (stack2.isEmpty()){
                        while (!stack1.isEmpty()) {
                            stack2.push(stack1.pop());
                        }  
                    }
                                      
                    break;
                }
                case 2:
                {
                    if (stack2.isEmpty()){
                        while (!stack1.isEmpty()) {
                            stack2.push(stack1.pop());
                        }  
                    }
                    stack2.pop();
                    
                    break;
                }
                case 3:
                {
                    if (stack2.isEmpty()){
                        while (!stack1.isEmpty()) {
                            stack2.push(stack1.pop());
                        }  
                    }
                    System.out.println(stack2.peek());
                   
                    break;
                }
            }
        }
    }
}
