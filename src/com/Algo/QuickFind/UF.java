package com.Algo.QuickFind;

import java.lang.reflect.Array;

public class UF {

    private int[] id;

    public UF(int n){
        id = new int[n];
        for(int i = 0 ; i < n ; i++)
            id[i]=i;
    }

    public boolean connected(int p,int q){ return root(p) == root(q);}

    public void union(int p, int q){
        int i =root(p);
        int j =root(q);
        id[i] = j;

    }

    private int root(int i){
        while(id[i] != i) {
            id[i] = id[id[i]]; //path compression
            i = id[i];
        }
        return i;
    }
}
