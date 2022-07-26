package divide_conquere;
import java.util.*;
public class revision_quick_sort {
    public static void main(String[] args) {
        int[] arr={4,2,1,7,8,9,11,32,15};
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int start, int end) {
        if (start>=end){
            return;
        }
        int pivot=find_pivot(arr,start,end);
        sort(arr,start,pivot-1);
        sort(arr,pivot+1,end);

    }

    private static int find_pivot(int[] arr, int start, int end) {
        int pivot_index=start;
        int pivot=arr[end];
        for (int i = start; i <end; i++) {
            if (arr[i]<=pivot){
                //swapping
                int temp=arr[i];
                arr[i]=arr[pivot_index];
                arr[pivot_index]=temp;
                // increase pivot index
                pivot_index+=1;
            }
        }
        int temp=arr[end];
        arr[end]=arr[pivot_index];
        arr[pivot_index]=temp;
        return pivot_index;

    }
}
