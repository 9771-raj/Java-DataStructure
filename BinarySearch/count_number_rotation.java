package BinarySearch;
import java.util.*;
// count number of times array is rotated
public class count_number_rotation {
    public static void main(String[] args) {
        int[] arr={4,5,6,7,1,2,3};
        int pivot=solution(arr,0,arr.length-1);
        System.out.println(pivot+1);

    }

    private static int solution(int[] arr, int start, int end) {

        while (start<=end){
            int mid=start+(end-start)/2;
            if (end>mid && arr[mid+1]<arr[mid]){
                return mid;
            }
            if (mid>start && arr[mid-1]>arr[mid]){
                return mid-1;
            }
            if (arr[start]>=arr[mid]){
                end=mid-1;
            }
            else {
                start=mid+1;
            }
        }
        return -1;
    }
}
