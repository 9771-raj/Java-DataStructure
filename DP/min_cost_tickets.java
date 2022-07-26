package DP;
import java.util.*;
public class min_cost_tickets {
    static Integer[] dp;
    public static void main(String[] args) {
        int[] days={1,4,6,7,8,20};
        int[] costs={2,7,15};
        dp=new Integer[days.length];
        int recur_ans=Helper(days,costs,0);
        System.out.println(recur_ans);
    }

    private static int Helper(int[] days, int[] costs, int d) {
        if (d>=days.length) return 0;
        if (dp[d]!=null) return dp[d];
        int ans1=Helper(days,costs,d+1)+costs[0];
        int i;
        for(i=d;i<days.length;i++){
            if (days[i]>=days[d]+7){
                break;
            }
        }
        int ans2=Helper(days,costs,i)+costs[1];
        int j;
        for(j=d;j<days.length;j++){
            if (days[j]>=days[d]+30){
                break;
            }
        }
        int ans3=Helper(days,costs,j)+costs[2];

        return dp[d]=Math.min(ans1,Math.min(ans2,ans3));
    }
}