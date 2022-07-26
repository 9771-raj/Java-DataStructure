package dp_striver;

public class obstacle_path {
    public static void main(String[] args) {
        int[][] grid={
                {0,0,0},
                {0,-1,0},
                {0,0,0}
        };
        int ans=recursion(grid.length-1,grid[0].length-1,grid);
        System.out.println(ans);

        // tabulation
        int ans3=tabulation(grid.length,grid[0].length,grid);
        System.out.println(ans3);
    }

    private static int recursion(int i, int j,int[][] grid) {
        if (i>=0 && j>=0 && grid[i][j]==-1){
            return 0;
        }
        if (i==0 && j==0) return 1;
        if (i<0 || j<0){
            return 0;
        }
        int a=recursion(i-1,j,grid);
        int b=recursion(i,j-1,grid);
        return a+b;
    }
    private static int tabulation(int n,int m,int[][] grid){
        int[][] dp=new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]==-1){
                    dp[i][j]=0;
                }
                else if (i==0 && j==0){
                    dp[i][j]=1;
                }
                else{
                    int a=0;
                    int b=0;
                    if (i>0)
                        a=dp[i-1][j];
                    if (j>0)
                        b=dp[i][j-1];
                    dp[i][j]=a+b;
                }
            }
        }
        return dp[n-1][m-1];
    }
}
