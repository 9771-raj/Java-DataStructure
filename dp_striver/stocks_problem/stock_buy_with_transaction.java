package dp_striver.stocks_problem;
import java.util.*;
public class stock_buy_with_transaction {
    static int[][] mem;
    public static void main(String[] args) {        // every time you sell you have to give transaction fee
        int[] stocks={1,3,4,2,0,4};
        int fee=2;
        mem=new int[stocks.length][2];
        for(int i=0;i<stocks.length;i++){
            Arrays.fill(mem[i],-1);
        }
        int ans=stockCooldown(0,1,stocks,fee);
        System.out.println(ans);

    }
    private static int stockCooldown(int i, int buy, int[] stocks,int fee) {

        if (i==stocks.length) return 0;
        //if (i>stocks.length) return 0;
        if(mem[i][buy]!=-1) return mem[i][buy];
        int profit=0;
        if (buy==1){
            profit=Math.max(-stocks[i]-fee+stockCooldown(i+1,0,stocks,fee),stockCooldown(i+1,1,stocks,fee));
        }
        else{
            profit=Math.max(stocks[i]+stockCooldown(i+1,1,stocks,fee),stockCooldown(i+1,0,stocks,fee));
        }
        return mem[i][buy]=profit;
    }
}
