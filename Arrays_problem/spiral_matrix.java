package Arrays_problem;
import java.util.*;
public class spiral_matrix {
    public static void main(String[] args) {
        int[][] arr={
                {1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}
        };
        ArrayList<Integer> ans=new ArrayList<>();
        solution(ans,arr);
        System.out.println(ans);
    }

    private static void solution(ArrayList<Integer> ans, int[][] arr) {

        int top=0;
        int down= arr.length-1;
        int left=0;
        int right=arr[0].length-1;
        int dir=0;
        while (top<=down && left<=right){
            if (dir==0){
                for (int i = left; i <=right; i++) {
                    ans.add(arr[top][i]);
                }
                top+=1;
            }
            else if (dir==1){
                for (int i = top; i <=down; i++) {
                    ans.add(arr[i][right]);
                }
                right-=1;
            }
            else if (dir==2){
                for (int i = right; i>=left ; i--) {
                    ans.add(arr[down][i]);
                }
                down-=1;
            }
            else if (dir==3){
                for (int i = down; i>=top; i--) {
                    ans.add(arr[i][left]);
                    //System.out.println(ans);
                }
                left+=1;
            }
            dir=(dir+1)%4;
        }

    }
}
