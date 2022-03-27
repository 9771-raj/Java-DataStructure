package knapsack;

public class min_subset_sum_diff {

	public static void main(String[] args) {
		int[] arr= {3,4,5};
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
		}
		int  ans=modified_subsetsum(arr,sum);
		System.out.println();
        System.out.println("Minimum subset sum difference = "+ans);
	}

	private static int modified_subsetsum(int[] arr, int sum) {
		int n=arr.length+1;
		int w=sum+1;
		int diff=Integer.MAX_VALUE;
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
		// intrepret dp matrix for find abs(sum-2s1) of last row those has true value	
		for(int j=0;j<=sum/2;j++) {
			if(dp[n-1][j]==true) {
				diff=Math.min(diff, sum-2*j);
			}
		}
		return diff;
	}

}
