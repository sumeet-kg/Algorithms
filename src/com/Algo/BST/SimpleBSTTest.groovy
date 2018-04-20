package com.Algo.BST

public class SimpleBSTTest {

    public static void main(String[] arg){
        testInsert()
    }

    public static void testInsert() {
        SimpleBST<Integer> bst = new SimpleBST<>(4)
        bst.insert(5)
        bst.insert(6)
        bst.insert(9)
        bst.insert(7)
        bst.insert(15)
        bst.inorder()
    }
}
