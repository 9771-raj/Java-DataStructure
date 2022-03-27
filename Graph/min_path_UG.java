package Graph;
import java.util.*;
/*
      BFS
      Given undirected Graph, edge weight is equal to 1,
      find shortest path from a source node to all other node i.e, is minimum
*/
public class min_path_UG {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(2).add(4);
        graph.get(2).add(5);
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(4).add(2);
        graph.get(4).add(3);
        graph.get(4).add(6);
        graph.get(5).add(2);
        graph.get(6).add(4);
        System.out.println(graph);
        int[] distance=new int[graph.size()];
        Arrays.fill(distance,Integer.MAX_VALUE);
        int src=0;
        find_shortestPath(src,graph,distance);
        System.out.println(Arrays.toString(distance));
    }

    private static void find_shortestPath(int src,ArrayList<ArrayList<Integer>> graph, int[] distance) {
        Queue<Integer> q=new LinkedList<>();
        q.add(src);
        distance[src]=0;
        while (!q.isEmpty()){
            int val=q.poll();
            int dist=distance[val];
            Iterator<Integer> it=graph.get(val).listIterator();
            while (it.hasNext()){
                int num=it.next();
                if(dist+1<distance[num]){
                    distance[num]=dist+1;
                    q.add(num);
                }

            }
        }
    }
}
