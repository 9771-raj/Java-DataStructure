package Graph;
import Graph.graph;     // For Direected Graph
public class hasPath {
    public static void main(String[] args) {
        graph graph=new graph(5);
        graph.addedge(1,3);
        graph.addedge(0,1);
        graph.addedge(1,2);

        int src=3;
        int dest=0;
        boolean[] visited=new boolean[5];
        boolean ans=solution(graph,src,dest,visited);
        System.out.println(ans);

    }

    private static boolean solution(graph graph, int src, int dest,boolean[] visited) {
        if(src==dest){
            return true;
        }
        visited[src]=true;
        for(Integer num:graph.adj[src]){
            if(visited[num]==false){
                if(solution(graph,num,dest,visited)){
                    return true;
                }
            }
        }
        return false;
    }

}
