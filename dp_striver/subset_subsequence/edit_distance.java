package dp_striver.subset_subsequence;
import java.util.*;
public class edit_distance {      // 3 operation - insert, replace, delete  to make (s ---> t)  Minimum steps
    static int[][] mem;
    public static void main(String[] args) {
        String s="horse";
        String t="ros";
        mem=new int[s.length()][t.length()];
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(mem[i],-1);
        }
        int ans=recursion_editDistance(s.length()-1,t.length()-1,s,t);
        System.out.println(ans);

        //
        int ans3=tabulation_editDistance(s,t);
        System.out.println(ans3);
    }

    private static int recursion_editDistance(int i, int j, String s, String t) {
        if (i<0) return j+1;
        if (j<0) return i+1;
        if (mem[i][j]!=-1) return mem[i][j];
        if (s.charAt(i)==t.charAt(j)){
            return recursion_editDistance(i-1,j-1,s,t);
        }
        int a=1+recursion_editDistance(i,j-1,s,t);    // insertion
        int b=1+recursion_editDistance(i-1,j-1,s,t);  // replace
        int c=1+recursion_editDistance(i-1,j,s,t);  // delete
        return mem[i][j]=Math.min(a,Math.min(b,c));
    }

    private static int tabulation_editDistance(String s,String t){
        int n=s.length();
        int m=t.length();
        int[][] dp=new int[n+1][m+1];
        for (int i = 0; i <=m; i++) {
            dp[0][i]=i;
        }
        for (int i = 0; i <=n; i++) {
            dp[i][0]=i;
        }
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=m; j++) {
                if (s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else{
                    int a=dp[i][j-1];    // insertion
                    int b=dp[i-1][j-1];  // replace
                    int c=dp[i-1][j];  // delete
                    dp[i][j]=1+Math.min(a,Math.min(b,c));
                }
            }
        }
        return dp[n][m];
    }
}
