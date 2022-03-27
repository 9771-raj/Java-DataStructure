package Graph;
import java.util.*;
public class Bipartite_BFS_check {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        int n=9;
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        //insert node in graph
        graph.get(0).add(1);
        graph.get(1).add(0);
        graph.get(1).add(2);
        graph.get(2).add(1);

        graph.get(3).add(2);
        graph.get(2).add(3);

        graph.get(3).add(4);
        graph.get(4).add(3);

        graph.get(4).add(6);
        graph.get(6).add(4);

        graph.get(5).add(8);
        graph.get(8).add(5);

        graph.get(8).add(2);
        graph.get(2).add(8);

        graph.get(5).add(6);
        graph.get(6).add(5);

        graph.get(7).add(6);
        graph.get(6).add(7);
        System.out.println(graph);

        if(check_bipartite(graph,n)){
            System.out.println(true);
        }
        else
        System.out.println(false);
    }

    private static boolean check_bipartite(ArrayList<ArrayList<Integer>> graph, int n) {
        int[] color=new int[n];
        for (int i = 0; i < n; i++) {
            color[i]=-1;
        }
        for (int i = 0; i < n; i++) {
            if(color[i]==-1){
                if(!BFS_modified(graph,i,color)){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean BFS_modified(ArrayList<ArrayList<Integer>> graph, int node, int[] color) {
        Queue<Integer> queue=new LinkedList<>();
        queue.add(node);
        color[node]=0;
        while (!queue.isEmpty()){
            int nde=queue.poll();
            for(Integer val:graph.get(nde)){
                if(color[val]==-1){
                    color[val]=1-color[nde];
                    queue.add(val);
                }
                else if(color[val]==color[nde]){
                    return false;
                }
            }
        }
        return true;
    }
}
