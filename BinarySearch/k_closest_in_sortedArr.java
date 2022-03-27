package BinarySearch;
import java.util.*;
public class k_closest_in_sortedArr {
    // we can use insertion sort and find out where the target element to enter
    // then find its nearest k neighbours
    // this above approach give time complexity of O(n)
    public static void main(String[] args) {
        int[] arr={10, 12, 15, 17, 18, 20, 25};
        int k=4;
        int target=16;
        using_insertion(arr,target,k);
        System.out.println(Arrays.toString(arr));
    }

    private static void using_insertion(int[] arr, int target,int k) {
        for (int i = 1; i < arr.length; i++) {
            int j=i-1;
            int temp=arr[i];
            while (j>=0 && arr[j]>temp){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=temp;
        }

    }
}
