package Arrays_problem;
import java.util.*;
class pair{
    int x;
    int y;
    pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}
public class matrix_01_bfs {
    public static void main(String[] args) {
        int[][] matrix={
                {0,1,1,1},{1,1,1,1},{1,1,1,1},{0,1,1,1}
        };
        Queue<pair> q=new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j]==0){
                    q.add(new pair(i,j));
                }
                if (matrix[i][j]==1){
                    matrix[i][j]=-matrix[i][j];
                }
            }
        }
        BFS(q,matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void BFS(Queue<pair> q, int[][] matrix) {
        while (!q.isEmpty()){
            pair p=q.peek();
            int x=p.x;
            int y=p.y;
            //left
            if (y<matrix[0].length-1){
                if (matrix[x][y+1]==-1){
                    matrix[x][y+1]=matrix[x][y]+1;
                    q.add(new pair(x,y+1));
                }
            }
            //down
            if (x<matrix.length-1){
                if (matrix[x+1][y]==-1){
                    matrix[x+1][y]=matrix[x][y]+1;
                    q.add(new pair(x+1,y));
                }
            }
            //right
            if (y>=1){
                if (matrix[x][y-1]==-1){
                    matrix[x][y-1]=matrix[x][y]+1;
                    q.add(new pair(x,y-1));
                }
            }
            //up
            if (x>=1){
                if (matrix[x-1][y]==-1){
                    matrix[x-1][y]=matrix[x][y]+1;
                    q.add(new pair(x-1,y));
                }
            }
            q.poll();
        }
    }
}
