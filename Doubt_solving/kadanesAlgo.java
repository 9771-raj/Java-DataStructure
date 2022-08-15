package Doubt_solving;
import java.util.*;
public class kadanesAlgo {
    public static void main(String[] args) {
        int[] arr={-2,-3,4,-1,-2,1,5,-3};
        int sum=0;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
            sum=Math.max(sum,arr[i]);
            max=Math.max(sum,max);
        }
        System.out.println(max);
    }
}
