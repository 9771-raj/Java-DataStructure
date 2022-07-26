package dp_striver;
import java.lang.reflect.Array;
import java.util.*;

/*
*       Find minimum cost that a frog can from its start position to end
*       can jump 1 and 2 step only at a time.
*/
public class frog_jump {
    public static void main(String[] args) {
        int[] arr={10,20,30,10};

        int ans=min_cost(arr,arr.length-1);
        System.out.println("Recursion Approach = "+ans);
        int[] memory=new int[arr.length];
        Arrays.fill(memory,-1);
//        int ans_memoization=min_cost_memoization(arr,arr.length-1,memory);
//        System.out.println(ans_memoization);
        int a=tabulation(arr);
        System.out.println(a);
    }

    private static int min_cost(int[] arr, int index) {
        if (index==0){
            return 0;
        }
        int step_1=min_cost(arr,index-1)+Math.abs(arr[index]-arr[index-1]);
        int step_2=Integer.MAX_VALUE;
        if (index>1){
            step_2=min_cost(arr,index-2)+Math.abs(arr[index]-arr[index-2]);
        }
        return Math.min(step_1,step_2);

    }

    private static int min_cost_memoization(int[] arr,int index,int[] memory){
        if (index==0){
            return 0;
        }
        if (memory[index]!=-1){
            return memory[index];
        }
        int step_1=min_cost_memoization(arr,index-1,memory)+Math.abs(arr[index]-arr[index-1]);
        int step_2=Integer.MAX_VALUE;
        if (index>1){
            step_2=min_cost_memoization(arr,index-2,memory)+Math.abs(arr[index]-arr[index-2]);
        }
        return memory[index]=Math.min(step_1,step_2);

    }

    private static int tabulation(int[] arr){
        int[] dp=new int[arr.length+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        for (int i=1;i< arr.length;i++){
            dp[i]=dp[i-1]+Math.abs(arr[i]-arr[i-1]);
            if (i>1){
                dp[i]=dp[i-2]+Math.abs(arr[i]-arr[i-2]);
            }
        }
        return dp[arr.length-2];
    }
}
