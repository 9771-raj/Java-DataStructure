package divide_conquere;
import java.util.*;
public class Quick_sort {
    public static void main(String[] args) {
        int[] arr={1, 4, 2, 4, 2, 4, 1, 2, 4, 1, 2, 2, 2, 2, 4, 1, 4, 4, 4};

        QuickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    private static void QuickSort(int[] arr,int start,int end) {
        if (start>=end) return;
        int mid=start+(end-start)/2;
        int i=start;
        int j=end;
        int pivot=arr[mid];
        while (i<=j){
            while (arr[i]<pivot){
                i++;
            }
            while (arr[j]>pivot){
                j--;
            }
            if (i<=j){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j--;
            }
        }
        QuickSort(arr,start,j);
        QuickSort(arr,i,end);
    }
}
