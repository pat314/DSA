/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/
    boolean checkBST(Node root) {
        //if the root is null, it is the BST
        if (root == null) return true;
        //else we check recursively:
        //the root has to be larger than the maximum node of the left subtree
        if (root.left != null) {
            Node x = root.left;
            while (x.right != null) x = x.right;
            if (x.data >= root.data) return false;
        }
        //and smaller than the minimum node of the right subtree
        if (root.right != null) {
            Node x = root.right;
            while (x.left != null) x = x.left;
            if (x.data <= root.data) return false;
        }
        //and 2 subtrees also must be a BST
        return (checkBST(root.left) && checkBST(root.right));
    }
