package Graph_revision;
import java.util.*;
class Graph{
    int v;
    List<Integer> adj[];
    Graph(int V){
        this.v=V;
        adj=new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i]=new LinkedList<>();
        }
    }
    public void addEdge(int src,int dest){
        adj[src].add(dest);
        adj[dest].add(src);
    }
    public void show(){
        for (int i = 0; i < v; i++) {
            System.out.println(adj[i]);
        }
    }
    //iterative dfs
    public void dfs(int start){
        Stack<Integer> stack=new Stack<>();
        boolean[] visited=new boolean[v];
        visited[start]=true;
        stack.push(start);
        while (!stack.isEmpty()){
            start=stack.pop();
            System.out.print(start+" ");
            Iterator<Integer> it=adj[start].listIterator();
            while (it.hasNext()){
                int n= it.next();
                //System.out.print(n+" ");
                if(visited[n]==false){
                    visited[n]=true;
                    stack.push(n);
                }
            }
        }

    }
}
public class implement {
    public static void main(String[] args) {
        Graph graph=new Graph(5);
        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(2,0);
        graph.addEdge(0,3);
        graph.addEdge(1,3);
        graph.show();
        graph.dfs(0);
    }

}
