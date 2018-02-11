import java.util.ArrayList;

public class Graph {

    public void BFS(ArrayList<ArrayList<Integer>> adj,int n,int s){
         /**
          * Applicaition
          *     Web Crowling
                social networking
                network broadcasting
                garbage collection
                model checking
          */
          /**
           * Visit all nodes reachable from given  set
           * O(V+E) time
           */
          boolean[] marked = new boolean[n];
          for(int i = 0 ; i < n ; i++) marked[i]=false;
          Queue<Integer> q = new LinkedList<>();
        q.add(s);
        while(!q.isEmpty()){
            int v = q.remove();
            for(int w:adj.get(v)){
                if(!marked[w]){
                    q.add(w);
                    marked[w] = true;
                }
            }
        }
    }
        //TODO: DFS
        //TODO: PERT

    public void topologicalSort(ArrayList<ArrayList<Integer>> adj){
        /**
         * Used in DAG only
         */
        int v = adj.size();
        boolean[] marked = new boolean[n];
        Stack<Integer> repost = new Stack<Integer>(); // reverse postorder of Grapy
        for(int k = 0 ; k < n ; k++){
            if(!marked[v]) ts_DFS(adj,marked,repost,k);
        }

    }
    public void ts_DFS( ArrayList<ArrayList<Integer>> adj, boolean[] marked,Stack<Integer> repost,int v ){
        marked[v]=true;
        for(int w : adj.get(v)){
            if(!marked[w]) ts_DFS(adj, marked, repost, w);
            repost.push(v);
        }
    }
    public void stronglyConnectedComponent(){
        /**
         * Kosaraju dfs(twice)
         */

    }
    public void connectedComponen(ArrayList<ArrayList<Integer>> adj){
        int v = adj.size();
        boolean[] marked = new boolean[v];
        int[] id = new int[v];
        int count  = 0;
        for(int i = 0 ; i < v ; i++){
            if(!marked[i]){
                cc_DFS(adj, marked, id, count, i);
                count++;
            }
        } 
    }
    public void cc_DFS( ArrayList<ArrayList<Integer>> adj, boolean[] marked,int[] id,int count,int v ){
        marked[v]=true;
        id[v] = count;
        for(int w : adj.get(v)){
            if(!marked[w]) ts_DFS(adj, marked, repost, w);
        }
    }

    //extra helpher functions
    public ArrayList<ArrayList<Integer>> DAG_adjList(int[][] arr){

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        for(int i = 0 ; i < arr.length ;i++)
            adj.set(i, new ArrayList<Integer>());

        for(int i = 0 ; i < arr.length ;i++)
            adj.get(arr[i][0]).add(arr[i][1]);

        return adj;
    }

    public ArrayList<ArrayList<Integer>> adjList(int[][] arr){

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        for(int i = 0 ; i < arr.length ;i++)
            adj.set(i, new ArrayList<Integer>());

        for(int i = 0 ; i < arr.length ;i++){
            adj.get(arr[i][0]).add(arr[i][1]);
            adj.get(arr[i][0]).add(arr[i][1]);
        }
        return adj;
    }
    


}