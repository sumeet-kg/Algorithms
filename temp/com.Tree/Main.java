
public class Main {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.left.right.right = new Node(6);
        root.right.right = new Node(7);
        /**
         *                          1
         *              2                   3
         *                  4           5       7
         *                      6
         */
        Traversal.printLevelOrderNewLine(root);
        Traversal.printInOrder(root);
        enter();
        Traversal.printInOrder_MorrisTraversal(root);
        enter();
    }
    public static void enter(){
        System.out.printf("\n");
    }

}