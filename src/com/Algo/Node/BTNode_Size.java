package com.Algo.Node;

public class BTNode_Size <Element extends Comparable<Element>> implements Comparable<BTNode_Size<Element>>{

    public Element key;
    private int hight;
    public BTNode_Size left,right;

    public BTNode_Size(Element key){
        this.key = key;
        this.left = null;
        this.right = null;
        this.hight = 0;

    }


    @Override
    public int compareTo(BTNode_Size<Element> o) {
        return this.key.compareTo(o.key);
    }

    public int getHight() {
        return hight;
    }

    public void setHight(int hight) {
        this.hight = hight;
    }
}
