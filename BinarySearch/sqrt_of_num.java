package BinarySearch;
import java.util.*;
public class sqrt_of_num {
    public static void main(String[] args) {
        int num=27;
        int i=0;
        int j=num;
        int ans=0;
        while (i<=j){
            int mid=i+(j-i)/2;

            if(mid*mid >num){
                j=mid-1;
            }
            else if (mid*mid <num){
                i=mid+1;
                ans=mid;
            }

        }
        System.out.println(ans);
    }
}
