package LCS;

public class long_commn_subset {
    public static void main(String[] args) {
        String a="abcdgh";
        String b="gbcdgr";
        int n=a.length()+1;
        int w=b.length()+1;
        int[][] dp=new int[n][w];
        //initialize
        for (int i = 0; i <n; i++) {
            for (int j = 0; j < w; j++) {
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
            }
        }
        //choice diagram
        // Answer not in corner for this question we have to check for max in matrix
        int max=0;
        for (int i = 1; i <n; i++) {
            for (int j = 1; j < w; j++) {
                if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=0;
                }
                if(dp[i][j]>=max){
                    max=dp[i][j];
                }
            }
        }
        //print matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("Longest length of common substring = "+max);
    }


}
