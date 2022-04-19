package Arrays_problem;
import java.util.*;
public class square_and_sort {
    public static void main(String[] args) {
        int[] arr={-2,-4,-1,0,9,8,3,4,5};
        //int[] ans=new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]<0){
                arr[i]=-arr[i];
            }
        }
        System.out.println(Arrays.toString(arr));
        // sort the array using insertion sort
        for (int i = 1; i < arr.length; i++) {
            int temp=arr[i];
            int j=i-1;
            while (j>=0 && temp<=arr[j]) {
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
