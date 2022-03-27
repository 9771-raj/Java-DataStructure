package divide_conquere;
import java.util.*;
public class quick_sort {
    public static void main(String[] args) {
        int[] arr={6,8,9,1,1,9,2,5};
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
    private static void sort(int[] arr,int start,int end){
        if(start>=end) return;
        int i=start;
        int j=end;
        int m=start+(end-start)/2;
        int pivot=arr[m];
        while(i<=j){
            while (arr[i]<pivot){
                i++;
            }
            while (arr[j]>pivot){
                j--;
            }
            if(i<=j){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j--;
            }
        }
        // recursion sort
        sort(arr,start,j);
        sort(arr,i,end);
    }
}
