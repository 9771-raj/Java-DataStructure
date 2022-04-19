package Graph;
import java.util.*;
class edge implements Comparable<edge>{
    int src;
    int dest;
    int wt;
    edge(int z,int x,int y){
        this.src=z;
        this.dest=x;
        this.wt=y;
    }
    @Override
    public int compareTo(edge pair) {
        return this.wt-pair.wt;
    }
}

public class kruskal_algo {

    public static void main(String[] args) {
        ArrayList<edge> graph=new ArrayList<>();

        //
        graph.add(new edge(0,1,2));
        graph.add(new edge(0,3,6));
        graph.add(new edge(1,3,8));
        graph.add(new edge(1,2,3));
        graph.add(new edge(1,4,5));
        graph.add(new edge(2,4,7));

        int[] parent=new int[10];
        int[] rank=new int[10];
        Arrays.fill(rank,0);
        for (int i = 0; i < 7; i++) {
            parent[i]=i;
        }

        kruskal(graph,parent,rank);

    }

    private static void kruskal(ArrayList<edge> graph,int[] parent,int[] rank) {
        PriorityQueue<edge> pq=new PriorityQueue<>();  // store in sorted order if you pop you get firstly minimum weight
        for (edge e:graph){
            pq.add(e);
        }
        int cost=0;
        ArrayList<edge> mst=new ArrayList<>();
        while (!pq.isEmpty()){
            edge e_pop=pq.poll();
            if(findParent(e_pop.src,parent)!=findParent(e_pop.dest,parent)){
                cost+=e_pop.wt;
                mst.add(e_pop);
                union(e_pop.src,e_pop.dest,parent,rank);
            }
        }

        for (edge it:mst){
            System.out.println("[ "+it.src+" -> "+it.dest+" @ "+it.wt+" ]");
        }
        System.out.println("cost = "+cost);
    }

    private static void union(int u, int v, int[] parent, int[] rank) {
        u=findParent(u,parent);
        v=findParent(v,parent);
        if (rank[u]<rank[v]){
            parent[u]=v;
        }
        else if (rank[v]<rank[u]){
            parent[v]=u;
        }
        else {
            parent[v]=u;
            rank[v]++;
        }
    }

    private static int findParent(int i, int[] parent) {
        if(i==parent[i]){
            return i;
        }
        return parent[i]=findParent(parent[i],parent);
    }

}
