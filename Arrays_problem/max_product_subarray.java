package Arrays_problem;
import java.util.*;  // contiguous sub array
public class max_product_subarray {
    public static void main(String[] args) {
        int[] arr={1,-2,-2,4,-6};
        int min_end=arr[0];
        int max_end=arr[0];
        int max_reach=arr[0];
        for (int i = 1; i < arr.length; i++) {
            int temp=max_end;
            max_end=Math.max(arr[i],Math.max(arr[i]*max_end,arr[i]*min_end));
            min_end=Math.min(arr[i],Math.min(arr[i]*temp,arr[i]*min_end));
            max_reach=Math.max(max_reach,max_end);
        }
        System.out.println(max_reach);

    }
}
