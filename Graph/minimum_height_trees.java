package Graph;
import java.util.*;
public class minimum_height_trees {
    public static void main(String[] args) {
        int[][] mat={
                {1,3},{3,0},{2,3},{3,4},{5,4}
        };


        int num=6;
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for (int i = 0; i < num; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < mat.length; i++) {
            graph.get(mat[i][1]).add(mat[i][0]);
            graph.get(mat[i][0]).add(mat[i][1]);
        }
        System.out.println(graph);
        List<Integer> store=new ArrayList<>();
        for (int i = 0; i < num; i++) {
            store.add(min_height_tree(i,num,graph));

        }
        System.out.println(store);

    }

    private static Integer min_height_tree(int src,int num,ArrayList<ArrayList<Integer>> graph) {
        boolean[] visited=new boolean[num];
        int max=Integer.MIN_VALUE;
        int count=0;
        visited[src]=true;
        Queue<Integer> st=new LinkedList<>();
        st.add(src);
        while (!st.isEmpty()){

            int val=st.poll();
            Iterator<Integer> it=graph.get(val).listIterator();
            while (it.hasNext()){
                int n= it.next();
                if (visited[n]==false){
                    st.add(n);
                    visited[n]=true;
                    count++;
                }

            }

        }
        return count;
    }
}
