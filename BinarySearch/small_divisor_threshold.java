package BinarySearch;
import java.util.*;
public class small_divisor_threshold {
    public static void main(String[] args) {
        int[] arr={44,22,33,11,1};
        int threshold=5;
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }
        int low=0;
        int high=Integer.MAX_VALUE;
        int divisor=Integer.MAX_VALUE;
        while (low<=high){
            int mid=low+(high-low)/2;
            int div_sum=0;
            for (int i=0;i<arr.length;i++){
                div_sum+=Math.ceil(arr[i]*1.0/mid);
            }
            if (div_sum<=threshold){
                divisor=mid;
                high=mid-1;

            }
            else{
                low=mid+1;
            }
        }
        System.out.println(divisor);
    }
}
