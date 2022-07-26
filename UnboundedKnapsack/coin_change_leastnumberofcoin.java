package UnboundedKnapsack;

public class coin_change_leastnumberofcoin {
    public static void main(String[] args) {
        int[] arr={1,2,5};
        int target=11;
        int ans=solution(arr,target);

        if (ans!=Integer.MAX_VALUE){
            System.out.println(ans);
        }
        else{
            System.out.println(-1);
        }
    }
    private static int solution(int[] coins,int mt){
        int[] dp=new int[mt+1];
        dp[0]=0;

        for(int i=1;i<=mt;i++){
            dp[i]=Integer.MAX_VALUE;
            int result=Integer.MAX_VALUE;
            for(int c:coins){
                if(i-c>=0){
                    result=dp[i-c];
                }
                if(result!=Integer.MAX_VALUE){
                    dp[i]=Math.min(result+1,dp[i]);
                }
            }

        }
        return dp[mt];
    }
}
