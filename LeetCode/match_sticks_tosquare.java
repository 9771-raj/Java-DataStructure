package LeetCode;
import java.util.*;
public class match_sticks_tosquare {
    public static void main(String[] args) {
        int[] arr={1,1,2,2,2};
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }
        if (sum%4!=0){
            System.out.println("not possible");
        }
        int side_len=sum/4;
        int[] side={side_len,side_len,side_len,side_len};
        Arrays.sort(arr);
        
        boolean ans=Helper(arr,side,side_len,arr.length-1);
        System.out.println(ans);
    }

    private static boolean Helper(int[] arr, int[] side, int side_len, int index) {
        if (index==-1){
            return allzeros(side);
        }
        for (int i = 0; i < side.length; i++) {
            if (arr[index]<=side[i]){
                side[i]-=arr[index];

            if (Helper(arr,side,side_len,index-1)){
                return true;
            }
            side[i]+=arr[index];
        }
        }
        return false;
    }

    private static boolean allzeros(int[] side) {
        for (int i = 0; i < side.length; i++) {
            if (side[i]>0){
                return false;
            }
        }
        return true;
    }
}
