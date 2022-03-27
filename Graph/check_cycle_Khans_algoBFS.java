package Graph;
import java.util.*;
/*
          we use Khan's algorithm for detecting cycle.
          we know that topological sort is possible for only directed acyclic graph if there is cycle we can't do topological sort

*/
public class check_cycle_Khans_algoBFS {
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
        //graph.get(3).add(5);
        System.out.println(graph);
        Boolean ans=cycle_detect_khan(graph);
        if (!ans){
            System.out.println("Cycle not present");
        }
        else{
            System.out.println("Cycle present");
        }

    }

    private static Boolean cycle_detect_khan(ArrayList<ArrayList<Integer>> graph) {
        //find in degree for each vertex
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
        int count=0;
        // apply BFS
        Queue<Integer> q=new LinkedList<>();
        for (int i = 0; i < graph.size(); i++) {
            if(in_degree[i]==0){
                q.add(i);
            }
        }
        while (!q.isEmpty()){
            int val=q.poll();
            count++;
            for (Integer it:graph.get(val)){
                in_degree[it]--;
                if(in_degree[it]==0){
                    q.add(it);
                }
            }
        }
        System.out.println(count);
        if(graph.size()==count){
            return false;
        }
        return true;

    }
}
