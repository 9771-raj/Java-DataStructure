package DP;
import java.util.*;
public class sum_k_window {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};
        int k=3;

        int ans=solution(arr,k);
        System.out.println(ans);
    }

    private static int solution(int[] arr, int k) {
        int min=Integer.MAX_VALUE;
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
            if (i+1>=k){
                if (sum<min){
                    min=sum;
                }
                sum-=arr[i+1-k];
            }
        }
        return min;
    }
}
