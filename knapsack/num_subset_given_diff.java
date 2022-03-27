package knapsack;

public class num_subset_given_diff {

	public static void main(String[] args) {
		int[] arr= {1,1,3,4,2};
		int diff=1;
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
		}
		int ans=solution(arr,sum,diff);
		System.out.println("Count number of subsets of given difference = "+ans);

	}

	private static int solution(int[] arr, int sum, int diff) {
		int s1=(diff+sum)/2;
		int n=arr.length+1;
		int w=s1+1;
		int[][] dp=new int[n][w];
		// code for count subset sum of s1
		//initialize
		for(int i=0;i<n;i++) {
			for(int j=0;j<w;j++) {
				if(j==0) dp[i][j]=1;
			}
		}
		//choice diagram code
		for(int i=1;i<n;i++) {
			for(int j=1;j<w;j++) {
				if(arr[i-1]<=j) {
					dp[i][j]=dp[i-1][j] + dp[i-1][j-arr[i-1]];
				}
				else {
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		return dp[n-1][w-1];
	}

}
