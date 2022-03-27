package Graph;
import java.util.*;
class Edge implements Comparable<Edge>{
    int dest;
    int wt;
    Edge(int x,int y){
        this.dest=x;
        this.wt=y;
    }
    @Override
    public int compareTo(Edge pair) {
        return this.wt-pair.wt;
    }
}
class Pair implements Comparable<Pair>{
    int v;
    int av;
    int wt;
    Pair(int x,int y,int z){
        this.v=x;
        this.av=y;
        this.wt=z;
    }
    @Override
    public int compareTo(Pair pair) {
        return this.wt-pair.wt;
    }
}

public class Prims_algo_MST {
    public static void main(String[] args) {
        ArrayList<ArrayList<Edge>> graph=new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(new Edge(1,2));
        graph.get(0).add(new Edge(3,6));
        graph.get(1).add(new Edge(0,2));
        graph.get(1).add(new Edge(2,3));
        graph.get(1).add(new Edge(4,5));
        graph.get(1).add(new Edge(3,8));
        graph.get(2).add(new Edge(1,3));
        graph.get(2).add(new Edge(4,7));
        graph.get(3).add(new Edge(0,6));
        graph.get(3).add(new Edge(1,8));
        graph.get(4).add(new Edge(1,5));
        graph.get(4).add(new Edge(2,7));

        print_MST(graph);

    }

    private static void print_MST(ArrayList<ArrayList<Edge>> graph) {
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(0,-1,0));
        boolean[] visited=new boolean[graph.size()];
        while (!pq.isEmpty()){
            Pair p=pq.remove();
            if (visited[p.v]==true){
                continue;
            }
            visited[p.v]=true;
            if(p.av!=-1){
                System.out.println("[ "+p.v+" -> "+p.av+" @ "+p.wt+" ]");
            }
            Iterator<Edge> it=graph.get(p.v).listIterator();
            while (it.hasNext()){
                Edge  e=it.next();
                if (visited[e.dest]==false){
                    pq.add(new Pair(e.dest,p.v,e.wt));
                }
            }
        }
    }


}
