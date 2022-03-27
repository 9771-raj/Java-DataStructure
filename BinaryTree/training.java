package BinaryTree;

public class training {
    public static void main(String[] args) {
        int[] weight= {1,2,3,4,5};
        int[] profit= {2,1,5,2,3};
        int bagwt=9;
        int n=weight.length+1;
        int w=bagwt+1;
        int[][] dp=new int[n][w];
        // default initialize with 0s
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < w; j++) {
                if(weight[i-1]<=j){
                    dp[i][j]=Math.max(profit[i-1]+dp[i-1][j-weight[i-1]],dp[i-1][j]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n-2][w-2]);

        for(int i=0;i<n;i++) {
            for(int j=0;j<w;j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }

}
