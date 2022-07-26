package DP;
import java.util.*;            // Time and space complexity - O(n) and O(n)
public class longest_bitonic_subarr {
    public static void main(String[] args) {
        int[] arr={3, 5, 8, 4, 5, 9, 10, 8, 5, 3, 4};
        int[] increasing=new int[arr.length];
        int[] decreasing=new int[arr.length];
        // increasing part
        increasing[0]=1;
        for (int i = 1; i < arr.length; i++) {
            increasing[i]=1;
            if (arr[i-1]<arr[i]){
                increasing[i]=increasing[i-1]+1;
            }
        }
        System.out.println(Arrays.toString(increasing));
        // decreasing
        decreasing[arr.length-1]=1;
        for (int i=arr.length-2;i>=0;i--){
            decreasing[i]=1;
            if (arr[i+1]<arr[i]){
                decreasing[i]=decreasing[i+1]+1;
            }
        }
        System.out.println(Arrays.toString(decreasing));

        // find max length
        int max=0;
        for (int i = 0; i < arr.length; i++) {
             max=Math.max(max,(increasing[i]+decreasing[i])-1);
        }
        System.out.println(max);
    }
}
