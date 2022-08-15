package Arrays_problem;
import java.util.*;
public class matrix_problem {
    public static void main(String[] args) {
        int[][] mat =
                {
                        { 1, 2, 3, 4 },
                        { 5, 6, 7, 8 },
                        { 9, 10, 11, 12 },
                        { 13, 14, 15, 16 }
                };
        transpose(mat); // In Place
        
    }

    private static void transpose(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = i+1; j < mat.length; j++) {
                int temp=mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=temp;
            }
        }
        //mat[0]=mat[1];
        for (int i = 0; i < mat.length; i++) {
            System.out.println(Arrays.toString(mat[i]));
        }
    }
}
