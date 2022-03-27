package knapsack;

public class recursion {

	public static void main(String[] args) {
		int[] weight= {1,2,3,4,5};
		int[] profit= {2,1,5,2,3};
		int bagwt=9;
		int ans=knapsackrecursion(weight,profit,bagwt,weight.length);
		System.out.println(ans);

	}
	public static int knapsackrecursion(int[] weight, int[] profit, int bagwt, int n) {
		if(bagwt==0 || n==0) {
			return 0;
		}
		
		if(weight[n-1]<=bagwt) {
			return Math.max(
					profit[n-1]+knapsackrecursion(weight,profit,bagwt-weight[n-1],n-1),
					knapsackrecursion(weight,profit,bagwt,n-1)
					);
		}
		else if(weight[n-1]>bagwt) {
			return knapsackrecursion(weight,profit,bagwt,n-1);
		}
		return 0;
	}

}
