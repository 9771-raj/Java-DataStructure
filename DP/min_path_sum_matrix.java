package DP;

public class min_path_sum_matrix {
    public static void main(String[] args) {
        int[][] grid={{1,3,1},{1,5,1},{4,2,1}};

        int n=grid.length;
        int m=grid[0].length;
        int[][] dp=new int[n][m];
        dp[0][0]=grid[0][0];
        for(int i=1;i<n;i++){
            dp[i][0]=dp[i-1][0]+grid[i][0];
            //System.out.println(dp[i][0]);
        }
        for(int i=1;i<m;i++){
            dp[0][i]=dp[0][i-1]+grid[0][i];
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                System.out.println(Math.min(dp[i-1][j],dp[i][j-1]));
                dp[i][j]=grid[i][j]+Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
}
