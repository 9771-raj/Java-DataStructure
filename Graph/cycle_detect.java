package Graph;
import Graph.graph;
import java.util.*;
public class cycle_detect {
    public static void main(String[] args) {
        graph graph=new graph(5);
        graph.addedge(1,3);
        graph.addedge(0,3);
        graph.addedge(0,2);
        graph.addedge(1,2);

        System.out.println(solution(graph));

    }

    private static boolean solution(graph graph){
        int v=graph.adj.length;
        boolean[] visited=new boolean[v];
        for (int i = 0; i < v; i++) {
            if (visited[i]==false){
                boolean res=isCycle(visited,graph,i,-1);
                if(res==true){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isCycle(boolean[] visited, graph graph, int index, int parent) {
        visited[index]=true;
        for (Integer num:graph.adj[index]){
            if(visited[num]==false){
                if(isCycle(visited,graph,num,index)==true){
                    return true;
                }
            }
            else if(num!=parent){
                return true;
            }
        }
        return false;
    }
}
