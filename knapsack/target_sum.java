package knapsack;

public class target_sum {
    public static void main(String[] args) {
        int sum=0;
        int[] A={1,3,1,2,4};
        int N=A.length;
        int target=1;
        for(int i=0;i<N;i++){
            sum+=A[i];
        }
        if((sum+target)%2!=0)
            System.out.println("not possible");
        int ans= solution(N+1,((sum+target)/2)+1,A);
        System.out.println(ans);

    }
    private static int solution(int n,int w,int[] arr){
        int[][] dp=new int[n][w];
        dp[0][0]=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<w;j++){
                if(arr[i-1]<=j){
                    dp[i][j]=dp[i-1][j-arr[i-1]] + dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n-1][w-1];

    }
}
