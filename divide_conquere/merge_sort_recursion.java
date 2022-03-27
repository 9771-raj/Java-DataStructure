package divide_conquere;

import java.util.Arrays;

public class merge_sort_recursion {
    public static void main(String[] args) {
        int[] arr={5,4,3,2,1,9};
        merge_sort(arr,arr.length);
        System.out.println(Arrays.toString(arr));

    }
    public static void merge_sort(int[] arr,int n){
        if(n<2) return;
        int mid=n/2;
        int[] left=new int[mid];
        int[] right=new int[n-mid];
        for (int i = 0; i <mid; i++) {
            left[i]=arr[i];
        }
        for (int i = mid; i < n; i++) {
            right[i-mid]=arr[i];
        }
        merge_sort(left,mid);
        merge_sort(right,n-mid);
        merge(arr,left,right,mid,n-mid);
    }

    private static void merge(int[] a, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }

    }
}
