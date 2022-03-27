package LCS;
              // minimum number of insertions and deletions to make one string from another
public class min_insert_delete {
    public static void main(String[] args) {
        String a="abcd";
        String b="bcd";
        int lcs=LCS(a,b);
        //System.out.println(lcs);
        System.out.println("Number of deletions ="+(a.length()-lcs));
        System.out.println("Number of insertions ="+(b.length()-lcs));
    }

    private static int LCS(String a, String b) {
        int n=a.length()+1;
        int w=b.length()+1;
        int[][] dp=new int[n][w];
        //initialize using base condition of recursive part
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < w; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        // choice diagram code
        // memorise how to change recursion choice diagram in topdown matrix
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < w; j++) {
                if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n-1][w-1];
    }
}
