package knapsack;

public class topdown {

	public static void main(String[] args) {
		int[] weight= {1,2,3,4,5};
		int[] profit= {2,1,5,2,3};
		int bagwt=9;
		int n=weight.length+1;
		int w=bagwt+1;
		int[][] t=new int[n][w];
		for(int i=0;i<n;i++) {
			for(int j=0;j<w;j++) {
				if(i==0 || j==0) {
					t[i][j]=0;
				}
			}
		}
		for(int i=1;i<n;i++) {
			for(int j=1;j<w;j++) {
				if(weight[i-1]<=j) {
					t[i][j]=Math.max(profit[i-1]+t[i-1][j-weight[i-1]],t[i-1][j]);
				}
				else {
					t[i][j]=t[i-1][j];
				}
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<w;j++) {
				System.out.print(t[i][j]+" ");
			}
			System.out.println();
		}

	}

}
