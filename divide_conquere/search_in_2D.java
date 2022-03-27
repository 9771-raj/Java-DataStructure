package divide_conquere;
import java.util.*;
public class search_in_2D {
    public static void main(String[] args) {
        int[][] arr={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16},{17,18,19,20}};

        int[] ans=search(arr,11);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] search(int[][] arr,int target) {
        // we apply on first column
        int rStart=0;
        int rEnd=arr.length-1;
        int row=-1;
        int col=-1;
        while (rStart<=rEnd){
            int midRow=rStart+(rEnd-rStart)/2;
            if(arr[midRow][0]==target){
                return new int[]{midRow,0};
            }
            if(arr[midRow][0]>target){
                rEnd=midRow-1;
            }
            else{
                row=midRow;
                rStart=midRow+1;
            }
        }
        //for column
        col=binarySearch(arr[row],target);
        return new int[]{row,col};
    }

    private static int binarySearch(int[] arr, int target) {
        int r=0;
        int c=arr.length-1;
        while (r<=c){
            int mid=r+(c-r)/2;
            if(arr[mid]==target){
                return mid;
            }
            if(arr[mid]<target){
                r=mid+1;
            }
            else{
                c=mid-1;
            }
        }
        return -1;
    }
}
