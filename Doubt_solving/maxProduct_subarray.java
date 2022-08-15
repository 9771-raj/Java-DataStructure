package Doubt_solving;
import java.util.*;
public class maxProduct_subarray {
    public static void main(String[] args) {
        int[] arr={-6, 4, -5, 8, -10, 0, 8};
        int ans=brute_force(arr);
        System.out.println(ans);
    }
    private static int brute_force(int[] arr){
        int max=1;
        for (int i = 0; i < arr.length; i++) {
            max=Math.max(max,max*arr[i]);
            System.out.println(max);
        }
        return max;
    }
}
