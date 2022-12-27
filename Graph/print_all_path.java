package Graph;
import java.util.*;
import Graph.graph;
public class print_all_path {
    public static void main(String[] args) {
        graph graph=new graph(5);
        graph.addedge(1,3);
        graph.addedge(0,1);
        graph.addedge(1,2);
        graph.addedge(0,4);
        graph.addedge(2,4);
        graph.addedge(3,4);
        LinkedList<Integer> ans=new LinkedList<>();
        int src=0;
        int dest=4;
        boolean[] visited=new boolean[5];
        solution(graph,src,dest,visited,ans);


    }

    private static void solution(graph graph,int src, int dest, boolean[] visited, List<Integer> ans) {
        if(src==dest){
            System.out.println(ans);
            return;
        }
        visited[src]=true;
        for (Integer num:graph.adj[src]){
            if(visited[num]==false){
                ans.add(num);
                solution(graph,num,dest,visited,ans);
                ans.remove(num);
            }
        }
        visited[src]=false;
    }

    // if there is matrix type graph

}
