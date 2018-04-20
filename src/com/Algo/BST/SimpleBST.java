package com.Algo.BST;

import com.Algo.Node.BTreeNode;

public class SimpleBST <Element extends Comparable<Element>> {

    private BTreeNode<Element> root;

    public SimpleBST(Element key){
        this.root = new BTreeNode<Element>(key);
    }

    public void insert(Element x){
        this.root = insert(this.root,x);
    }

    private BTreeNode insert(BTreeNode<Element> temp, Element x){
        if(temp==null) return new BTreeNode<Element>(x);
        if(x.compareTo(temp.key) < 0 ) temp.left = insert(temp.left,x);
        if(x.compareTo(temp.key) > 0 ) temp.right = insert(temp.right,x);
        return temp;
    }

    public void delete(Element x){

        this.root = delete(this.root,x);
    }

    private BTreeNode delete (BTreeNode<Element> temp, Element x){
        if(temp==null) return temp;
        if(x.compareTo(temp.key) < 0 ) temp.left = delete(temp.left,x);
        if(x.compareTo(temp.key) > 0 ) temp.right = delete(temp.right,x);
        else{
            if(temp.left==null) return temp.right;
            if(temp.right==null) return temp.left;
            temp.key = (Element) getMin(temp.right);
            temp.right = delete(temp.right,temp.key);
        }
        return temp;
    }

    public void inorder(){
        inorder(this.root);
    }

    private void inorder(BTreeNode<Element> temp){
        if(temp ==null)return;
        inorder(temp.left);
        System.out.printf("%d ",temp.key);
        inorder(temp.right);

    }

    public Element getMin(){
        return getMin(this.root);
    }

    private Element getMin(BTreeNode<Element> temp){
        Element min = temp.key;
        while(temp.left != null){
            min = (Element) temp.left.key;
            temp =temp.left;
        }
        return min;
    }

    public Element getMax(){
        return getMax(this.root);
    }

    private Element getMax(BTreeNode<Element> temp){
        Element max = temp.key;
        while(temp.right != null){
            max = (Element) temp.right.key;
            temp =temp.right;
        }
        return max;
    }

    private int height(BTreeNode<Element> temp){
        if(temp == null)return 0;
        else return 1+ Math.max(height( temp.left),height(temp.right));
    }

}
