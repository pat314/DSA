/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/
    boolean checkBST(Node root) {
        //we traverse through the tree by inorder
        //if the binary tree is the BST, the node list after traverse must be a increasing list
        Queue<Node> queue = new LinkedList<>();
        inOrder(root, queue);
        Node tmp = queue.remove();
        while (!queue.isEmpty()) {
            Node x = queue.remove();
            if (x.data <= tmp.data) return false;
            tmp = x;
        }
        return true;
        
    }

    void inOrder(Node x, Queue<Node> queue) {
        if (x == null) return;
        inOrder(x.left, queue);
        queue.add(x);
        inOrder(x.right, queue);
    }