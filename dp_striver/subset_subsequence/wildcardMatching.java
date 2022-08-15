package dp_striver.subset_subsequence;
import java.util.*;
public class wildcardMatching {
    static int[][] mem;
    public static void main(String[] args) {
        String s="*?";   // pattern           // ? - represent for any one letter  * - represent bunch-of letters
        String t="aabc";  // text for matching
        // recursion
        boolean ans=recMatching(s.length()-1,t.length()-1,s,t);
        System.out.println(ans);

        // memoization
        mem=new int[s.length()+1][t.length()+1];
        for (int i = 0; i <=s.length(); i++) {
            Arrays.fill(mem[i],-1);
        }
        boolean ans2=memoization_matching(s.length()-1,t.length()-1,s,t);
        System.out.println(ans2);
        //
        boolean ans3=tabulation_Matching(s,t);
        System.out.println(ans3);

    }

    private static boolean memoization_matching(int i, int j, String s, String t) {
        if (i<0 && j<0) return true;
        if (i<0 && j>=0) return false;
        if(j<0 && i>=0){
            for (int k = 0; k <=i; k++) {
                if (s.charAt(k)!='*'){
                    return false;
                }
            }
            return true;
        }
        if (mem[i][j]!=-1){
            if (mem[i][j]==1)
                return true;
            return false;
        }
        if (s.charAt(i)==t.charAt(j) || s.charAt(i)=='?'){
            boolean val=memoization_matching(i-1,j-1,s,t);
            mem[i][j]=val==true?1:0;
            return val;
        }
        boolean a=false;
        boolean b=false;
        if (s.charAt(i)=='*'){
            a=memoization_matching(i-1,j,s,t);
            b=memoization_matching(i,j-1,s,t);
            boolean d=a||b;
            mem[i][j]=d==true?1:0;
            return d;
        }
        mem[i][j]=0;
        return false;
    }

    private static boolean recMatching(int i, int j, String s, String t) {

        if (i<0 && j<0) return true;
        if (i<0 && j>=0) return false;
        if(j<0 && i>=0){
            for (int k = 0; k <=i; k++) {
                if (s.charAt(k)!='*'){
                    return false;
                }
            }
            return true;
        }
        if (s.charAt(i)==t.charAt(j) || s.charAt(i)=='?'){
            return recMatching(i-1,j-1,s,t);
        }
        boolean a=false;
        boolean b=false;
        if (s.charAt(i)=='*'){
            a=recMatching(i-1,j,s,t);
            b=recMatching(i,j-1,s,t);
            return a||b;
        }
        return false;
    }

    private static boolean tabulation_Matching(String s,String t){
        int n=s.length();
        int m=t.length();
        boolean[][] dp=new boolean[n+1][m+1];
        //base case
        dp[0][0]=true;
        for (int j = 1; j <=m; j++) {
            dp[0][j]=false;
        }
        for (int i = 1; i <=n ; i++) {
            if (s.charAt(i-1)=='*')
                dp[i][0]=true;
            else
                dp[i][0]=false;
        }
        //operations
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=m; j++) {
                if (s.charAt(i-1)==t.charAt(j-1) || s.charAt(i-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }
                boolean a=false;
                boolean b=false;
                if (s.charAt(i-1)=='*'){
                    a=dp[i-1][j];
                    b=dp[i][j-1];
                    dp[i][j]=a||b;
                }
                //return false;
            }
        }
        return dp[n][m];
    }
}
