package Graph;
import java.util.*;
// Topological sorting is done on only Directed Acyclic Graph if there is cycle then we can't generate Topological sort
//

public class topological_sort {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            graph.add(new ArrayList<>());
        }
//        graph.get(0).add(1);
//        graph.get(1).add(2);
//        graph.get(1).add(3);
//        graph.get(2).add(3);
//        graph.get(2).add(4);
//        graph.get(3).add(4);
//        graph.get(3).add(5);
        graph.get(5).add(2);
        graph.get(5).add(0);
        graph.get(4).add(0);
        graph.get(4).add(1);
        graph.get(2).add(3);
        graph.get(3).add(1);

        ArrayList<Integer> result=new ArrayList<>();
        result=find_topo(graph);
        System.out.println(result);
    }

    private static ArrayList<Integer> find_topo(ArrayList<ArrayList<Integer>> graph) {
        ArrayList<Integer> result=new ArrayList<>();
        boolean[] visited=new boolean[graph.size()];
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i < graph.size(); i++) {
            if (visited[i]==false){
               topo_sort(i,graph,stack,visited);
            }
        }
       // System.out.println(stack);
        while (!stack.isEmpty()){
            result.add(stack.pop());
        }
        return result;
    }

    private static void topo_sort(int i, ArrayList<ArrayList<Integer>> graph, Stack<Integer> stack,boolean[] visited) {
        visited[i]=true;
        for (Integer it:graph.get(i)){
            if(visited[it]==false){
                topo_sort(it,graph,stack,visited);
            }
        }
        stack.push(i);
    }
}
