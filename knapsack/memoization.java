package knapsack;

public class memoization {
	
	//Global Matrix
	static int[][] t=new int[7][11];

	public static void main(String[] args) {
		int[] weight= {1,2,3,4,5};
		int[] profit= {2,1,5,2,3};
		int bagwt=9;
		for(int i=0;i<7;i++) {
			for(int j=0;j<11;j++) {
				t[i][j]=-1;
			}
		}
		int ans=memory(weight,profit,bagwt,weight.length);
		System.out.println(ans);
		for(int i=0;i<7;i++) {
			for(int j=0;j<11;j++) {
				System.out.print(t[i][j]+" ");
			}
			System.out.println();
		}

	}
	
	public static int memory(int[] weight, int[] profit, int bagwt, int n) {
		if(bagwt==0 || n==0) {
			return 0;
		}
		if(t[n][bagwt]!=-1) {
			//System.out.println(t[n][bagwt]);
			return t[n][bagwt];
		}
		
		if(weight[n-1]<=bagwt) {
			return t[n][bagwt]=Math.max(
					profit[n-1]+memory(weight,profit,bagwt-weight[n-1],n-1),
					memory(weight,profit,bagwt,n-1)
					);
		}
		else if(weight[n-1]>bagwt) {
			return t[n][bagwt]=memory(weight,profit,bagwt,n-1);
		}
		return 0;
	}

}
