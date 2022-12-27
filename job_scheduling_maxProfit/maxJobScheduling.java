package job_scheduling_maxProfit;
import java.util.*;
class job{
    int s,e,p;
    job(int x,int y,int z){
        this.s=x;
        this.e=y;
        this.p=z;
    }
}
public class maxJobScheduling {
    public static void main(String[] args) {
                 // startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
    }
    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<job> jobs=new ArrayList<>();
        for(int i=0;i<startTime.length;i++){
            jobs.add(new job(startTime[i],endTime[i],profit[i]));
        }

        int ans=0;
        Collections.sort(jobs,(a,b)->(a.e-b.e));    // sort wrt end-time
        TreeMap<Integer,Integer> maps=new TreeMap<>();
        for(job j:jobs){
            Integer start=maps.floorKey(j.s);
            int end_profit = start==null?0:maps.get(start);
            ans=Math.max(ans,end_profit+j.p);
            maps.put(j.e,ans);
        }
        return ans;
    }
}
