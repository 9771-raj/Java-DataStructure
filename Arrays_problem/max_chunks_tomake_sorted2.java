package Arrays_problem;
import java.util.Arrays;
public class max_chunks_tomake_sorted2 {
    public static void main(String[] args) {
        int[] arr={30,10,20,40,60,50,75,70};
        int[] left_max=new int[arr.length];
        int[] right_min=new int[arr.length];
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max=Math.max(max,arr[i]);
            left_max[i]=max;
        }
        right_min[arr.length-1]=Integer.MIN_VALUE;
        for (int i = arr.length-1 ;i>=0; i--) {
            min=Math.min(min,arr[i]);
            right_min[i]=min;
        }
        System.out.println(Arrays.toString(left_max));
        System.out.println(Arrays.toString(right_min));
        int chunk=0;
        for (int i = 0; i < arr.length-1; i++) {
            if (left_max[i]<=right_min[i+1]){
                 chunk++;
            }
        }
        System.out.println(chunk);
    }
}
