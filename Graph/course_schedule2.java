package Graph;
// link leetcode https://leetcode.com/problems/course-schedule-ii/
import java.util.*;
public class course_schedule2 {
    public static void main(String[] args) {
        int[][] mat={
                {1,0},{2,0},{3,1},{3,2}
        };


        int num=4;
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for (int i = 0; i < num; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < mat.length; i++) {
            graph.get(mat[i][1]).add(mat[i][0]);
        }
        boolean[] visited=new boolean[num];
        boolean[] extra=new boolean[num];
        for (int i = 0; i < num; i++) {
            if (cycle_check(i,graph,visited,extra)){
                System.out.println("not possible");
                break;
            }
        }
        int[] ans=new int[num];
        Stack<Integer> st=new Stack<>();
        boolean[] visit=new boolean[num];
        for (int i = 0; i < num; i++) {
            if (visit[i]==false){
                topo_sort(i,graph,visit,st);
            }
        }

        int j=0;
        while(st.size()>0){
            ans[j++]=st.pop();
        }
        System.out.println(Arrays.toString(ans));

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

    private static void topo_sort(int src,ArrayList<ArrayList<Integer>> graph,boolean[] visit,Stack<Integer> st){
        visit[src]=true;
        for (Integer it:graph.get(src)){
            if (visit[it]==false){
                topo_sort(it,graph,visit,st);
            }
        }
        st.push(src);
    }
}
