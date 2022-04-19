package Arrays_problem;
import java.util.*;
public class count_Neg_matrix {
    public static void main(String[] args) {
        int[][] arr={
                {4,3,2,-1},
                {3,2,1,-1},
                {1,1,-1,-2},
                {-1,-1,-2,-3}
        };
        int count=0;
        int row=0;
        int down=arr[0].length-1;
        while (row< arr.length){
            for (int i = down;i>=0; i--) {
                if (arr[row][i]<0){
                    count++;
                }
                if(arr[row][i]>0){
                    break;
                }

            }
            row++;
        }
        System.out.println(count);
    }
}
