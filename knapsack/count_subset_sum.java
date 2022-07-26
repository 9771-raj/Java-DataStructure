package knapsack;

public class count_subset_sum {

	public static void main(String[] args) {
		int[] arr= {4,5,1};
		int sum=4;
		int ans=solution(arr,sum);
        System.out.println(ans);
	}

	private static int solution(int[] arr, int sum) {
		int n=arr.length+1;
		int w=sum+1;
		int[][] dp=new int[n][w];
		//initialize dp matrix
		for(int i=0;i<n;i++) {
			for(int j=0;j<w;j++) {
				if(i==0) dp[i][j]=0;
				if(j==0) dp[i][j]=1;
			}
		}
		//choice diagram
		for(int i=1;i<n;i++) {
			for(int j=1;j<w;j++) {
				if(arr[i-1]<=j) {
					dp[i][j]=dp[i-1][j]+dp[i-1][j-arr[i-1]];
				}
				else {
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		return dp[n-1][w-1];
	}

}
