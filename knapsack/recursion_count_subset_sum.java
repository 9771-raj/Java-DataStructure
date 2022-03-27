package knapsack;

public class recursion_count_subset_sum {
    static int count=0;
	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5};
		int target=9;
		solution(arr,"",0,target);
		System.out.println(count);

	}
	private static void solution(int[] arr, String str, int i, int target) {
		if(i==arr.length) {
			if(target==0) {
				count++;
				System.out.println("subset found -> "+str);
			}
			return;
		}
		
		solution(arr,str+arr[i],i+1,target-arr[i]);
		solution(arr,str,i+1,target);
		
	}

}
