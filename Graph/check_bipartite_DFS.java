package Graph;
import java.util.*;

public class check_bipartite_DFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(1).add(2);
        graph.get(2).add(1);

        graph.get(3).add(2);
        graph.get(2).add(3);

        graph.get(4).add(3);
        graph.get(3).add(4);

        graph.get(5).add(4);
        graph.get(4).add(5);

        graph.get(8).add(5);
        graph.get(5).add(8);

        graph.get(8).add(2);
        graph.get(2).add(8);

        graph.get(5).add(6);
        graph.get(6).add(5);

        graph.get(7).add(6);
        graph.get(6).add(7);

        System.out.println(graph);

        boolean ans=check_bipartite(graph);
        System.out.println(ans);
    }

    private static boolean check_bipartite(ArrayList<ArrayList<Integer>> graph) {
        //dfs==stack
        int[] color=new int[9];
        int start=1;
        Arrays.fill(color,-1);
        Stack<Integer> stack=new Stack<>();
        stack.push(start);
        color[start]=0;
        while (!stack.isEmpty()){
            int val=stack.pop();
            int clr=color[val];
            Iterator<Integer> it=graph.get(val).listIterator();
            while (it.hasNext()){
                int num=it.next();
                if (color[num]==-1){
                    color[num]=1-clr;
                    stack.push(num);
                }
                else if(color[num]==clr){
                    return false;
                }
            }
        }
        return true;
    }

}
