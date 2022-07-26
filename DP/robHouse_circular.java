package DP;
import java.util.*;
public class robHouse_circular {
    public static void main(String[] args) {
        int[] nums={2,1,1,2,3};
        int len=nums.length-1;

        int ans=Math.max(Helper(nums,0,len-1),Helper(nums,1,len));
        System.out.println(ans);
    }

    private static int Helper(int[] nums, int start, int end) {
        int len = nums.length;
        int dp[][] = new int[end+1][2];
        for(int i = start; i <= end; i++){
            if(i == start)
                dp[i][0] = nums[i];
            else{
                dp[i][0] = dp[i-1][1] + nums[i];
                dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1]);
            }
        }
        return Math.max(dp[end][0], dp[end][1]);
    }
}
