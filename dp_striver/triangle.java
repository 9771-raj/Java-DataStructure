package dp_striver;

import java.util.Arrays;

public class triangle {
    public static void main(String[] args) {
        int[][] triangle={
                {1},
                {2,3},
                {4,5,6},
                {70,8,9,10}
        };
        int ans=recursion(triangle,0,0,triangle.length-1);
        System.out.println(ans);

        int[][] mem=new int[triangle.length][triangle.length];
        for (int i = 0; i < triangle.length; i++) {
            Arrays.fill(mem[i],-1);
        }
        int ans2=memoization(triangle,0,0,triangle.length-1,mem);
        System.out.println(ans2);

        int ans3=tabulation(triangle);
        System.out.println(ans3);
    }

    private static int recursion(int[][] triangle, int i, int j,int n) {
        if (n==i){
            return triangle[i][j];
        }

        int a=triangle[i][j]+recursion(triangle,i+1,j,n);
        int b=triangle[i][j]+recursion(triangle,i+1,j+1,n);
        int min=Math.min(a,b);
        return min;
    }

    private static int memoization(int[][] triangle,int i,int j,int n,int[][] mem){
        if (n==i){
            return triangle[i][j];
        }
        if (mem[i][j]!=-1){
            return mem[i][j];
        }
        int a=triangle[i][j]+memoization(triangle,i+1,j,n,mem);
        int b=triangle[i][j]+memoization(triangle,i+1,j+1,n,mem);
        int min=Math.min(a,b);
        return mem[i][j]=min;
    }

    static int tabulation(int[][] triangle){
        int[][] dp=new int[triangle.length][triangle.length];
        int n=triangle.length;
        for (int i = 0; i < n; i++) {
            dp[n-1][i]=triangle[n-1][i];
        }
        for (int i=n-2;i>=0;i--){
            for (int j=i;j>=0;j--){
                int a=triangle[i][j]+dp[i+1][j];
                int b=triangle[i][j]+dp[i+1][j+1];
                dp[i][j]=Math.min(a,b);
            }
        }
        return dp[0][0];
    }
}
