package UnboundedKnapsack;

public class coin_change_ways {

	public static void main(String[] args) {
		int[] coin= {1,2,5};
		int sum=8;
		int ans=solution(coin,sum);
        System.out.println("Number of ways for sum using these coin array = "+ans);
	}

	private static int solution(int[] coin, int sum) {
		int n=coin.length+1;
		int w=sum+1;
		int[][] dp=new int[n][w];
		for(int i=0;i<n;i++) {
			for(int j=0;j<w;j++) {
				if(i==0) {
					dp[i][j]=0;
				}
				if(j==0) {
					dp[i][j]=1;
				}
			}
		}
		
		for(int i=1;i<n;i++) {
			for(int j=1;j<w;j++) {
				if(coin[i-1]<=j) {
					dp[i][j]=dp[i-1][j]+dp[i][j-coin[i-1]];
				}
				else {
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		// print matrix
		for(int i=0;i<n;i++) {
			for(int j=0;j<w;j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		return dp[n-1][w-1];
	}

}
