package dp_striver.partitionDp;

import java.util.Arrays;
/*

You want to schedule a list of jobs in d days. Jobs are dependent (i.e To work on the ith job,
you have to finish all the jobs j where 0 <= j < i).
You have to finish at least one task every day. The difficulty of a job schedule is the sum of difficulties of each day of the d days.
The difficulty of a day is the maximum difficulty of a job done on that day.
You are given an integer array jobDifficulty and an integer d. The difficulty of the ith job is jobDifficulty[i].
Return the minimum difficulty of a job schedule. If you cannot find a schedule for the jobs return -1.

 */
public class minDifficult_jobschedule {
    static int[][] dp;
    public static void main(String[] args) {
        int[] job={6,5,4,3,2,1};
        int d=3;

        int ans=minDifficulty(job,d);
        System.out.println(ans);
    }
    public static int minDifficulty(int[] job, int d) {
        if(job.length<d) return -1;

        dp=new int[d+1][job.length];
        for(int i=0;i<=d;i++){
            Arrays.fill(dp[i],-1);
        }
        int max=dfs(job,0,d);
        return max;
    }
    private static int dfs(int[] job,int ind,int d){
        if(d==1){
            int max=0;
            while(ind<job.length){
                max=Math.max(max,job[ind++]);
            }
            return max;
        }
        if(dp[d][ind]!=-1){
            return dp[d][ind];
        }
        int leftmax=0;
        int max=Integer.MAX_VALUE;
        for(int i=ind;i<job.length-d+1;i++){
            leftmax=Math.max(leftmax,job[i]);
            max=Math.min(max,leftmax+dfs(job,i+1,d-1));
        }
        return dp[d][ind]=max;
    }
}
