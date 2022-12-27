package Arrays_problem;
import java.util.*;
public class rain_water_trapping {
    public static void main(String[] args) {
        int[] arr={3,1,0,4,5,1,6,2,4};
        int[] left=new int[arr.length];
        int[] right=new int[arr.length];
        left[0]=arr[0];
        for (int i = 1; i < arr.length; i++) {
            left[i]=Math.max(arr[i],left[i-1]);
        }
        right[arr.length-1]=arr[arr.length-1];
        for (int i= arr.length-2;i>=0;i--){
            right[i]=Math.max(right[i+1],arr[i]);
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        int total_water=0;
        for (int i = 0; i < arr.length; i++) {
            total_water+=Math.min(left[i],right[i])-arr[i];
        }
        System.out.println(total_water);
    }
}
