package Graph_revision;
import java.util.*;
public class deviation {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            arr.add(new ArrayList<>());
        }
        arr.get(0).add(1);
        arr.get(1).add(2);
        arr.get(1).add(3);
        arr.get(1).add(4);
        arr.get(2).add(3);
        System.out.println(arr);
        bfs(arr,0);
    }

    private static void bfs(ArrayList<ArrayList<Integer>> arr,int start) {
        Queue<Integer> q=new LinkedList<>();
        ArrayList<Integer> ans=new ArrayList<>();
        q.add(start);
        boolean[] visited=new boolean[10];
        visited[start]=true;
        while(!q.isEmpty()){
            int val=q.remove();
            ans.add(val);
            Iterator<Integer> it=arr.get(val).listIterator();
            while(it.hasNext()){
                int n= it.next();
                if(visited[n]==false){
                    q.add(n);
                    visited[n]=true;
                }
            }
        }
        System.out.println(ans);
    }
}
