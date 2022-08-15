package divide_conquere;
import java.util.*;
/*

Given an array, find the total number of inversions of it.
If (i < j) and (A[i] > A[j]), then pair (i, j) is called an inversion of an array A. We need to count all such pairs in the array.
------> Brute can be done by two for loop
------> For optimal we have to apply with merge sort

*/
public class count_inversions {
    public static void main(String[] args) {
        int[] arr={1,9,6,4,5};
        int[] aux=Arrays.copyOf(arr,arr.length);

        int inversion=mergeSortInv(arr,aux,0,arr.length-1);
        System.out.println(inversion);


    }

    private static int mergeSortInv(int[] arr,int[] aux,int start,int end) {
        if (start>=end){
            return 0;
        }
        int invCount=0;
        int mid=start+(end-start)/2;
        invCount+=mergeSortInv(arr,aux,start,mid);
        invCount+=mergeSortInv(arr,aux,mid+1,end);
        invCount+=merge2arr(arr,aux,start,mid,end);
        return invCount;
    }

    private static int merge2arr(int[] arr, int[] aux, int start, int mid, int end) {
        int i=start;
        int j=mid+1;
        int k=start;
        int inv=0;
        while (i<=mid && j<=end){
            if (arr[i]<=arr[j]){
                aux[k++]=arr[i];
                i++;
            }
            else {
                inv+=(mid - i + 1); // for to count respective batch of sub array that can be inverted
                aux[k++]=arr[j];
                j++;
            }
        }
        while (i<=mid){
            aux[k++]=arr[i++];
        }
        while (j<=end){
            aux[k++]=arr[j++];
        }
        for (int l = start; l <=end; l++) {
            arr[l]=aux[l];
        }
        return inv;
    }

}
