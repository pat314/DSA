public class Main {
    public static void main(String[] args) {
        StackArray stack1 = new StackArray();
        StackLinkedList stack2 = new StackLinkedList();
        for (int i = 0; i < 8; i++) {
            stack1.push(i);
        }

        for (int i = 0; i < 8; i++) {
            stack2.push(i * i);
        }

        for (int i = 0; i < 9; i++) {
            System.out.print(stack1.pop() + " ");
        }

        System.out.println();

        for (int i = 0; i < 9; i++) {
            System.out.print(stack2.pop() + " ");
        }
    }
}