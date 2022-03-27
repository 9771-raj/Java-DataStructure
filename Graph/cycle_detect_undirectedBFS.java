package Graph;
import java.util.*;
class node{
    int src;
    int dest;
    node(int x,int y){
        this.src=x;
        this.dest=y;
    }
}
class Graph_list{
    List<Integer> adj[];
    Graph_list(int v){
        adj=new List[v];
        for (int i = 0; i < v; i++) {
            adj[i]=new LinkedList<>();
        }
    }
    public void addEdge(int src,int dest){
        adj[src].add(dest);
        adj[dest].add(src);
    }
}
public class cycle_detect_undirectedBFS {
    public static void main(String[] args) {
        Graph_list graph=new Graph_list(5);
        graph.addEdge(0,3);
        graph.addEdge(1,3);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(2,4);
        graph.addEdge(0,1);

        boolean[] visited=new boolean[5];
        boolean ans=solution(graph,visited);
        System.out.println(ans);
    }

    private static boolean solution(Graph_list graph,boolean[] visited) {
        for (int i = 0; i < 5; i++) {
            if(visited[i]==false){
                boolean res=IsCyclic(graph,visited,i);
                if(res==true){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean IsCyclic(Graph_list graph, boolean[] visited, int src) {
        Queue<node> queue=new LinkedList<>();
        visited[src]=true;
        queue.add(new node(src,-1));
        while (!queue.isEmpty()){
            int val=queue.peek().src;
            int parent=queue.peek().dest;
            queue.poll();
            Iterator<Integer> it=graph.adj[val].listIterator();
            while (it.hasNext()){
                int num=it.next();
                if(visited[num]==false){
                    queue.add(new node(num,val));
                    visited[num]=true;
                }
                else  if(parent!=num){
                    return true;
                }
            }
        }
        return false;
    }
}
