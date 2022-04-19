package Graph;
import java.util.*;
public class num_connected_comp_UGM {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        //
        for (int i = 0; i < 5; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(1).add(0);
        graph.get(0).add(2);
        graph.get(2).add(0);
        graph.get(4).add(3);
        graph.get(3).add(4);
        int count=0;// total number of component
        boolean[] visited=new boolean[5];
        for (int i = 0; i < 5; i++) {
            if (visited[i]==false){
                count++;
                ArrayList<Integer> ans=connected(i,graph,visited);
                System.out.println(ans);
            }
        }
        System.out.println(count);
    }

    private static ArrayList<Integer> connected(int src, ArrayList<ArrayList<Integer>> graph, boolean[] visited) {
        visited[src]=true;
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(src);
        Stack<Integer> st=new Stack<>();
        st.push(src);
        while(!st.isEmpty()){
            int val=st.pop();
            Iterator<Integer> it=graph.get(val).listIterator();
            while (it.hasNext()){
                int num=it.next();
                arr.add(num);
                visited[num]=true;
            }
        }
        return arr;
    }
}
