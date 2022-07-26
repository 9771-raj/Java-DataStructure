package dp_striver;

import java.util.Arrays;

public class min_path_sum_right_down {
    public static void main(String[] args) {
        int[][] grid={
                {1,2,3},
                {4,5,6},
                {7,8,1}
        };
        int ans=recursion_minsum(2,2,grid);
        System.out.println(ans);

        int[][] memory=new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(memory[i],-1);
        }
        int ans2=memoization(2,2,grid,memory);
        System.out.println(ans2);

        int ans3=tabulation(grid);
        System.out.println("Tabulation = "+ans3);
    }

    private static int recursion_minsum(int n, int m,int[][] grid) {
        if (n==0 && m==0){
            return grid[n][m];
        }
        if (n<0 || m<0){
            return Integer.MAX_VALUE;
        }
        //return grid[n][m] + Math.min(recursion_minsum(n-1,m,grid),recursion_minsum(n,m-1,grid));
        int a=recursion_minsum(n-1,m,grid);
        int b=recursion_minsum(n,m-1,grid);
        return grid[n][m]+Math.min(a,b);
    }

    private static int memoization(int n,int m,int[][] grid,int[][] memory){
        if (n==0 && m==0) return grid[n][m];
        if (n<0 || m<0){
            return Integer.MAX_VALUE;
        }
        if (memory[n][m]!=-1){
            return memory[n][m];
        }
        return memory[n][m]=grid[n][m] + Math.min(memoization(n-1,m,grid,memory),memoization(n,m-1,grid,memory));
    }

    static int tabulation(int[][] grid){
        int[][] dp=new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i==0 && j==0){
                    dp[i][j]=grid[i][j];
                }
                else{
                    int down=grid[i][j];
                    if (i>0){
                        down+=dp[i-1][j];
                    }
                    else{
                        down+=1e9;
                    }

                    int right=grid[i][j];
                    if (j>0){
                        right+=dp[i][j-1];
                    }
                    else{
                        right+=1e9;
                    }
                    dp[i][j]=Math.min(right,down);
                }
            }
        }
        System.out.println("Dp Matrix --->");
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[grid.length-1][grid.length-1];
    }
}
