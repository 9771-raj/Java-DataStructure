package knapsack;
import java.util.*;
public class practice_knapsack {
    static int count=0;
    public static void main(String[] args) {
        // subset sum exit
        int[] arr={3,4,5};
        int sum=9;
        boolean is_exit=isSumexit(arr,sum);
        System.out.println("subset sum exit or not - "+(is_exit?"exist":"not exist"));

        // count total subset exit with respective input sum

        recursionCountsubsetSum(arr,0, sum,"");
        System.out.println("total number of subset = "+count);

        // count using tabulation method

        int c=count_table(arr,sum);
        System.out.println("count using tabulation method = "+c);


        ///      Minimum subset sum difference
        int arr_sum=0;
        for (int i = 0; i < arr.length; i++) {
            arr_sum+=arr[i];
        }
        int min_diff=Integer.MAX_VALUE;
        int val=min_subset_diff(arr,arr_sum,min_diff);
        System.out.println("min subset diff = "+val);
    }

    private static int min_subset_diff(int[] arr, int sum,int min) {
        int n=arr.length+1;
        int w=sum+1;
        boolean[][] dp=new boolean[n][w];
        //initialize
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < w; j++) {
                if (j==0){
                    dp[i][j]=true;
                }
            }
        }
        // condition
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < w; j++) {
                if (arr[i-1]<=j){
                    dp[i][j]=dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        // logic on dp last row
        for (int i=0;i<=sum/2;i++){
            if (dp[n-1][i]==true){
                min=Math.min(min,sum-2*i);
            }
        }
        return min;
    }

    private static int count_table(int[] arr, int sum) {
        int n=arr.length+1;
        int w=sum+1;
        int[][] dp=new int[n][w];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < w; j++) {
                if (j==0){
                    dp[i][j]=1;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < w; j++) {
                if (arr[i-1]<=j){
                    dp[i][j]=dp[i-1][j-arr[i-1]] + dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n-1][w-1];
    }

    private static void recursionCountsubsetSum(int[] arr,int n, int sum, String str) {
        if (n== arr.length){

            if (sum==0){
                count++;
                System.out.println("subset found - "+str);
            }
            return;
        }
        recursionCountsubsetSum(arr,n+1,sum-arr[n],arr[n]+str);
        recursionCountsubsetSum(arr,n+1,sum,str);
    }

    private static boolean isSumexit(int[] arr, int sum) {
        int n=arr.length+1;
        int w=sum+1;
        boolean[][] dp=new boolean[n][w];
        //initialize
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < w; j++) {
                if (j==0){
                    dp[i][j]=true;
                }
            }
        }
        // condition
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < w; j++) {
                if (arr[i-1]<=j){
                    dp[i][j]=dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n-1][w-1];
    }
}
