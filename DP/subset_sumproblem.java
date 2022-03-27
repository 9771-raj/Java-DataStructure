package DP;
import java.util.*;
public class subset_sumproblem {

	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5,6,7};
		int sum=15;
		recursion_targetsum(arr,"",0,sum);

	}

	private static void recursion_targetsum(int[] arr,String str, int i, int sum) {
		if(i==arr.length) {
			if(sum==0) {
				System.out.println("subset found --> "+str);
			}
			return;
		}
		recursion_targetsum(arr,str+arr[i],i+1,sum-arr[i]);
		recursion_targetsum(arr,str,i+1,sum);
		
		
	}

}
