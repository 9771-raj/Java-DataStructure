package LeetCode;
import java.util.*;
public class max_units_on_truck {
    static class pair implements Comparable<pair>{
        int x;
        int y;
        pair(int a,int b){
            this.x=a;
            this.y=b;
        }

        @Override
        public int compareTo(pair pair) {
            return this.y-pair.y;
        }
    }
    public static void main(String[] args) {
        int[][] arr={
                {5,10},{2,5},{4,7},{3,9}
                //{1,3},{3,1},{2,2}
        };
        int size=10;
        PriorityQueue<pair> list=new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            list.add(new pair(arr[i][0],arr[i][1]));
        }
        int total=0;
        int curr=0;
        while (total<size  || !list.isEmpty() ){
            pair p=list.poll();
            int remain=size-total;
            if (remain>=p.x){
                curr+=p.x*p.y;
                total+= p.x;
            }
            else if (remain<p.x){
                int lena_hai=remain;
                curr+=lena_hai*p.y;
                total+=lena_hai;
            }
        }
        System.out.println(curr);

    }
}
