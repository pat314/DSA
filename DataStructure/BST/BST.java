class BST {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {this.data = data;}
    }

    Node root;

    /**
     * Các hàm cơ bản trong 1 cây BST:
     * 1. insert
     * 2. delete
     * 3. get
     * 4. height
     * 5. countNode
     * 6. depth
     */

    //0. Constructor
    public BST(int data) {
        this.root = new Node(data);
    }

    /*************************************************************************************
     * 1. Hàm insert
     *
     */
    public void insert(int data) {
        insert(root, data);
    }

    private Node insert(Node x, int data) {
        //nếu giá trị đó không tồn tại trên cây thì ta thêm giá trị đó vào cây
        if (x == null) return new Node(data);
        //nếu giá trị muốn thêm vào cây nhỏ hơn giá trị của đỉnh đang xét thì ta thêm giá trị đó vào cây con bên trái của đỉnh
        if (data < x.data) x.left = insert(x.left, data);
            //nếu giá trị mốn thêm vào cây lớn hơn (hoặc bằng) giá trị của đỉnh đang xét thì ta thêm gái trị đó vào cây con bên phải của đỉnh
        else if (data > x.data) x.right = insert(x.right, data);
        //nếu giá trị đó bằng với một giá trị đã có trên cây (giá trị tại đỉnh ang xét) thì ta trả về đỉnh đó
        /*else if (data == x.data) */ return x;
    }

    /*************************************************************************************
     * 2. Hàm delete
     *
     */
    public void delete (int data) {
        root = delete(root, data);
    }

    private Node delete(Node x, int data) {
        //nếu không tìm thấy đỉnh có dữ liệu cần xóa, thì thôi
        if (x == null) return null;

        //nếu đỉnh đang xét có dữ liệu nhỏ hơn dữ liệu cần xóa, thì ta xóa nó ở cây con bên trái
        if (data < x.data) x.left = delete(x.left, data);
            //nếu đỉnh đang xét có dữ liệu lớn hơn dữ liệu cần xóa
        else if (data > x.data) x.right = delete(x.right, data);
            //nếu dặp đỉnh có dữ liệu xóa
        else {
            //nếu đỉnh đó có 0 hoặc 1 con, thì nối con còn lại lên cha của đỉnh đó
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            //Nếu đỉnh đó có 2 con:
            Node t = x;
            //Tìm đỉnh con trái nhất của cây con bên phải
            x = min(t.right);
            //nối đỉnh nhỏ nhất đó cho liên kết với cây con bên trái và cây con bên phải (sau khi đã bỏ đỉnh nhỏ nhất đó ra khỏi cây) của đỉnh cần xóa
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        //update cây
        return x;
    }

    private Node min(Node x) {
        while (x.left != null) { x = x.left; }
        return x;
    }

    private Node deleteMin(Node x) {
        //nếu node đó là node trái nhất của cây, nối nút cha với node bên phải
        if (x.left == null) return x.right;
        //đi đến node trái nhất của cây từ gốc x
        x.left = deleteMin(x.left);
        //đệ quy nối các node con (ở các tầng cao hơn) lại với node cha ban đầu
        return x;
    }

    /*************************************************************************************
     * 3. Hàm get
     *
     */
    public Node get(int data) {
        Node x = root;
        while (x != null) {
            if (data < x.data) x = x.left;
            else if (data > x.data) x = x.right;
            else return x;
        }
        return null;
    }

    /*************************************************************************************
     * 4. Hàm height
     *
     */
    public int height(Node x) {
        if (x == null) return -1;
        return (Math.max(height(x.left), height(x.right)) + 1);
    }

    /*************************************************************************************
     * 5. Hàm countNode
     *
     */
    public int countNode(Node x) {
        if (x == null) return 0;
        return (countNode(x.left) + countNode(x.right) + 1);
    }

    /*************************************************************************************
     * 6. Hàm depth
     *
     */
    public int depth(Node x, int data, int depth) {
        if (x == null) return -1;

        if (x.data == data) return depth;

        int d = depth(x.left, data, depth + 1);
        if (d != -1) return d;
        //else
        d = depth(x.right, data, depth + 1);
        return d;
    }
}