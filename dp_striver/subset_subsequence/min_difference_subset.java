package dp_striver.subset_subsequence;
import java.util.*;
public class min_difference_subset {
    public static void main(String[] args) {
        int[] arr={1399,994, 758, 1101 ,477, 576, 1104 ,1206, 895, 781, 768, 1200, 1039 };
        int ans=solution(arr);
        System.out.println(ans);
    }

    private static int solution(int[] arr) {
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }
        boolean[][] dp=new boolean[arr.length][sum+1];
        for (int i = 0; i < arr.length; i++) {
            dp[i][0]=true;
        }
        dp[0][arr[0]]=true;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <=sum; j++) {
                boolean take=dp[i-1][j];
                boolean not_take=false;
                if (arr[i]<=j){
                    not_take=dp[i-1][j-arr[i]];
                }
                dp[i][j]=take||not_take;
            }
        }
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j <=sum; j++) {
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }
        int min=Integer.MAX_VALUE;
        for (int i = 0; i <=sum/2; i++) {
            if (dp[arr.length-1][i]==true){
                int val=sum-2*i;
                min=Math.min(min,val);
            }
        }
        return min;
    }
}
