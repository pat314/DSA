import java.util.NoSuchElementException;

class AVL {
    class Node {
        int data;
        Node left;
        Node right;
        int height;

        public Node(int data) {
            this.data = data;
            height = 0;
        }
    }

        Node root;


        /*
         * insert
         * ********************************************************************************
         */
        public void insert(int data) {
            root = insert(root, data);
        }

        private Node insert(Node x, int data) {
            if (x == null) return new Node(data);

            if (data < x.data) x.left = insert(x.left, data);
            else if (data > x.data) x.right = insert(x.right, data);
            //else return x;

            x.height = Math.max(height(x.left), height(x.right)) + 1;

            return balance(x);
        }

        /*
         * delete
         * ********************************************************************************
         */

        public void delete(int data) {
            root = delete(root, data);
        }

        private Node delete(Node x, int data) {
            if (data < x.data) x.left = delete(x.left, data);
            else if (data > x.data) x.right = delete(x.right, data);
            else {
                if (x.left == null) return x.right;
                if (x.right == null) return x.left;

                Node t = x;
                x = min(t.right);
                x.right = deleteMin(t.right);
                x.left = t.left;
            }

            x.height = Math.max(height(x.left), height(x.right)) + 1;

            return balance(x);
        }

        private Node min(Node x) {
            while (x.left != null) x= x.left;
            return x;
        }

        private Node deleteMin(Node x) {
            if (x.left == null) return x.right;
            x.left = deleteMin(x.left);

            x.height = Math.max(height(x.left), height(x.right)) + 1;

            return balance(x);
        }

        /*
         * get
         * ********************************************************************************
         */

        public Node get(int data) {
            Node x = root;
            x = get(x, data);
            return x;
        }

        private  Node get(Node x, int data) {
            if (x == null) return null;
            if (data < x.data) return get(x.left, data);
            else if (data > x.data) return get(x.right, data);
            else return x;
        }



        /*
         * height
         * ********************************************************************************
         */

        public int height(Node x) {
            if (x == null) return -1;
            return x.height;
        }

        /*
         * depth
         * ********************************************************************************
         */

        public int depth(int data) {
            return depth(root, data, 0);
        }

        private int depth(Node x, int data, int depth) {
            if (x == null) return -1;

            if (x.data ==  data) return depth;

            int d = depth(x.left, data, depth + 1);
            if (d != -1) return d;

            return depth(x.right, data, depth + 1);
        }

        /*
         * balance factor
         * ********************************************************************************
         */

        private int balanceFactor(Node x) {
            return height(x.left) - height(x.right);
        }

        /*
         * balance
         * ********************************************************************************
         */

        private Node balance(Node x) {
            if (balanceFactor(x) > 1) {
                if (balanceFactor(x.left) < 0) x.left = rotateLeft(x.left);
                x = rotateRight(x);
            }

            if(balanceFactor(x) < -1) {
                if (balanceFactor(x.right) > 0) x.right = rotateRight(x.right);
                x = rotateLeft(x);
            }
            return x;
        }

        /*
         * rotateLeft
         * ********************************************************************************
         */

        private Node rotateLeft(Node x) {
            Node y = x.right;
            x.right = y.left;
            y.left = x;

            x.height = Math.max(height(x.left), height(x.right)) + 1;
            y.height = Math.max(height(y.left), height(y.right)) + 1;
            return y;
        }

        /*
         * rotateRight
         * ********************************************************************************
         */
        private Node rotateRight(Node x) {
            Node y = x.left;
            x.left = y.right;
            y.right = x;

            x.height = Math.max(height(x.left), height(x.right)) + 1;
            y.height = Math.max(height(y.left), height(y.right)) + 1;

            return y;
        }

    // Driver code
    public static void main(String[] args) {
        AVL tree = new AVL();
        tree.insert(33);
        tree.insert(13);
        tree.insert(53);
        tree.insert(9);
        tree.insert(21);
        tree.insert(61);
        tree.insert(8);
        tree.insert(11);

        System.out.println(tree.height(tree.get(13))); // 2
        System.out.println(tree.depth(8)); // 3
        System.out.println(tree.depth(61)); //2
        tree.delete(21);
        System.out.println(tree.height(tree.get(13))); // 1
        System.out.println(tree.depth(8)); // 2
        System.out.println(tree.depth(61)); // 2
    }
}
