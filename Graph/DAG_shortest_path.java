package Graph;
import java.util.*;
/*
         For finding the shortest path in directed acyclic graph
         we helped from the DFS trick for finding the topological sort
         then from stack for finding the shortest from the starting point
*/
class pair{
    int dest;
    int wt;
    pair(int x,int y){
        this.dest=x;
        this.wt=y;
    }
}
public class DAG_shortest_path {
    public static void main(String[] args) {
        ArrayList<ArrayList<pair>> graph=new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(new pair(1,2));
        graph.get(0).add(new pair(4,1));
        graph.get(1).add(new pair(2,3));
        graph.get(2).add(new pair(3,6));
        graph.get(4).add(new pair(2,2));
        graph.get(4).add(new pair(5,4));
        graph.get(5).add(new pair(3,1));

        boolean[] visited=new boolean[graph.size()];
        // for finding the topological sort
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i < graph.size(); i++) {
            if(visited[i]==false){
                finding_topo(i,graph,visited,stack);
            }
        }
        System.out.println("Topological sort = "+stack);

        // for finding the shortest path
        int[] distance=new int[graph.size()];
        Arrays.fill(distance,Integer.MAX_VALUE);
        // starting point is 0
        distance[0]=0;
        while (!stack.isEmpty()){
            int s=stack.pop();
            find_distance(s,graph,distance);
        }
        System.out.println("Shortest path = "+Arrays.toString(distance));

    }

    private static void find_distance(int start, ArrayList<ArrayList<pair>> graph, int[] distance) {

        Iterator<pair> it=graph.get(start).listIterator();
        while (it.hasNext()){
            pair p=it.next();
            if(distance[start]+p.wt<distance[p.dest]){
                distance[p.dest]=distance[start]+p.wt;
            }
        }

    }

    private static void finding_topo(int src, ArrayList<ArrayList<pair>> graph, boolean[] visited, Stack<Integer> stack) {
        visited[src]=true;
        for (pair it:graph.get(src)){
            if (visited[it.dest]==false){
                finding_topo(it.dest,graph,visited,stack);
            }
        }
        stack.push(src);
    }
}
