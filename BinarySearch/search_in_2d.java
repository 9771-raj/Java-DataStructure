package BinarySearch;
import java.util.*;
public class search_in_2d {
    public static void main(String[] args) {
        int[][] map={
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        };
        int target=30;
        int r= 0;
        int n= map.length;
        int c=map[0].length;
        while (r<c){
            if (map[r][c-1]<target){
                r++;
            }
            else {
                break;
            }
        }


    }

    private static boolean binary_search(int target,int[] arr){
        int i=0;
        int n=arr.length;
        while (i<n){
            int mid=i+(n-i)/2;
            if (arr[mid]==target){
                return true;
            }
            if (arr[mid]<target){
                i=mid+1;
            }
            else {
                n=mid-1;
            }
        }
        return false;
    }
}
