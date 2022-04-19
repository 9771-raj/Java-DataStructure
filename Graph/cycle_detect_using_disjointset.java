package Graph;
import java.util.*;
class edge_{
    int src;
    int dest;
    edge_(int x,int y){
        this.src=x;
        this.dest=y;
    }
}
public class cycle_detect_using_disjointset {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            graph.add(new ArrayList<>());
        }
        int[][] edges={
                {0,1},{0,2},{1,2},{1,3},{2,4},{2,5}
        };
        make_graph(edges,graph);
        System.out.println(graph);
        // initializing disjoint set 
        int[] parent=new int[6];
        int[] rank=new int[6];
        for (int i = 0; i < 6; i++) {
            parent[i]=i;
            rank[i]=0;
        }
        
        // find cycle code
        for (int i = 0; i < graph.size(); i++) {
            Iterator<Integer> it=graph.get(i).listIterator();
            while (it.hasNext()){
                int num=it.next();
                int x=find_parent(i,parent);
                int y=find_parent(num,parent);
                if (x==y){
                    System.out.println("cycle present");
                    break;
                }
                else{
                    find_union(i,num,parent,rank);
                }
            }
        }
        
    }

    private static void make_graph(int[][] edges, ArrayList<ArrayList<Integer>> graph) {
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
    }

    private static void find_union(int val, int num, int[] parent, int[] rank) {
        int u=find_parent(val,parent);
        int v=find_parent(num,parent);
        if (rank[u]<rank[v]){
            parent[u]=v;
        }
        else if (rank[v]<rank[u]){
            parent[v]=u;
        }
        else{
            parent[v]=u;
            rank[v]++;
        }
    }

    private static int find_parent(int val, int[] parent) {
        if(val==parent[val]){
            return val;
        }
        return parent[val]=find_parent(parent[val],parent);
    }
}
