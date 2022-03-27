package Graph;
import java.util.*;
import Graph.graph;
public class dfs_bfs_iteration {
    public static void main(String[] args) {
        graph graph=new graph(8);
        graph.addedge(0,1);
        graph.addedge(1,2);
        graph.addedge(2,4);
        graph.addedge(1,5);
        graph.addedge(5,4);
        graph.addedge(2,3);
        graph.addedge(3,7);
        graph.addedge(7,6);
        List<Integer> ans=new ArrayList<>();
        BFS(0,graph,ans);
        System.out.println("BFS -> "+ans);
        List<Integer> ans_dfs=new ArrayList<>();
        DFS(0,graph,ans_dfs);
        System.out.println("DFS -> "+ans_dfs);
    }
    
   // DFS implemented using the STACK data structure
    private static void DFS(int start, graph graph, List<Integer> ans_dfs) {
        boolean[] visited=new boolean[graph.adj.length];
        Stack<Integer> stack=new Stack<>();
        stack.push(start);
        visited[start]=true;
        while (!stack.isEmpty()){
            int val=stack.pop();
            ans_dfs.add(val);
            Iterator<Integer> it=graph.adj[val].listIterator();
            while (it.hasNext()){
                int n=it.next();
                if(visited[n]==false){
                    stack.push(n);
                    visited[n]=true;
                }
            }
        }
    }

    // BFS is implemented by using the Queue data structure
    private static void BFS(int start, graph graph, List<Integer> ans) {
        boolean[] visited=new boolean[graph.adj.length];
        Queue<Integer> queue=new LinkedList<>();
        queue.add(start);
        visited[start]=true;
        //ans.add(start);
        while (!queue.isEmpty()){
            int val=queue.poll();
            ans.add(val);
            Iterator<Integer> it=graph.adj[val].listIterator();
            while (it.hasNext()){
                int n= it.next();
                if(visited[n]==false){
                    queue.add(n);
                    visited[n]=true;
                }
            }

        }
    }

}
