package BinarySearch;
import java.util.*;
public class koko_eat_bananas {
    public static void main(String[] args) {
        int[] arr={30,11,23,4,20};
        int hr=9;
        Arrays.sort(arr);
        int ans=minimum_speed(hr,arr);
        System.out.println(ans);


    }


    private static int minimum_speed(int hr,int[] arr){
        int max=arr[arr.length-1];
        if (arr.length==hr){
            return max;
        }
        int low=0;
        int high=max;
        int speed=Integer.MAX_VALUE;
        while (low<=high){
            int mid=low+(high-low)/2;
            if (isPossible(mid,arr,hr)){
                speed=mid;
                high=speed-1;
            }
            else{
                low=mid+1;
            }
        }
        return speed;
    }

    private static boolean isPossible(int mid, int[] arr, int hr) {
        int time=0;
        for (int i = 0; i < arr.length; i++) {
            time+=Math.ceil(arr[i]*1.0/mid);
        }
        return time<=hr;

    }
}
