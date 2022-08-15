package Doubt_solving;
import java.util.*;
public class walmart {
    public static void main(String[] args) {
        int[] arr={1,3,4,2,2,2,2};
        int total=4;
        int min=f(0,total,total,arr);
        System.out.println(min);
    }

    private static int f(int index, int sum, int total, int[] arr) {

        if (sum==0){
            return 1;
        }
        if(sum<0 || index==arr.length){
            return 0;
        }


        int not_take=f(index+1,sum,total,arr);
        int take=Integer.MAX_VALUE;
        if (sum>0){
            take=Math.min(take,f(index+1,sum-arr[index],total,arr));
            //int b=f(index+1,sum,total,arr);

        }
        return take+not_take;
    }
}
