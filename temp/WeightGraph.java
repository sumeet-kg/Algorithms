import java.util.LinkedList;
import java.util.Queue;

public class WeightGraph {

    public class Edge implements Comparable<Edge>{
        int v,w;
        double weight;
        public Edge(int v, int w, double weight){
            this.v = v;
            this.w = w;
            this.weigth = weight;
        }
        public int either() {return v;}
        public int other(int x){
            if(v==x)return w;
            else return v;
        }
        public int compareTo(Edge that){
            if       (this.weight < that.weight)  return -1;
            else if  (this.weight > that.weight)  return  1;
            else                                  return  0;
        }
    }

    class subset{
        int parent, rank;
    }
    int find(subset subsets[], int i){
        // find root and make root as parent of i (path compression)
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
 
        return subsets[i].parent;
    }
 
    // A function that does union of two sets of x and y
    // (uses union by rank)
    void Union(subset subsets[], int x, int y){
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);
 
        // Attach smaller rank tree under root of high rank tree
        // (Union by Rank)
        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
 
        // If ranks are same, then make one as root and increment
        // its rank by one
        else{
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    public void KruskalMST(int V,Edge[] edge){
       
        for (int i=0; i<e; ++i)
            edge[i] = new Edge();

        Edge result[] = new Edge[V];  // Tnis will store the resultant MST
        int e = 0;  // An index variable, used for result[]
        int i = 0;  // An index variable, used for sorted edges
        for (i=0; i<V; ++i)
            result[i] = new Edge();
 
        // Step 1:  Sort all the edges in non-decreasing order of their
        // weight.  If we are not allowed to change the given graph, we
        // can create a copy of array of edges
        Arrays.sort(edge);
 
        // Allocate memory for creating V ssubsets
        subset subsets[] = new subset[V];
        for(i=0; i<V; ++i)
            subsets[i]=new subset();
 
        // Create V subsets with single elements
        for (int v = 0; v < V; ++v)
        {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }
 
        i = 0;  // Index used to pick next edge
 
        // Number of edges to be taken is equal to V-1
        while (e < V - 1)
        {
            // Step 2: Pick the smallest edge. And increment 
            // the index for next iteration
            Edge next_edge = new Edge();
            next_edge = edge[i++];
 
            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);
 
            // If including this edge does't cause cycle,
            // include it in result and increment the index 
            // of result for next edge
            if (x != y)
            {
                result[e++] = next_edge;
                Union(subsets, x, y);
            }
            // Else discard the next_edge
        }

    }

}