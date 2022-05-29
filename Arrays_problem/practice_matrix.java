package Arrays_problem;
import java.util.*;
public class practice_matrix {
    public static void main(String[] args) {
        int[][] arr={
                {1,2,3},{4,5,6},{7,8,9}
        };
        int top=0;
        int left=0;
        int right= arr[0].length-1;
        int down=arr.length-1;
        int dir=0;
        ArrayList<Integer> ans=new ArrayList<>();
        while (left<=right && top<=down){
            if (dir==0){
                for (int i =left; i <=right; i++) {
                    ans.add(arr[top][i]);
                }
                top+=1;
            }
            else if (dir==1){
                for (int i=top;i<=down;i++){
                    ans.add(arr[i][right]);
                }
                right-=1;
            }
            else if (dir==2){
                for (int i=right;i>=left;i--){
                    ans.add(arr[down][i]);
                }
                down-=1;
            }
            else if (dir==3){
                for (int i=down;i>=top;i--){
                    ans.add(arr[i][left]);
                }
                left+=1;
            }
            dir=(dir+1)%4;
        }
        System.out.println(ans);
    }
}
