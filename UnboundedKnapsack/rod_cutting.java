package UnboundedKnapsack;

public class rod_cutting {
	public static void main(String[] args) {
		int[] length= {1,2,3,4,5};
		int[] price= {3,4,12,3,2};
		int N=8;
		// Top down approach
		
		int ans=ubk(length,price,N);
        System.out.println("Maximium profit for rod cutting = "+ans);
	}

	private static int ubk(int[] length, int[] price, int maxlen) {
		int n=length.length+1;
		int w=maxlen+1;
		int[][] dp=new int[n][w];
		//initialize
		for(int i=0;i<n;i++) {
			for(int j=0;j<w;j++) {
				if(i==0 || j==0) {
					dp[i][j]=0;
				}
			}
		}
		
		for(int i=1;i<n;i++) {
			for(int j=1;j<w;j++) {
				if(length[i-1]<=j) {
					dp[i][j]=Math.max(price[i-1]+dp[i][j-length[i-1]],dp[i-1][j]);
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
