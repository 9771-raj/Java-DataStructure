package job_scheduling_maxProfit;
import java.util.*;
public class max_events_to_attend {
    public static void main(String[] args) {
        int[][] events={{1,2},{2,3},{3,1},{1,2}};
        Arrays.sort(events,(a,b)->(a[1]-b[1]));
        for (int i=0;i< events.length;i++){
            System.out.println(events[i][0]+" "+events[i][1]);
        }
        int d=0;
        int ans=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int i=0;
        

    }
}
