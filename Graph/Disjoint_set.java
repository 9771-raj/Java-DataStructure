package Graph;
import java.util.*;
public class Disjoint_set {
    public static void main(String[] args) {
        int[] parent=new int[10];
        int[] rank=new int[10];
        Arrays.fill(rank,0);
        makeSet(parent);


    }
    private static void Union(int u,int v,int[] parent,int[] rank){
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

    private static int findParent(int node,int[] parent) {
        if (parent[node]==node){
            return node;
        }
        return parent[node]=findParent(parent[node],parent);

    }

    private static void makeSet(int[] parent) {
        for (int i = 0; i < 6; i++) {
            parent[i]=i;
        }
    }
}
