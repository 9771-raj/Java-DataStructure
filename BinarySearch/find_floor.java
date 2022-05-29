package BinarySearch;
import java.util.Arrays;
public class find_floor {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,6,7,11,45,89};
        int target=48;
        int start=0;
        int end=arr.length-1;
        int ans=Integer.MIN_VALUE;
        while (start<=end){
            int mid=start+(end-start)/2;
            if (arr[mid]==target){
                ans=Math.max(ans,arr[mid]);
                break;
            }
            if (arr[mid]>target){
                end=mid-1;
            }
            else {
                ans=Math.max(ans,arr[mid]);
                start=mid+1;
            }

        }
        System.out.println(ans);
    }
}
