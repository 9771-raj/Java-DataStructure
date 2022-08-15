package dp_striver.subset_subsequence;

public class min_coins_unbounded_knapsack {
    public static void main(String[] args) {
        int[] coins={1,2,3};
        int target=4;
        int ans=rec_min_coin(coins,coins.length-1,target);
        System.out.println(ans);
    }

    private static int rec_min_coin(int[] coins,int index, int target) {
        if (index==0){
            if (target%coins[0]==0){
                return target/coins[0];
            }
            else
                return Integer.MAX_VALUE;
        }
        int not_take=rec_min_coin(coins,index-1,target);
        int take=Integer.MAX_VALUE;
        if (coins[index]<=target){
            take=1+rec_min_coin(coins, index, target-coins[index]);
        }
        return Math.min(take,not_take);
    }


}
