package DP;     //Memorization method

public class fibonacci {
	public static void main(String[] args) {
		int n=10;
		//int ans=fibonacci(10);
		int dpans=fibDp(n,new int[n+1]);
		System.out.println(dpans);
	}

	private static int fibonacci(int n) {
		if(n==0 || n==1) return n;
		int f1=fibonacci(n-1);
		int f2=fibonacci(n-2);
		return f1+f2;
	}
	
	// new modified fibonacci function using dp
	public static int fibDp(int n,int[] memory) {
		if(n==0 || n==1) return n;
		
		if(memory[n]!=0) {
			return memory[n];
		}
		
		int f1=fibDp(n-1,memory);
		int f2=fibDp(n-2,memory);
		int f=f1+f2;
		memory[n]=f;
		return f;
	}

}
