package com.Algo.Node;

public class BTreeNode<Element extends Comparable<Element>> implements Comparable<BTreeNode<Element>> {

    public Element key;
    public BTreeNode left,right;

    public BTreeNode(Element key){
        this.key = key;
        this.left = null;
        this.right = null;
    }

    @Override
    public int compareTo(BTreeNode<Element> o) {
        return this.key.compareTo(o.key);
    }
}
