	/* Class node is defined as :
    class Node 
    	int val;	//Value
    	int ht;		//Height
    	Node left;	//Left child
    	Node right;	//Right child

	*/

    static Node insert(Node root,int val) {
        //first, insert as same as insert in BST
        if (root == null) {
            root = new Node();
            root.val = val;
            return root;
        }
        if      (val > root.val)    root.right = insert(root.right, val);
        else if (val < root.val)    root.left  = insert(root.left, val);
        else                        return root;
        
        //re-calculate the height of root of each subtree
        root.ht = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        
        //tree is left - heavy
        if (getBF(root) > 1) {
            //consider the left child: if left child has left child => left - left case
            if (getBF(root.left) >= 0) { 
                return rightRotate(root);
            } else {
            //if left child has right child => right -left case
                root.left = leftRotate(root.left);
                return rightRotate(root);
            }
        
        //tree is right - heavy
        } else if (getBF(root) < -1) {
            //consider the right child: if right child has right child => right - right case
            if (getBF(root.right) <= 0) {
                return leftRotate(root);
            } else {
            //if right child had left child => left - right case
                root.right = rightRotate(root.right);
                return leftRotate(root);
            }
        }
        
        //tree is already balanced
        /*else*/
        return root;
    }

    static Node rightRotate(Node x) {
        //the same as swapping!
        Node y = x.left;
        x.left = y.right;
        y.right = x;
        
        //re-calculate the height of subtree
        x.ht = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.ht = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        
        return y;       
    }

    static Node leftRotate(Node x) {
        //the same as swapping!
        Node y = x.right;
        x.right = y.left;
        y.left = x;   
        
        //re-calculate the height of subtree
        x.ht = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.ht = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        
        return y;
    }

    /**
    *Get balance factor of the tree.
    *If BF > 1  => tree is left - heavy.
    *If BF < -1 => tree is right - heavy.
    */
    static int getBF(Node x) {
        if (x == null) return 0;
        return getHeight(x.left) - getHeight(x.right);
    }

    /**
    *Get height of the tree.
    *if the Node x is null, then the height of x - subtree is -1.
    *else height of tree is ht.
    */
    static int getHeight(Node x) {
        if (x == null) return -1;
        return x.ht;
    }