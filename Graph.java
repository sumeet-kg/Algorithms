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