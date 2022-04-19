package Arrays_problem;
import java.util.*;
public class max_after_3term_multiply {
    public static void main(String[] args) {
        int[] arr={1,4,2,3,};
        // min1 min2 max1 max2 max3
        int min1=Integer.MAX_VALUE;
        int min2=Integer.MAX_VALUE;
        int max1,max2,max3;
        max1=max2=max3=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int val=arr[i];
            if (val>max1){
                max3=max2;
                max2=max1;
                max1=val;
            }
            else if (val>max2){
                max3=max2;
                max2=val;
            }
            else if (val>max3){
                max3=val;
            }
            // min check
            if (val<min1){
                min2=min1;
                min1=val;
            }
            else if (val<min2){
                min2=val;
            }

        }
        System.out.println(min1+" "+min2+" "+max1+" "+max2+" "+max3);
        int val=Math.max((min1*min2*max1),(max1*max2*max3));
        System.out.println(val);
    }
}
