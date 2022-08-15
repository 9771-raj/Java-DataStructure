package dp_striver.stocks_problem;

import java.util.Arrays;

public class stocks2 {
    static int[][] mem;
    public static void main(String[] args) {
        int[] stocks={7,1,5,3,6,4};
        int ans=recursion_stocks2(0,true,stocks);
        System.out.println(ans);

        // memoization
        mem=new int[stocks.length][2];
        for (int i=0;i<stocks.length;i++){
            Arrays.fill(mem[i],-1);
        }
        int ans2=memoization_stock2(0,1,stocks);
        System.out.println(ans2);

        //

        int ans3=tabulation_stocks2(stocks);
        System.out.println(ans3);
    }

    private static int recursion_stocks2(int i,boolean buy, int[] stocks) {
        if (i==stocks.length-1){
            if (buy==false){
                return stocks[i];
            }
            else{
                return 0;
            }
        }


        if (buy==true){
            int a=-stocks[i]+recursion_stocks2(i+1,false,stocks);
            int b=recursion_stocks2(i+1,true,stocks);
            return Math.max(a,b);
        }
        int sell=stocks[i]+recursion_stocks2(i+1,true,stocks);
        int not_sell=recursion_stocks2(i+1,false,stocks);
        return Math.max(sell,not_sell);

    }

    private static int memoization_stock2(int i,int buy,int[] stocks){
        if (i==stocks.length-1){
            if (buy==0){
                return 0;
            }
            else{
                return 0;
            }
        }
        if (mem[i][buy]!=-1){
            return mem[i][buy];
        }

        if (buy==1){
            int a=-stocks[i]+memoization_stock2(i+1,0,stocks);
            int b=memoization_stock2(i+1,1,stocks);
            return mem[i][buy]=Math.max(a,b);
        }
        int sell=stocks[i]+memoization_stock2(i+1,1,stocks);
        int not_sell=memoization_stock2(i+1,0,stocks);
        return mem[i][buy]=Math.max(sell,not_sell);
    }

    private static int tabulation_stocks2(int[] stocks){
        int[][] dp=new int[stocks.length][2];
        int n=stocks.length;

        dp[n-1][0]=dp[n-1][1]=0;
        for (int i =n-2; i>=0; i--) {
            for (int buy = 0; buy<=1 ; buy++) {
                int profit=0;
                if (buy==1){
                    profit=Math.max(-stocks[i]+dp[i+1][0],dp[i+1][1]);
                }
                else{
                    profit=Math.max(stocks[i]+dp[i+1][1],dp[i+1][0]);
                }

                dp[i][buy]=profit;
            }
        }
        return dp[0][1];
    }


}
