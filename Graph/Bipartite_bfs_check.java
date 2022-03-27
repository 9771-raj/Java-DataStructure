package Graph;
import java.util.*;

public class Bipartite_bfs_check {
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
        int start=1;
        //bfs== queue
        int[] color=new int[graph.size()];
        for (int i = 0; i < graph.size(); i++) {
            color[i]=-1;
        }
        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        color[1]=0;
        while (!q.isEmpty()){
            int val=q.remove();
            int val_color=color[val];
            Iterator<Integer> it=graph.get(val).listIterator();
            while (it.hasNext()){
                int num=it.next();
                if(color[num]==-1){
                    color[num]=1-val_color;
                    q.add(num);
                }
                else if(color[num]==val_color){
                    return false;
                }
            }
        }
        return true;

    }
}
