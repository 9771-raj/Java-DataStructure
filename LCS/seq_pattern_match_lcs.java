package LCS;

public class seq_pattern_match_lcs {
    public static void main(String[] args) {
        String a="axd";
        String b="adxcpy";
        Boolean ans=LCS(a,b);
        System.out.println(ans);
    }

    private static Boolean LCS(String a, String b) {
        int n=a.length()+1;
        int w=b.length()+1;
        int[][] dp=new int[n][w];
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
        if(a.length()==dp[n-1][w-1]){
            return true;
        }
        return false;
    }
}
