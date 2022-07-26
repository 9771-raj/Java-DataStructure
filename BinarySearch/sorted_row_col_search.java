package BinarySearch;
import java.util.*;
public class sorted_row_col_search {
    public static void main(String[] args) {
        int[][] arr={{ 3, 30, 38},
                    {36, 43, 60},
                    {40, 51, 69}};
        int target=51;

        boolean ans=search(target,arr);
        System.out.println(ans);
    }

    private static boolean search(int target, int[][] arr) {
        int i=0;
        int j=arr[0].length-1;
        int n=arr.length;
        while (i < n && j >= 0) {
            if (arr[i][j]==target){
                return true;
            }
            if (arr[i][j]>target){
                j--;
            }
            else {
                i++;
            }
        }
        return false;
    }
}
