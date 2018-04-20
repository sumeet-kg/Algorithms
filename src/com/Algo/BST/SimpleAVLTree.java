package com.Algo.BST;

import com.Algo.Node.BTNode_Size;

public class SimpleAVLTree <E extends Comparable<E>> {

    BTNode_Size<E> root;
    
    public SimpleAVLTree(E key) {
        this.root = new BTNode_Size<>(key);
    }

    private BTNode_Size rightRotate(BTNode_Size y) {
        BTNode_Size x = y.left;
        BTNode_Size T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.setHight(Math.max(y.left.getHight(), y.right.getHight()) + 1);
        x.setHight(Math.max(x.left.getHight(), x.right.getHight()) + 1);

        // Return new root
        return x;
    }

    private BTNode_Size leftRotate(BTNode_Size x) {
        BTNode_Size y = x.left;
        BTNode_Size T2 = y.right;

        // Perform rotation
        y.right = x;
        x.left = T2;

        // Update heights
        x.setHight(Math.max(x.left.getHight(), x.right.getHight()) + 1);
        y.setHight(Math.max(y.left.getHight(), y.right.getHight()) + 1);

        // Return new root
        return y;
    }

    private  int getBalance(BTNode_Size N) {
        if (N == null)
            return 0;

        return N.left.getHight()-N.right.getHight();
    }




}
