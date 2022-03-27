package Graph;
import java.util.*;
// Topological sorting is done on only Directed Acyclic Graph if there is cycle then we can't generate Topological sort
// use indegree for finding its toposort list
// This Algorithm is known as Khan's Algorithm
// we can use Khan's algorithm for checking that some graph has cycle present or not
public class topo_sortBFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(5).add(2);
        graph.get(5).add(0);
        graph.get(4).add(0);
        graph.get(4).add(1);
        graph.get(2).add(3);
        graph.get(3).add(1);
        System.out.println(graph);
        ArrayList<Integer> ans=find_topo(graph);
        System.out.println(ans);
    }

    private static ArrayList<Integer> find_topo(ArrayList<ArrayList<Integer>> graph) {
        ArrayList<Integer> result=new ArrayList<>();
        int[] in_degree=new int[graph.size()];
        Arrays.fill(in_degree,0);
        for (int i=0;i<graph.size();i++){
            for (int j = 0; j < graph.size(); j++) {
                if(graph.get(j).contains(i)){
                    in_degree[i]+=1;
                }
            }
        }
        System.out.println(Arrays.toString(in_degree));
        // applying BFS
        Queue<Integer> q=new LinkedList<>();
        for (int i = 0; i < graph.size(); i++) {
            if(in_degree[i]==0){
                q.add(i);
            }
        }
        while (!q.isEmpty()){
            int val=q.poll();
            result.add(val);
            for (Integer it:graph.get(val)){
                in_degree[it]--;
                if(in_degree[it]==0){
                    q.add(it);
                }
            }
        }
        return result;
    }
}
