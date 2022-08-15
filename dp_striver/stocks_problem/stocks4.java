package dp_striver.stocks_problem;

import java.util.Arrays;

public class stocks4 {
    static int[][][] mem;
    public static void main(String[] args) {
        // k transactions you can make and remain condition same as stocks3 problem
        int[] stocks={2,3,5,6,1};
        int k=3;
        mem=new int[stocks.length][2][k+1];
        for (int i = 0; i < stocks.length; i++) {
            for (int j = 0; j <2; j++) {
                Arrays.fill(mem[i][j],-1);
            }
        }
        int count=k;
        int ans=recursion_stocks(0,1,k,stocks);
        System.out.println(ans);
    }
    private static int recursion_stocks(int i, int buy, int count, int[] stocks) {
        if(count==0) return 0;
        if (i==stocks.length){
            return 0;
        }
        if(mem[i][buy][count]!=-1) return mem[i][buy][count];
        int profit=0;
        if (buy==1){
            profit=Math.max(-stocks[i]+recursion_stocks(i+1,0,count,stocks),recursion_stocks(i+1,1,count,stocks));
        }
        else{
            profit=Math.max(stocks[i]+recursion_stocks(i+1,1,count-1,stocks),recursion_stocks(i+1,0,count,stocks));
        }
        return mem[i][buy][count]=profit;
    }
}
