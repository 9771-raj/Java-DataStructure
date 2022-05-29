package BinarySearch;
import java.util.Arrays;
public class search_in_rotatedARRAY2 {
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
        int start = 0;
        int end = arr.length - 1;
        while (start <= end ){
            int mid = start + (end - start)/2;
            if (mid < end && arr[mid] > arr[mid + 1]){
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]){
                return mid - 1;
            }
            if (arr[mid] == arr[start] && arr[mid] == arr[end]){

                if (start != arr.length - 1 && arr[start] > arr[start + 1]){
                    return start;
                }
                start++;

                if (end != 0 && arr[end] < arr[end - 1]){
                    return end - 1;
                }
                end--;
            }
            else if (arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])){
                start = mid + 1;
            }else{
                end = mid - 1;

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
