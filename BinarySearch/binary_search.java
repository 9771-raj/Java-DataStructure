package BinarySearch;

public class binary_search {
    public static void main(String[] args) {
        int[] arr={1,44,55,66,77,88,99};
        int target=11;
        boolean ans=Binary_search(arr,target);
        System.out.println(ans);
    }

    private static boolean Binary_search(int[] arr, int target) {
        int l=0;
        int r= arr.length-1;
        while (l<=r){
            int mid=l+(r-l)/2;
            if (arr[mid]==target){
                return true;
            }
            else if (arr[mid]>target){
                r=mid-1;
            }
            else if (arr[mid]<target){
                l=mid+1;
            }
        }
        return false;
    }

}
