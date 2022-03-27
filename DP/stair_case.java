package DP;        // Tabular Method

public class stair_case {

	public static void main(String[] args) {
		int src=5;
		//int ans=using_recur(src);
		int ans_mem=using_memorization(src,new int[src+1]);
		System.out.println(ans_mem);

	}

	private static int using_recur(int src) {
		// use 3 step count 1,2,3
		if(src==0) return 1;
		else if(src<0) return 0;
		int num1=using_recur(src-1);
		int num2=using_recur(src-2);
		int num3=using_recur(src-3);
		return num1+num2+num3;
	}
	
	private static int using_memorization(int src,int[] ans) {
		// use 3 step count 1,2,3
		if(src==0) return 1;
		else if(src<0) return 0;
		
		if(ans[src]>0) return ans[src];
		
		int num1=using_recur(src-1);
		int num2=using_recur(src-2);
		int num3=using_recur(src-3);
		int num=num1+num2+num3;
		ans[src]=num;
		return num;
	}
	
	
    

}
