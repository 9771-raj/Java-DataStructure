package LCS;
import java.util.*;
public class LIS {
    public static void main(String[] args) {
        int[] arr={3,4,1,6,7,11,14,9,23};
        int ans=longestINcreasingSubseq(arr,0,-1);
        System.out.println(ans);
        // memory
        dp=new int[arr.length][arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(dp[i],-1);
        }
        int mem_ans=LIS_memoization(arr,0,-1);
        System.out.println(mem_ans);

    }

    private static int longestINcreasingSubseq(int[] arr, int index, int prev_index) {
        if (index==arr.length) return 0;
        int not_take=longestINcreasingSubseq(arr,index+1,prev_index);
        int take=0;
        if (prev_index==-1 || arr[index]>arr[prev_index]){
            take=1+longestINcreasingSubseq(arr,index+1,index);
        }
        return Math.max(take,not_take);
    }

    static int[][] dp;
    private static int LIS_memoization(int[] arr,int index,int prev_index){
        if (index==arr.length){
            return 0;
        }
        if (dp[index][prev_index+1]!=-1) return dp[index][prev_index];
        int len=0+longestINcreasingSubseq(arr,index+1,prev_index);
        if (prev_index==-1 || arr[index]>arr[prev_index]){
            len=Math.max(len,1+longestINcreasingSubseq(arr,index+1,index));
        }
        return dp[index][prev_index+1]=len;

    }
}
