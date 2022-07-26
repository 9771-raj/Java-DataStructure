package BinarySearch;
import java.util.*;
public class revision {
    public static void main(String[] args) {
        int[] arr={34,7,18,26};
        int pivot=find_pivot(arr,0,arr.length-1);
        System.out.println(pivot);
    }

    private static int find_pivot(int[] arr,int start,int end) {
        int i=0;
        int j=arr.length-1;
        while (i<=j){
            int mid=i+(j-i)/2;
            if (mid<end && arr[mid]>arr[mid+1]){
                return mid;
            }
            if (mid>start && arr[mid-1]>arr[mid]){
                return mid-1;
            }
            if (arr[start]<=arr[mid]){
                i=mid+1;
            }
            else{
                j=mid-1;
            }
        }
        return -1;

    }
}
