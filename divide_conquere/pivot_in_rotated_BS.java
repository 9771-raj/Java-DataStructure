package divide_conquere;

public class pivot_in_rotated_BS {
    public static void main(String[] args) {
        int[] arr={3,4,5,8,9,2,5,68};
        System.out.println(find_pivot(arr));

    }
    private static int find_pivot(int[] arr){
        int start=0;
        int end=arr.length;
        while (start<=end){
            int mid=start+(end-start)/2;
            if(mid<end && arr[mid]>arr[mid+1]){
                return mid;
            }
            if(start<mid && arr[mid]<arr[mid-1]){
                return mid-1;
            }
            if(arr[start]>=arr[mid]){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return -1;
    }
}
