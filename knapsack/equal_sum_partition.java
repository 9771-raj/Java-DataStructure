package knapsack;

public class equal_sum_partition {

	public static void main(String[] args) {
		int[] arr= {3,5,1,4,8,1,1,1};
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
		}
		boolean ans=solution(arr,sum);
		System.out.println(ans);

	}

	private static boolean solution(int[] arr, int sum) {
		if(sum%2!=0) {
			return false;
		}
		else {
			return call_subsetsum(arr,sum/2);
		}
		
	}

	private static boolean call_subsetsum(int[] arr, int val) {
		int n=arr.length+1;
		int w=val+1;
		boolean[][] dp=new boolean[n][w];
		for(int i=0;i<n;i++) {
			for(int j=0;j<w;j++) {
				if(i==0) dp[i][j]=false;
				if(j==0) dp[i][j]=true;
			}
		}
		for(int i=1;i<n;i++) {
			for(int j=1;j<w;j++) {
				if(arr[i-1]<=j) {
					dp[i][j]=dp[i-1][j] || dp[i-1][j-arr[i-1]];
				}
				else {
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		return dp[n-1][w-1];
	}

}
