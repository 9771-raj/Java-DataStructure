package problems;
import java.util.*;
public class container_mostwater {
    public static void main(String[] args) {
        int[] arr={1,8,3,4,7,8,4};
        int i=0;
        int j=arr.length-1;
        int max=Integer.MIN_VALUE;
        while (i<j){
            if (arr[i]<arr[j]){
                int val=arr[i]*(j-i);
                if (max<val){
                    max=val;
                }
                i++;
            }
            else {
                if (arr[j]<arr[i]){
                    int val=arr[j]*(j-i);
                    if (max<val){
                        max=val;
                    }
                }
                j--;
            }
        }
        System.out.println(max);
    }

}
