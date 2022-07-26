package DP;
import java.util.*;
public class buy_and_sell_manytimes {
    public static void main(String[] args) {
        int[] values={1,70,9};
        int[][] memory=new int[values.length][2];
        //int ans=buy_sell(values,1,0,values.length);

        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < 2; j++) {
                memory[i][j]=-1;
            }
        }
        int ans_mem=buy_sell_memory(values,1,0,values.length,memory);
        System.out.println(ans_mem);
    }

    private static int buy_sell(int[] values, int buy, int index, int n) {

        if(index==n) return 0;
        int profit=0;
        if (buy==1){
            profit=Math.max(-values[index]+buy_sell(values,0,index+1,n),0+buy_sell(values,1,index+1,n));
        }
        else{
            profit=Math.max(values[index]+buy_sell(values,1,index+1,n),0+buy_sell(values,0,index+1,n));
        }
        return profit;
    }
    private static int buy_sell_memory(int[] values, int buy, int index, int n,int[][] memory) {

        if(index==n) return 0;
        int profit=0;
        if (memory[index][buy]!=-1){
            return memory[index][buy];
        }
        if (buy==1){
            profit=Math.max(-values[index]+buy_sell_memory(values,0,index+1,n,memory),0+buy_sell_memory(values,1,index+1,n,memory));
        }
        else{
            profit=Math.max(values[index]+buy_sell_memory(values,1,index+1,n,memory),0+buy_sell_memory(values,0,index+1,n,memory));
        }
        return memory[index][buy]=profit;
    }
}
