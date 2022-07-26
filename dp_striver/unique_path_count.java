package dp_striver;

import java.lang.reflect.Array;
import java.util.Arrays;

public class unique_path_count {
    public static void main(String[] args) {

        int n=3;
        int m=3;
        int ans=recursion_unique_paths(n-1,m-1);
        System.out.println(ans);

        // memoization
        int[][] memory=new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memory[i],-1);
        }
        int ans2=memoization_path(n-1,m-1,memory);
        System.out.println(ans2);

        int ans3=unique_path_tabulation(n,m);
        System.out.println(ans3);

    }

    private static int recursion_unique_paths(int i, int j) {
        if (i==0 && j==0){
            return 1;
        }
        if (i<0 || j<0){
            return 0;
        }
        int a=recursion_unique_paths(i-1,j);
        int b=recursion_unique_paths(i,j-1);
        return a+b;
    }
    private static int memoization_path(int i,int j,int[][] memory){
        if (i==0 && j==0){
            return 1;
        }
        if (i<0 || j<0){
            return 0;
        }
        if (memory[i][j]!=-1){
            return memory[i][j];
        }
        int a=memoization_path(i-1,j,memory);
        int b=memoization_path(i,j-1,memory);
        return memory[i][j]=a+b;
    }

    // Tabulation
    private static int unique_path_tabulation(int n,int m){
        int[][] dp=new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i==0 && j==0){
                    dp[i][j]=1;
                }
                else{
                    int a=0;
                    int b=0;
                    if (i>0){
                        a=dp[i-1][j];
                    }
                    if (j>0){
                        b=dp[i][j-1];
                    }
                    dp[i][j]=a+b;
                }
            }
        }
        return dp[n-1][m-1];
    }
}
