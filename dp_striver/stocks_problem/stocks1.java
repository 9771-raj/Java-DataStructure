package dp_striver.stocks_problem;
import java.util.*;
public class stocks1 {
    public static void main(String[] args) {
        int[] stocks={7,1,2,4,6,3};
        int min=stocks[0];
        int profit=0;
        for (int i=1;i<stocks.length;i++){
            profit=Math.max(profit,stocks[i]-min);
            min=Math.min(min,stocks[i]);
        }
        System.out.println(profit);
    }
}
