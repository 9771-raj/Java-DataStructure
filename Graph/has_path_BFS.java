package Graph;
import Graph.graph;
import java.util.*;
public class has_path_BFS {
    public static void main(String[] args) {
        graph graph=new graph(5);
        graph.addedge(1,3);
        graph.addedge(0,1);
        graph.addedge(1,2);
        graph.addedge(0,4);
        graph.addedge(2,4);
        graph.addedge(3,4);
        int src=1,dest=4;
        boolean[] visited=new boolean[5];
        boolean ans=solution(graph,src,dest,visited);
        System.out.println(ans);
    }

    private static boolean solution(graph graph, int src, int dest, boolean[] visited) {
        Queue<Integer> queue=new LinkedList<>();
        queue.add(src);
        visited[src]=true;
        while (!queue.isEmpty()){
            int val=queue.poll();
            if(val==dest) return true;
                Iterator<Integer> it=graph.adj[val].listIterator();
                while(it.hasNext()){
                    int num=it.next();
                    if(visited[num]==false){
                        queue.add(num);
                        visited[num]=true;
                    }
                }
        }
        return false;
    }
}
