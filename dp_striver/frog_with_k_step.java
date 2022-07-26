package dp_striver;

import java.util.Arrays;

public class frog_with_k_step {
    public static void main(String[] args) {
        int[] arr={1,20,31,10,20,30,50};
        int k=4;
        int ans_rec=frog_with_k_step_recursion(arr,k,arr.length-1);
        System.out.println("Recursion = "+ans_rec);
        int ans2=frog_with_k_step_tabulation(arr,k);
        System.out.println(ans2);
    }

    private static int frog_with_k_step_recursion(int[] arr, int k, int index) {
        if (index==0){
            return 0;
        }
        int min=Integer.MAX_VALUE;
        for (int i=1;i<=k;i++){
            if (index-i>=0){
                int result=frog_with_k_step_recursion(arr,k,index-i)+Math.abs(arr[index]-arr[index-i]);
                min=Math.min(min,result);
            }
        }
        return min;
    }
    private static int frog_with_k_step_tabulation(int[] arr,int k){
        int[] dp=new int[arr.length];
        Arrays.fill(dp,-1);
        dp[0]=0;
        for (int i = 1; i < arr.length; i++) {
            int min=Integer.MAX_VALUE;
            for (int j=1;j<k;j++){
                if (i-j>=0){
                    int jump=dp[i-j]+Math.abs(arr[i]-arr[i-j]);
                    min=Math.min(min,jump);
                }
            }
            dp[i]=min;
        }
        System.out.println(Arrays.toString(dp));
        return dp[dp.length-1];
    }
}
