package dp_striver.subset_subsequence;
import java.util.*;
public class count_subsets_k {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,2};
        int target=5;
        int ans=recursion_count(arr,arr.length-1,target);
        System.out.println(ans);

        // Memoization
        int[][] mem=new int[arr.length][target+1];
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(mem[i],-1);
        }
        int ans2=memoization_count(arr,arr.length-1,target,mem);
        System.out.println(ans2);

        // tabulation
        int ans3=tabulation_count(arr,target);
        System.out.println(ans3);
    }

    private static int recursion_count(int[] arr, int index, int target) {
        if (target==0){
            return 1;
        }
        if (index==0){
            return arr[index]==target?1:0;
        }
        if (index<0){
            return 0;
        }
        int not_take=recursion_count(arr,index-1,target);
        int take=0;
        if (arr[index]<=target){
            take=recursion_count(arr,index-1,target-arr[index]);
        }
        return take+not_take;

    }
    static int memoization_count(int[] arr,int index,int target,int[][] mem){
        if (target==0){
            return 1;
        }
        if (index<0){
            return 0;
        }
        if (index==0){
            return arr[index]==target?1:0;
        }
        if (mem[index][target]!=-1){
            return mem[index][target];
        }
        int not_take=memoization_count(arr,index-1,target,mem);
        int take=0;
        if (arr[index]<=target){
            take=memoization_count(arr,index-1,target-arr[index],mem);
        }
        return mem[index][target]=take+not_take;
    }

    static int tabulation_count(int[] arr,int target){
        int[][] dp=new int[arr.length][target+1];
        for (int i=0;i<arr.length;i++){
            dp[i][0]=1;
        }
        if (arr[0]<=target){
            dp[0][arr[0]]=1;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j <=target; j++) {
                int not_take=dp[i-1][j];
                int take=0;
                if (arr[i]<=j){
                    take=dp[i-1][j-arr[i]];
                }
                dp[i][j]=take+not_take;
            }
        }
        return dp[arr.length-1][target];
    }

}
