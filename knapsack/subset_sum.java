package knapsack;

public class subset_sum {
                // return true or false that subset is available for the required sum
	public static void main(String[] args) {
		int[] arr= {3,4,5,7};
		int sum=12;
		int n=arr.length+1;
		int w=sum+1;
		boolean[][] dp=new boolean[n][w];
		//initialize dp matrix
		for(int i=0;i<n;i++) {
			for(int j=0;j<w;j++) {
				if(i==0) dp[i][j]=false;
				if(j==0) dp[i][j]=true;
			}
		}
		// choice diagram code
		for(int i=1;i<n;i++) {
			for(int j=1;j<w;j++) {
				if(arr[i-1]<=j) {
					dp[i][j]=dp[i-1][j-arr[i-1]] || dp[i-1][j];
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

	}

}
