package Graph;
import java.util.*;
public class finding_path_leetcode {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        int[][] edges={
                {0,1},{0,2},{3,5},{5,4},{4,3}
        };
        for (int i = 0; i < 6; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        System.out.println(graph);
        boolean[] visited=new boolean[6];
        solution(graph,1,2,visited);

    }
    private static boolean solution( ArrayList<ArrayList<Integer>> graph, int s, int d, boolean[] visited) {
        if(d==s){
            return true;
        }
        visited[s]=true;
        for(Integer num:graph.get(s)){
            if(visited[num]==false){
                if(solution(graph,num,d,visited)){
                    return true;
                }
            }
        }
        return false;
    }
}
