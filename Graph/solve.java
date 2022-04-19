package Graph;
import java.util.*;
public class solve {
    public static void main(String[] args) {
        int s=0;
        int d=2;
        int[][] edges={
                {0,1},{0,2},{3,5},{5,4},{4,3}
        };
        int n=6;
        int[][] graph=new int[n][n];
        for(int i=0;i<n-1;i++){
            make_graph(graph,edges[i][0],edges[i][1]);
        }

        boolean[] visited=new boolean[n];
        boolean ans=solution(graph,visited,s,d);
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(ans);
    }
    private static void make_graph(int[][] graph,int src,int dest){
        graph[src][dest]=1;
        graph[dest][src]=1;
    }
    private static boolean solution(int[][] graph,boolean[] visited, int s, int d){
        if(s==d) return true;
        visited[s]=true;
        for(int i=0;i<graph.length;i++){
            if(graph[s][i]==1 && visited[i]==false){
                if(solution(graph,visited,i,d)){
                    return true;
                }
            }
        }
        return false;
    }
}
