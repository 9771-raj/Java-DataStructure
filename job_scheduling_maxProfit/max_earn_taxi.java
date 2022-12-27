package job_scheduling_maxProfit;
import java.util.*;
class ride{
    int start,end,tip;
    ride(int x,int y,int z){          // use treemap
        this.start=x;
        this.end=y;
        this.tip=z;
    }
}
public class max_earn_taxi {
    public static void main(String[] args) {   // format of rides (start,end,tip)-> end-start+tip
        int[][] rides={{1,6,1},{3,10,2},{10,12,3},{11,12,2},{12,15,2},{13,18,1}};
        int n=20;
        long ans=maxTaxiEarnings(n,rides);
        System.out.println(ans);

    }
    public static long maxTaxiEarnings(int n, int[][] rides) {

        List<ride> rides_list=new ArrayList<>();
        for(int i=0;i<rides.length;i++){
            rides_list.add(new ride(rides[i][0],rides[i][1],rides[i][2]));
        }
        Collections.sort(rides_list,(a,b)->(a.end-b.end));

        TreeMap<Integer,Long> map=new TreeMap<>();
        int ans=0;
        map.put(0,0l);
        for(ride r:rides_list){
            Integer floor_val=map.floorKey(r.start);
            long p=0;
            if(map.containsKey(r.end)){
                p=map.get(r.end);
            }
            long q=map.get(floor_val)+r.end-r.start+r.tip;
            if(q>p && map.lastEntry().getValue() < q){
                map.put(r.end,q);
            }
            map.put(0,0l);
        }
        return map.lastEntry().getValue();

    }
}
