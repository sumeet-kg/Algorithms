public class QuickUnion {

    private int[] id;
    private size[] id;

    public QuickUnion(int n){
        id = new int[n];
        for(int i =0 ;i < n ;i ++) id[i]=i;
    }
    private int root(int i){
        while(i != id[i]){
            id[i] = id[id[i]]; //flatening the tree
            //Path compression
            i=id[i];
        }
        return i;
    }
    public boolean connected(int p , int q){
        return root(p)==root(q);
    }
    public void union(int p,int q){
        int i = root(p);
        int j =root(q);
        if(size[i] < size[j]) {
            id[i] = j;
            size[j] +=size[i];
        }else{
            id[j] = i;
            size[i] +=size[j];
        }
        
    }
    /**
     * initialization n <- worst case
     * union lg n <- worst case
     * find lg n < -worst case
     */
}