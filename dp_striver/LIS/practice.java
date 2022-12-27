package dp_striver.LIS;
import java.util.*;
public class practice {
    public static void main(String[] args) {
        int[] arr={4,12,10,0,-2,7,-8,9,-9,-12,-12,8,8};

        int ans=f(arr,0,Integer.MIN_VALUE,0);
        System.out.println(ans);





    }

    private static int f(int[] arr, int index, int prev,int k) {
        if (index==arr.length){
            return 0;
        }
        int a=0;
        if (prev==Integer.MIN_VALUE || arr[index]-prev==k){

            a=1+f(arr,index+1,arr[index],k);
        }
        else{

            a=Math.max(a,Math.max(f(arr,index+1,arr[index],k),f(arr,index+1,prev,k)));
        }
        System.out.println("-"+prev+" "+a);
        return a;
    }
}
