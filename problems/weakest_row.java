package problems;

import java.util.*;

public class weakest_row {
    public static void main(String[] args) {
      int[][] mat=  {{1,1,0,0,0},
            {1,1,1,1,0},
            {1,0,0,0,0},
            {1,1,0,0,0},
            {1,1,1,1,1}};

        HashMap<Integer,Integer> hash=new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            int count=0;
            for (int j = 1; j < mat[0].length; j++) {
                if (mat[i][j]==1){
                    count++;
                }
            }
            hash.put(i,count);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq=new PriorityQueue<>(
                (a,b)->a.getValue()==b.getValue()?a.getKey().compareTo(b.getKey()):a.getValue()-b.getValue()
        );
        for(Map.Entry<Integer,Integer> entry:hash.entrySet()){
            pq.add(entry);
        }
        System.out.println(pq);
        int k=3;
        int[] ans=new int[k];
        int i=0;
        while (pq.size()>k){
            Map.Entry<Integer,Integer> it= pq.poll();
            ans[i++]= it.getKey();
        }
        System.out.println(Arrays.toString(ans));


    }
}
