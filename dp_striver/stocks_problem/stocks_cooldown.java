package dp_striver.stocks_problem;

public class stocks_cooldown {
    public static void main(String[] args) {
        int[] stocks={1,2,3,0,2};
        int ans=stockCooldown(0,1,stocks);       // we can convert to memoization and tabulation
        System.out.println(ans);
    }

    private static int stockCooldown(int i, int buy, int[] stocks) {

        if (i==stocks.length) return 0;
        if (i>stocks.length) return 0;

        int profit=0;
        if (buy==1){
            profit=Math.max(-stocks[i]+stockCooldown(i+1,0,stocks),stockCooldown(i+1,1,stocks));
        }
        else{
            profit=Math.max(stocks[i]+stockCooldown(i+2,1,stocks),stockCooldown(i+1,0,stocks));
        }
        return profit;
    }
}
