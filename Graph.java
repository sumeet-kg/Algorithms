import java.util.ArrayList;

public class Graph {

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