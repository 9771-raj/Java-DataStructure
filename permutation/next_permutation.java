package permutation;
import java.util.*;
public class next_permutation {
    public static void main(String[] args) {
        int[] arr={3,4,2,1,5,6};
        if (arr==null || arr.length<=1){
            System.out.println(Arrays.toString(arr));
        }
        int i=arr.length-2;
        while (i>=0 && arr[i]>=arr[i+1]){
            i--;
        }
        if (i>=0){
            int j=arr.length-1;
            while (arr[j]<=arr[i]) j--;
            swap(arr,i,j);
        }
        reverse(arr,i+1,arr.length-1);
        System.out.println(Arrays.toString(arr));


    }
    public static void reverse(int[] nums,int i,int j){
        while (i<j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    public static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
