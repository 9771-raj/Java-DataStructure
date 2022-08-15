package dp_striver.subset_subsequence;

import java.util.Arrays;

public class knapsack_fixed {
    public static void main(String[] args) {
        int[] wt={1,2,3,4};
        int[] price={10,20,30,40};
        int bag_wt=5;

        int ans=recursion_knapsack(wt.length-1,bag_wt,wt,price);
        System.out.println(ans);
        // memoization
        int[][] mem=new int[wt.length][bag_wt+1];
        for (int i = 0; i < wt.length; i++) {
            Arrays.fill(mem[i],-1);
        }
        int ans2=memoization_knapsack(wt.length-1,bag_wt,wt,price,mem);
        System.out.println(ans2);

        int ans3=tabulation_knapsack(wt,price,bag_wt);
        System.out.println(ans3);
    }

    private static int recursion_knapsack(int i, int bag_wt, int[] wt, int[] price) {
        if (i==0){
            if (wt[i]<=bag_wt){
                return price[0];
            }
            else
                return 0;
        }
        int not_take=recursion_knapsack(i-1,bag_wt,wt,price);
        int take=Integer.MIN_VALUE;
        if (wt[i]<=bag_wt){
            take=price[i]+recursion_knapsack(i-1,bag_wt-wt[i],wt,price);
        }
        int max=Math.max(take,not_take);
        return max;
    }

    private static int memoization_knapsack(int i,int bag_wt,int[] wt,int[] price,int[][] mem){
        if (i==0){
            if (wt[0]<=bag_wt){
                return price[0];
            }
            else
                return 0;
        }
        if (mem[i][bag_wt]!=-1){
            return mem[i][bag_wt];
        }
        int not_take=memoization_knapsack(i-1,bag_wt,wt,price,mem);
        int take=Integer.MIN_VALUE;
        if (wt[i]<=bag_wt){
            take=price[i]+memoization_knapsack(i-1,bag_wt-wt[i],wt,price,mem);
        }
        int max=Math.max(take,not_take);
        return mem[i][bag_wt]=max;
    }

    private static int tabulation_knapsack(int[] wt,int[] price,int bag_wt){
        int[][] dp=new int[wt.length][bag_wt+1];
        for (int i = 0; i <=bag_wt; i++) {
            if (wt[0]<=i){
                dp[0][i]=price[0];
            }else{
                dp[0][i]=0;
            }
        }
        for (int i =1; i < wt.length; i++) {
            for (int j = 0; j <=bag_wt; j++) {
                int not_take=dp[i-1][j];
                int take=Integer.MIN_VALUE;
                if (wt[i]<=j){
                    take=price[i]+dp[i-1][j-wt[i]];
                }
                dp[i][j]=Math.max(take,not_take);
            }
        }
        return dp[wt.length-1][bag_wt];
    }
}
