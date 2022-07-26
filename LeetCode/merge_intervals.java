package LeetCode;
import java.util.*;
public class merge_intervals {               // Brute force but optimise
    public static void main(String[] args) {
        int[][] intervals={
                {7,9},{2,6},{8,10},{15,18}
        };
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        //ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        boolean[] visited=new boolean[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            int x=intervals[i][0];
            int y=intervals[i][1];
            if (visited[i]==false){
                visited[i]=true;
                for (int j = i+1; j < intervals.length; j++) {
                    if (y>=intervals[j][0]){
                        if(y>intervals[j][1]){
                            int k=0;   // for fun
                        }
                        else{
                            y=intervals[j][1];
                        }

                        visited[j]=true;
                    }
                }
                ArrayList<Integer> a=new ArrayList<>();
                a.add(x);
                a.add(y);
                ans.add(a);
            }

        }
        int[][] arr=new int[ans.size()][2];
        for(int i=0;i<ans.size();i++){
            arr[i][0]=ans.get(i).get(0);
            arr[i][1]=ans.get(i).get(1);
        }

        System.out.println(ans);
    }
}
