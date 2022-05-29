package BinarySearch;
import java.util.Arrays;
public class finding_pivot {
    public static void main(String[] args) {
        int[] arr={11,22,33,3,4,6,7,8,9};
        int pivot=find_pivot(arr);
        // return -1 mean no rotated array
        System.out.println("Position were rotated array start = "+pivot);
    }

    private static int find_pivot(int[] arr) {
        int left=0;
        int right= arr.length-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if (mid<right && arr[mid]>arr[mid+1]){
                return mid;
            }
            if (left<mid && arr[mid-1]>arr[mid]){
                return mid;
            }
            if (arr[left]>=arr[mid]){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return -1;
    }


}
