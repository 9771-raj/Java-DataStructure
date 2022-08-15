package dp_striver.stocks_problem;
import java.util.*;
/*
Find the maximum profit you can achieve. You may complete at most two transactions.
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
*/
public class stocks3 {
    static int[][][] mem;
    public static void main(String[] args) {
        int[] stocks={3,3,5,0,0,3,1,4};
        int count=2;
        int ans=recursion_stocks(0,1,count,stocks);
        System.out.println(ans);

        // memoization
        mem=new int[stocks.length][2][3];
        for (int i = 0; i < stocks.length; i++) {
            for (int j = 0; j <2; j++) {
                Arrays.fill(mem[i][j],-1);
            }
        }
        int ans2=memoization_stocks3(0,1,count,stocks);
        System.out.println(ans2);

        // tabulation
        int ans3=tabulation_stocks3(stocks);
        System.out.println(ans3);


    }

    private static int recursion_stocks(int i, int buy, int count, int[] stocks) {
        if (count==0) return 0;
        if (i==stocks.length){
            return 0;
        }
        int profit=0;
        if (buy==1){
            profit=Math.max(-stocks[i]+recursion_stocks(i+1,0,count,stocks),recursion_stocks(i+1,1,count,stocks));
        }
        else{
            profit=Math.max(stocks[i]+recursion_stocks(i+1,1,count-1,stocks),recursion_stocks(i+1,0,count,stocks));
        }
        return profit;
    }

    private static int memoization_stocks3(int i, int buy, int count, int[] stocks) {
        if(count==0) return 0;
        if (i==stocks.length){
            return 0;
        }
        if(mem[i][buy][count]!=-1) return mem[i][buy][count];
        int profit=0;
        if (buy==1){
            profit=Math.max(-stocks[i]+memoization_stocks3(i+1,0,count,stocks),memoization_stocks3(i+1,1,count,stocks));
        }
        else{
            profit=Math.max(stocks[i]+memoization_stocks3(i+1,1,count-1,stocks),memoization_stocks3(i+1,0,count,stocks));
        }
        return mem[i][buy][count]=profit;
    }

    private static int tabulation_stocks3(int[] stocks){
        // base already initialize with so no need to again initialize
        int n=stocks.length;
        int[][][] dp=new int[n+1][2][3];
        for (int i=n-1;i>=0;i--){  //index
            for (int j=0;j<2;j++){ // buy
                for (int k = 1; k < 3; k++) {  // count
                    int profit=0;
                    if (j==1){
                        profit=Math.max(-stocks[i]+dp[i+1][0][k],dp[i+1][1][k]);
                    }
                    else {
                        profit=Math.max(stocks[i]+dp[i+1][1][k-1],dp[i+1][0][k]);
                    }
                    dp[i][j][k]=profit;
                }
            }
        }
        return dp[0][1][2];
    }

}
