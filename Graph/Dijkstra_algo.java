package Graph;         // Dijkstra's algorithm work for all types of graph except for negative weighted graph
import java.util.*;
class tuple implements Comparable<tuple>{
    int dest;
    int weight;
    tuple(int x,int y){
        this.dest=x;
        this.weight=y;
    }

    @Override
    public int compareTo(tuple other) {
        return this.weight- other.weight;
    }
}
public class Dijkstra_algo {
    public static void main(String[] args) {
        ArrayList<ArrayList<tuple>> graph=new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(new tuple(1,2));
        graph.get(0).add(new tuple(4,1));
        graph.get(1).add(new tuple(2,3));
        //graph.get(1).add(new tuple(3,2));
        graph.get(2).add(new tuple(3,6));
        //graph.get(2).add(new tuple(5,4));
        //graph.get(3).add(new tuple(1,2));
        //graph.get(3).add(new tuple(4,2));
        graph.get(4).add(new tuple(2,2));
        graph.get(4).add(new tuple(5,4));
        //graph.get(4).add(new tuple(6,6));
        graph.get(5).add(new tuple(3,1));
        //graph.get(5).add(new tuple(4,1));
        //graph.get(6).add(new tuple(4,6));

        //System.out.println(graph);
        int[] distance=new int[graph.size()];
        Arrays.fill(distance,Integer.MAX_VALUE);
        int src=0;
        dijkstra(src,graph,distance);
        System.out.println(Arrays.toString(distance));
    }

    private static void dijkstra(int src, ArrayList<ArrayList<tuple>> graph, int[] distance) {
        PriorityQueue<tuple> pq=new PriorityQueue<>();
        distance[src]=0;
        pq.add(new tuple(src,0));
        while (!pq.isEmpty()){
            tuple t=pq.poll();
            int val=t.dest;
            //System.out.println(wt);
            Iterator<tuple> it=graph.get(val).listIterator();
            while (it.hasNext()){
                tuple nxt=it.next();
                if (distance[val]+nxt.weight<distance[nxt.dest]){
                    distance[nxt.dest]=distance[val]+nxt.weight;
                    pq.add(nxt);
                }// Write your code here// Write your code here
            }
        }
    }
}
