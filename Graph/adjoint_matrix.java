package Graph;
import java.util.*;
public class adjoint_matrix {
    public static void main(String[] args) {
        int[][] graph={
                {0,1,1}, // Node 1: 40
                {0,0,1}, // Node 2 :10
                {0,1,0}, // Node 2 :10


        };
        boolean[] visited=new boolean[graph.length];
        ArrayList<Integer> ans=bfs(graph,0,visited);
        System.out.println(ans);
    }

    private static ArrayList<Integer> bfs(int[][] graph, int src, boolean[] visited) {
        Queue<Integer> q=new LinkedList<>();
        q.add(src);
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(src);
        visited[src]=true;
        while (!q.isEmpty()){
            int val=q.poll();
            for (int i = 0; i < graph[val].length; i++) {
                if (graph[val][i]==1&&visited[i]==false){
                    q.add(i);
                    arr.add(i);
                    visited[i]=true;
                }
            }
        }
        return arr;
    }
}
