package dp_striver;
import java.util.*;               // House Robber 1
public class max_sum_subseq_non_adj {
    public static void main(String[] args) {
        int[] arr={1,2,3,9,5,4,6,2,5};
        int ans_rec=house_robber_recursion(arr,arr.length-1);
        System.out.println("Recursion = "+ans_rec);
        int[] memory=new int[arr.length];
        Arrays.fill(memory,-1);
        memory[0]=arr[0];
        int ans2=house_robber_memoization(arr,arr.length-1,memory);
        System.out.println("Memoization = "+ans2);
        int ans3=house_robber_tabulation(arr);
        System.out.println("Tabulation  = "+ans3);
    }

    private static int house_robber_recursion(int[] arr, int index) {

        if (index==0){
            return arr[index]; // means that you can't pick index 1 element
        }
        if (index<0){
            return 0;
        }

        int pick=arr[index]+house_robber_recursion(arr,index-2);  // non adjacent
        int not_pick= 0 + house_robber_recursion(arr,index-1);

        return Math.max(pick,not_pick);
    }

    private static int house_robber_memoization(int[] arr,int index,int[] memory){
        if (index==0) {
            return arr[index];
        }
        if (index<0){
            return 0;
        }
        if (memory[index]!=-1){
            return memory[index];
        }

        int pick=arr[index]+house_robber_memoization(arr,index-2,memory);
        int not_pick=0+house_robber_memoization(arr,index-1,memory);

        return memory[index]=Math.max(pick,not_pick);
    }

    private static int house_robber_tabulation(int[] arr){
        int[] dp=new int[arr.length];
        dp[0]=arr[0];
        for (int i=1;i<arr.length;i++){
            int take=arr[i];
            if(i>1){
                take+=dp[i-2];
            }
            int not_take=dp[i-1];
            dp[i]=Math.max(take,not_take);
        }
        return dp[arr.length-1];
    }

}