package divide_conquere;

public class binary_search {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,67,88};
        int target=2;
        int ans=binarySearch(arr,0,arr.length,target);
        System.out.println(ans);
    }

    private static int binarySearch(int[] arr, int start, int end,int target) {
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                return mid;
            }
            else if(arr[mid]<target){
                start=mid+1;
            }else{
                //System.out.println("hu");
                end=mid-1;
            }
        }
        return -1;
    }
}
