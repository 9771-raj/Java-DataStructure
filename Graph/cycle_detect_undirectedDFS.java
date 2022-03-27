package Graph;
import java.util.*;
class Node{
    int src;
    int dest;
    Node(int x,int y){
        this.src=x;
        this.dest=y;
    }
}
class graph_list{
    ArrayList<Integer> adj[];
    graph_list(int v){
        adj=new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adj[i]=new ArrayList<>();
        }
    }
    void add_edge(int src,int dest){
        adj[src].add(dest);
        adj[dest].add(src);
    }
}

public class cycle_detect_undirectedDFS {
    public static void main(String[] args) {
        graph_list graph=new graph_list(5);
        graph.add_edge(0,3);
        //graph.add_edge(1,3);
        graph.add_edge(0,2);
        graph.add_edge(1,2);
        graph.add_edge(2,4);
        //graph.add_edge(0,1);


        boolean ans=DFS_cycle(graph,0,-1);
        System.out.println(ans);

    }

    private static boolean DFS_cycle(graph_list graph, int start, int prev) {
        boolean[] visited=new boolean[5];
        Stack<node> st=new Stack<>();
        st.push(new node(start,prev));
        visited[start]=true;
        while(!st.isEmpty()){
            node n=st.pop();
            int src=n.src;
            int dest=n.dest;
            Iterator<Integer> it=graph.adj[src].listIterator();
            while (it.hasNext()){
                int val=it.next();
                if(visited[val]==false){
                    st.push(new node(val,src));
                    visited[val]=true;
                }
                else if(dest!=val){
                    return true;
                }
            }
        }
        return false;
    }

}
