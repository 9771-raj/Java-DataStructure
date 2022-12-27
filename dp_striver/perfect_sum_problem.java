package dp_striver;
import java.util.*;
public class perfect_sum_problem {
    public static void main(String[] args) {
        int[] arr={9, 7 ,0, 3 ,9, 8 ,6, 5 ,7, 6};


        int sum=31;
        int[][] dp=new int[arr.length+1][sum+1];
        for (int i = 0; i<arr.length; i++) {
            dp[i][0]=1;
        }
        for (int i = 1; i <=arr.length; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j]=dp[i-1][j]%1000000007;
                if (arr[i-1]<=j){
                    dp[i][j]=(dp[i-1][j-arr[i-1]] + dp[i-1][j])%1000000007;
                }

            }
        }
        System.out.println(dp[arr.length][sum]);
    }


}
