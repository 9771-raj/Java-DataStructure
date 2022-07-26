package dp_striver;
import java.util.*;
public class quad_min_path_sum_3dir {
    public static void main(String[] args) {
        int[][] grid={
                //{-1,0},{0,-1}
                {1,2,3,4},
                {5,6,7,8},
                {9,0,1,2},
                {1,2,3,4},
                {1,2,3,4}
        };
//        int ans=Integer.MIN_VALUE;
//        for (int i = 0; i < grid.length; i++) {
//            ans=Math.max(ans,recursion(0,i,grid,grid.length-1));
//        }
//        System.out.println(ans);

        // memoization


        int[][] memory=new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(memory[i],-1);
        }
        int ans2=Integer.MIN_VALUE;
        for (int i = 0; i < grid[0].length; i++) {
            ans2=Math.max(ans2,unordered_grid(0,i,grid,grid[0].length-1,memory));
        }
        System.out.println(ans2);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(memory[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static int recursion(int i, int j, int[][] grid,int n) {
        if (j<0 || j>n){
            return Integer.MIN_VALUE;
        }
        if (i==n){
            return grid[i][j];
        }

        int dir_b=grid[i][j]+recursion(i+1,j,grid,n);
        int dir_br=grid[i][j]+recursion(i+1,j+1,grid,n);
        int dir_bl=grid[i][j]+recursion(i+1,j-1,grid,n);
        int max=Math.max(dir_b,Math.max(dir_br,dir_bl));
        return max;

    }
    static int memoization(int i, int j, int[][] grid,int n,int[][] mem){
        if (j<0 || j>n){
            return Integer.MIN_VALUE;
        }
        if (i==n){
            return grid[i][j];
        }
        if (mem[i][j]!=-1){
            return mem[i][j];
        }

        int dir_b=grid[i][j]+memoization(i+1,j,grid,n,mem);
        int dir_br=grid[i][j]+memoization(i+1,j+1,grid,n,mem);
        int dir_bl=grid[i][j]+memoization(i+1,j-1,grid,n,mem);
        int max=Math.max(dir_b,Math.max(dir_br,dir_bl));
        return mem[i][j]=max;
    }

    // n*m
    static int unordered_grid(int i,int j,int[][] grid,int n,int[][] mem){
        if (j<0 || j>n){
            return -999999;
        }
        if (i==grid.length-1){
            return grid[i][j];
        }
        if (mem[i][j]!=-1){
            return mem[i][j];
        }

        int dir_b=grid[i][j]+unordered_grid(i+1,j,grid,n,mem);
        int dir_br=grid[i][j]+unordered_grid(i+1,j+1,grid,n,mem);
        int dir_bl=grid[i][j]+unordered_grid(i+1,j-1,grid,n,mem);
        int max=Math.max(dir_b,Math.max(dir_br,dir_bl));
        return mem[i][j]=max;
    }
//    static int tabulation(int[][] grid){
//        int[][] dp=new int[grid.length][grid[0].length];
//        for (int i = 0; i < grid[0].length; i++) {  // base
//            dp[0][i]=grid[0][i];
//        }
//        for (int i = 1; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//
//            }
//        }
//
//    }
}
