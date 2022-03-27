package divide_conquere;
import java.util.*;
public class search_in_sorted_row_colum {
    public static void main(String[] args) {
        int[][] arr={{10,20,30,40},{11,25,35,45},{28,29,37,44}};
        int[] ans=search(arr,45);
        System.out.println(Arrays.toString(ans));
        System.out.println(arr.length);

    }
    private static int[] search(int[][] arr,int target){
        int r=0;   //row
        int c=arr[0].length-1;  //column
        while(c>=0 && r<arr[0].length){
            if(arr[r][c]==target){
                return new int[]{r,c};
            }
            if(arr[r][c]<target){
                r++;
            }
            else {
                c--;
            }
        }
        return new int[]{};
    }
}
