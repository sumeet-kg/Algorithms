package com.Algo.Node;


public class Edge<E extends Comparable<E>> implements Comparable<Edge> {

    int to;
    int from;
    E weight;

    public Edge(int to,int from,E weight){
        this.to = to;
        this.from = from;
        this.weight = weight;
    }
    int either(){ return this.to ;}


    int other(int x){
        if(this.to==x)return this.from;
        else return this.to;
    }
    public int compareTo(Edge t){
        return this.weight.compareTo((E)t.weight);
    }

    public E getWeight() {
        return this.weight;
    }
    public String toString(){ return String.format("%d --> %d ",this.to,this.from);}
}
