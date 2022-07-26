package BinarySearch;
import java.util.*;

class pair implements Comparable<pair> {
    int x;
    int y;
    pair(int a,int b){
        this.x=a;
        this.y=b;
    }
    @Override
    public int compareTo(pair other){
        return this.y- other.y;
    }
}
public class activity_selection {
    public static void main(String[] args) {
        int[] start = {1, 3, 2, 5};
        int[] end= {2, 4, 3, 6};
        pair[] target=new pair[start.length];
        for (int i = 0; i < start.length; i++) {
            target[i]=new pair(start[i],end[i] );
        }

        // print
        for (int i = 0; i < start.length; i++) {
            System.out.println(target[i].x+" "+target[i].y);
        }
        Arrays.sort(target);
        System.out.println("****************");
        for (int i = 0; i < start.length; i++) {
            System.out.println(target[i].x+" "+target[i].y);
        }

        //
        int ans=1;
        int current=target[0].y;
        for (int i = 1; i < start.length; i++) {
            if (current<target[i].x){
                ans++;
                current=target[i].y;
            }
        }
        System.out.println(ans);


    }
}
