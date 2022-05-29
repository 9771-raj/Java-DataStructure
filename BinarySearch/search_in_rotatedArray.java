package BinarySearch;
import java.util.*;
public class search_in_rotatedArray {
    public static void main(String[] args) {
        int[] arr={1,1,1,1,1,1,1,1,2,1,1,1,1,1};
        int target=2;
        int pivot=find_pivot(arr,target);
        System.out.println(pivot);
        int ans1=BinarySearch(arr,target,0,pivot);
        int ans2=BinarySearch(arr,target,pivot+1,arr.length-1);
        System.out.println(Math.max(ans1,ans2));

    }

    private static int find_pivot(int[] arr, int target) {
        int low=0;
        int high=arr.length-1;
        while (low<=high){
            int mid=low+(high-low)/2;
            if (mid<high && arr[mid]>arr[mid+1]){
                return mid;
            }
            if (mid>low && arr[mid-1]>arr[mid]){
                return mid-1;
            }
            if (arr[low]>=arr[mid]){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return -1;
    }

    private static int BinarySearch(int[] arr,int target,int low,int high){
        while (low<=high){
            int mid=low+(high-low)/2;
            if (target==arr[mid]){
                return mid;
            }
            if (arr[mid]>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return -1;
    }
}
