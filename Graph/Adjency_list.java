package Graph;
import java.util.*;

class graph{
    List<Integer> adj[];
    graph(int v){
        adj=new List[v];
        for (int i = 0; i < v; i++) {
            adj[i]=new ArrayList<>();
        }
    }
    public void addedge(int src,int dest){
        adj[src].add(dest);
        //adj[dest].add(src);
    }
}
public class Adjency_list {
    public static void main(String[] args) {
        graph graph=new graph(5);
        graph.addedge(1,3);
        graph.addedge(0,3);
        graph.addedge(0,2);
        graph.addedge(1,2);
        graph.addedge(2,4);
        graph.addedge(0,1);
        for (int i = 0; i < graph.adj.length; i++) {
            System.out.println(graph.adj[i]);
        }

    }
}
