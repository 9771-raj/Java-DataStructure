package divide_conquere;
import java.util.*;
public class selection_sort {
    public static void main(String[] args) {
        int[] arr={4,12,6,7,8,11,98,5};
        for (int i = 0; i < arr.length; i++) {
            int last= arr.length-i-1;
            int max_pre=finding_index(arr,0,last);
            int temp=arr[last];
            arr[last]=arr[max_pre];
            arr[max_pre]=temp;
            //System.out.println(max_pre);
        }
        System.out.println(Arrays.toString(arr));
    }

    private static int finding_index(int[] arr, int start, int last) {
        int max=arr[start];
        int i=start;
        for (int j = 0; j <=last; j++) {
            if(arr[j]>max){
                i=j;
                max=arr[j];
            }
        }
        return i;
    }
}
