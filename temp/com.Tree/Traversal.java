
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;
public  class Traversal {

    public static void printLevelOrder(Node root){
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while(!q.isEmpty()){
            Node top = q.poll();
            System.out.printf("%d ",top.data);
            if(top.left != null) q.add(top.left);
            if(top.right != null) q.add(top.right);
        }

    }
    public static void printLevelOrderNewLine(Node root){
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while(true){
            int count = q.size();
            if(count==0)break;
            while(count > 0){
                Node top = q.poll();
                System.out.printf("%d ",top.data);
                if(top.left != null) q.add(top.left);
                if(top.right != null) q.add(top.right);
                count--;
            }
            System.out.printf("\n");
            
        }

    }
    public static void printInOrder(Node root){
        /**
         * with recursion we have have stack overflow exception
         * hence use stack and do it without recursion
         */
        if(root==null) return;
        printInOrder(root.left);
        System.out.printf("%d ",root.data);
        printInOrder(root.right);
    }
    public static void printInOrder_MorrisTraversal(Node root){
        /**
         * without using any extra space or stack
         */
        if(root==null)return;
        Node curr,pre;
        curr = root;
        while(curr != null){
            if(curr.left==null){
                 System.out.printf("%d ",curr.data);
                 curr =curr.right;
            }else {
                //find inorder predecessor
                pre = curr.left;
                while(pre.right != null && pre.right != curr)
                    pre = pre.right;
                if(pre.right==null){
                    pre.right=curr;
                    curr=curr.left;
                }else{
                    pre.right = null;
                    System.out.printf("%d ",curr.data);
                    curr = curr.right;
                }
            }

        }
    }
    public static void printPreOrder(Node root){
        if(root==null)return;
        System.out.printf("%d ",root.data);
        printPreOrder(root.left);
        printPreOrder(root.right);
    }
    public static void printPostOrder(Node root){
        if(root==null) return;
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.printf("%d ",root.data);
    }
    public static void printPreOrder_MorrisTraversal(Node root){
        Node temp=root, curr;
        while(temp != null){
            if(temp.left==null){
                System.out.pritnf("%d ",root.data);
                temp = temp.right;
            }else {

                curr = temp.left;
                while(curr.right != null && curr.right !=temp){
                    curr = curr.right;
                }
                if(curr.right==temp){
                    curr = curr.right;
                    temp = temp.right;
                }else{
                    System.out.printf("%d ",temp.data);
                    curr.right = temp;
                    temp = temp.left;
                }

            }
        }
    }
    public static void printReverseLevelOrder(Node root ) {
        Stack<Node> s = new Stack<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!Q.isEmpty()){
            Node temp = q.poll();
            s.push(temp);
            if(temp.right != null)q.add(temp.right);
            if(temp.left != null)q.add(temp.left);
        }
        while(!s.isEmpty()){
            System.out.printf("%d ",s.pop().data);
        }
        System.out.printf("\n");
        
    }   

}