package Graph;
//link https://leetcode.com/problems/course-schedule/
import java.util.*;
public class course_schedule {
    public static void main(String[] args) {
        int[][] mat={
                {1,0}
        };
        int num=6;
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for (int i = 0; i < num; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < mat.length; i++) {
            graph.get(mat[i][1]).add(mat[i][0]);
        }
        System.out.println(graph);
        boolean[] visited=new boolean[num];
        boolean[] extra=new boolean[num];
        for (int i = 0; i < num; i++) {
            if (cycle_check(i,graph,visited,extra)){
                System.out.println("no");
                break;
            }
        }



    }

    private static boolean cycle_check(int src,ArrayList<ArrayList<Integer>> graph,boolean[] visited,boolean[] extra) {
        visited[src]=true;
        extra[src]=true;
        for (Integer it:graph.get(src)){
            if (visited[it]==false){
                if (cycle_check(it,graph,visited,extra)){
                    return true;
                }
            }
            else if (extra[it]==true){
                return true;
            }
        }
        extra[src]=false;
        return false;
    }
}
