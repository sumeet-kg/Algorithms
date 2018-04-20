
public class Node  {
    int data;
    Node left;
    Node right;

    public Node(int key){
        this.data = key;
        this.left = null;
        this.right = null;
    }
    public static Node insert(Node root , int x ){
        if(root==null) return new Node(x);
        if(x < root.data) root.left = insert(root.left,x);
        if(x > root.data) root.right = insert(root.right,x);
        return root;
    }
    public static Node find(Node root,int x){
        if(root==null) return null;
        if(root.data ==x ) return root;
        if(x < root.data) return find(root.left,x);
        else return find(root.right,x);
     
    }
    public static Node delete(Node root ,int x){
        if(root==null)return root;
        if(x < root.data) root.left = delete(root.left, x);
        if(x > root.data) root.right = delete(root.right, x);
        else {
            if(root.left==null) return root.right;
            if(root.right==null) return root.left;
            root.data = minvalue(root.right).data;
            root.right = delete(root.right, root.data);

        }
        return root;

    }
    private static Node minvalue(Node root){
        int min = root.data;
        while(root.left != null){
            min = root.left.data;
            root = root.left;
        }
        return min;
    }
    public static Node InorderSuccessor(Node root, Node x){
        if(root.right != null) return minvalue(root.right);
        Node succ = null;
        while(root != null){
            if(x.data < root.data){
                succ = root;
                root = root.left;
            }else if (x.data > root.data) root = root.right;
            else break;
        }
        return succ;
    }
}
