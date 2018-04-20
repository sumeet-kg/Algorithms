package com.Algo.Heap;

import java.util.ArrayList;

public class MinHeap<E extends Comparable<E>> {

    private ArrayList<E> list;

    public MinHeap(){
        this.list = new ArrayList<>();
    }

    public void insert(E x){
        list.add(x);
        int i = list.size()-1;
        int p = parent(i);
        while(i != p && list.get(i).compareTo(list.get(p)) < 0 ){
            swap(i,p);
            i = p;
            p = parent(i);
        }
    }

    public void heapify(int i){
        int l = left(i);
        int r = right(i);
        int s = i;
        int n = list.size();
        if(l < n && list.get(l).compareTo(list.get(i)) < 0)
            s=l;
        if(r < n && list.get(r).compareTo(list.get(s)) < 0)
            s=r;

        if(s != i ){
            swap(i,s);
            heapify(s);
        }
    }

    public E getMin(){
        if(list.size()==0) throw new IllegalStateException("Empty Heap");
        else return list.get(0);
    }

    public E exctractMin(){

        if (this.list.size() == 0)
            throw new IllegalStateException("MinHeap is EMPTY");
        else if (list.size() == 1) {
            return list.remove(0);
        }

        E min = list.get(0);
        E lastItem = list.remove(list.size() - 1);
        list.set(0, lastItem);
        heapify(0);
        return min;
    }

    public int size(){return list.size();}

    private void swap(int a, int b){
        E temp = list.get(a);
        list.set(a,list.get(b));
        list.set(b,temp);
    }

    private int left(int i){return 2*i+1;}

    private int right(int i){return 2*i+2;}

    private int parent(int i){return (i-1)/2;}
}
