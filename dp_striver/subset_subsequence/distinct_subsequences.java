package dp_striver.subset_subsequence;
import java.util.*;
public class distinct_subsequences {
    static int[][] mem;
    public static void main(String[] args) { // how many ways we can find t string in s
        String s="rabbbit";
        String t="rabit";
        mem=new int[s.length()][t.length()];
        for(int i=0;i<s.length();i++){
            Arrays.fill(mem[i],-1);
        }
        int ans=f(s.length()-1,t.length()-1,s,t);
        System.out.println(ans);

        //
        int ans3=tabulation_distinct(s,t);
        System.out.println(ans3);

    }
    private static int f(int i,int j,String s,String t){
        if(j<0) return 1;
        if(i<0) return 0;
        if(mem[i][j]!=-1) return mem[i][j];
        if(s.charAt(i)==t.charAt(j)){
            return mem[i][j]=f(i-1,j-1,s,t)+f(i-1,j,s,t);
        }
        return mem[i][j]=f(i-1,j,s,t);
    }

    private static int tabulation_distinct(String s,String t){
        int n=s.length();
        int m=t.length();
        int[][] dp=new int[n+1][m+1];
        for (int i = 0; i <=n; i++) {
            dp[i][0]=1;
        }
        for (int i = 1; i <=m; i++) {
            dp[0][i]=0;
        }
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=m; j++) {
                if (s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][m];
    }
}
