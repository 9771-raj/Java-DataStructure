package Recursion;
import java.util.*;
public class N_Queens {
    static ArrayList<ArrayList<String>> ans=new ArrayList<>();
    public static void main(String[] args) {
        int n=10;
        int m=10;
        String[][] grid=new String[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j]=".";
            }
        }

        solution(0,grid,n,m,ans);
        System.out.println(ans);

    }

    private static void solution(int col,String[][] grid, int n, int m, ArrayList<ArrayList<String>> ans) {
        if (col==m){
//            System.out.println("---------------------");
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < m; j++) {
//                    System.out.print(grid[i][j]+" ");
//                }
//                System.out.println();
//            }
            fill(grid);
            return;
        }
        for (int row=0;row<n;row++) {
            if (isSafe(grid,col,row,n)){
                grid[row][col]="Q";
                solution(col+1,grid,n,m,ans);
                grid[row][col]=".";
            }
        }
    }

    private static boolean isSafe(String[][] grid, int col, int row, int n) {
        // check upper diagonal
        int duprow=row;
        int dupcol=col;
        while (row>=0 && col>=0){
            if (grid[row][col]=="Q") return false;
            col--;
            row--;
        }
        // check column wise
        row=duprow;
        col=dupcol;
        while (col>=0){
            if (grid[row][col]=="Q") return false;
            col--;
        }
        // check row wise
        row=duprow;
        col=dupcol;
        while (row<n && col>=0){
            if (grid[row][col]=="Q") return false;
            col--;
            row++;
        }
        return true;
    }
    // if we want to return as list of list
    public static void fill(String[][] board) {
        ArrayList<String> ls = new ArrayList<>();
        int n = board.length;

        for(int i = 0;i < n ; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j= 0; j < n ; j++) {
                if(board[i][j]=="Q") sb.append('Q');
                else sb.append('.');
            }
            ls.add(sb+"");
        }
        ans.add(ls);
    }
}
