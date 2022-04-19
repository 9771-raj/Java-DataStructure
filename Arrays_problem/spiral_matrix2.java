package Arrays_problem;
import java.util.*;
public class spiral_matrix2 {
    public static void main(String[] args) {
        int[][] arr={
                {1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}
        };
        int[][] result=new int[3][3];
        ArrayList<Integer> ans=new ArrayList<>();
        int n=3;
        solution(ans,n,result);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }
    private static void solution(ArrayList<Integer> ans, int n,int[][] result) {

        int top=0;
        int down= n-1;
        int left=0;
        int right=n-1;
        int dir=0;
        int k=1;
        while (top<=down && left<=right){
            if (dir==0){
                for (int i = left; i <=right; i++) {

                    result[top][i]=k++;
                }
                top+=1;
            }
            else if (dir==1){
                for (int i = top; i <=down; i++) {

                    result[i][right]=k++;
                }
                right-=1;
            }
            else if (dir==2){
                for (int i = right; i>=left ; i--) {

                    result[down][i]=k++;
                }
                down-=1;
            }
            else if (dir==3){
                for (int i = down; i>=top; i--) {

                    result[i][left]=k++;
                    //System.out.println(ans);
                }
                left+=1;
            }
            dir=(dir+1)%4;
        }

    }
}
