package dp_striver.subset_subsequence;
import java.util.*;
public class subset_sum_k_exist {
    public static void main(String[] args) {
        int[] arr={1,2,3,4};
        int k=4;
        boolean ans=recursion_exist(arr,arr.length-1,k);
        System.out.println(ans);

        int[][] memory=new int[arr.length][k+1];
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(memory[i],-1);
        }
        boolean ans2=memoization_exist(arr,arr.length-1,k,memory);
        System.out.println(ans2);

        boolean ans3=tabulation_exist(arr,k);
        System.out.println(ans3);
    }

    private static boolean recursion_exist(int[] arr, int index, int k) {
        if (k==0) return true;
        if (index==0) return arr[index]==k;
        boolean not_take=recursion_exist(arr,index-1,k);
        boolean take=false;
        if (k>=arr[index]){
            take=recursion_exist(arr,index-1,k-arr[index]);
        }
        return take || not_take;
    }


    private static boolean memoization_exist(int[] arr,int index,int k,int[][] mem){
        if (k==0) return true;
        if (index==0) return arr[index]==k;
        if (mem[index][k]!=-1){
            if (mem[index][k]==1){
                return true;
            }
            else{
                return false;
            }
        }
        boolean not_take=memoization_exist(arr,index-1,k,mem);
        boolean take=false;
        if (k>=arr[index]){
            take=memoization_exist(arr,index-1,k-arr[index],mem);
        }
        if (take || not_take){
            mem[index][k]=1;
        }
        else{
            mem[index][k]=0;
        }
        return take || not_take;
    }

    private static boolean tabulation_exist(int[] arr,int k){
        boolean[][] dp=new boolean[arr.length][k+1];
        for (int i = 0; i < arr.length; i++) {
            dp[i][0]=true;
        }
        dp[0][arr[0]]=true;
        for (int i = 1; i < arr.length; i++) {
            for (int target = 1; target <=k; target++) {
                boolean not_take=dp[i-1][target];
                boolean take=false;
                if (arr[i]<=target){
                    take=dp[i-1][target-arr[i]];
                }
                dp[i][target]=take||not_take;
            }
        }
        return dp[arr.length-1][k];
    }
}
